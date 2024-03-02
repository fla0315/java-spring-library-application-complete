package com.group.libraryapprimi.service.book;

import com.group.libraryapprimi.domain.book.Book;
import com.group.libraryapprimi.domain.book.BookRepository;
import com.group.libraryapprimi.domain.user.User;
import com.group.libraryapprimi.domain.user.UserRepository;
import com.group.libraryapprimi.dto.book.request.BookCreatRequest;
import com.group.libraryapprimi.dto.book.request.BookLoanRequest;
import com.group.libraryapprimi.dto.book.request.BookReturnRequest;
import com.group.libraryapprimi.dto.user.loanhistory.UserLoanHistory;
import com.group.libraryapprimi.dto.user.loanhistory.UserLoanHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository,
                       UserLoanHistoryRepository userLoanHistoryRepository,
                       UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreatRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        //1. 책 정보를 가져온다.
        Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalArgumentException::new);

        //2. 대출기록 정보를 확인해서 대출중인지 확인합니다.
        //3. 만약 확인했는데 대출 중이라면 예외를 발생시킵니다.
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException("이미 대출되어 있는 책입니다.");
        }

        //4. 유저 정보를 가져온다.
        User user = userRepository.findByName(request.getUserName())
                                  .orElseThrow(IllegalArgumentException::new);

        //5. 유저 정보와 책 정보를 기반으로 UserLoanHistory를 저장
        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), book.getName()));

    }

    @Transactional
    public void returnBook(BookReturnRequest request) {

        //1. 유저 정보를 get
        User user = userRepository.findByName(request.getUserName())
                                  .orElseThrow(IllegalAccessError::new);

        UserLoanHistory userLoanHistory = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(),
                                                                                            request.getBookName())
                                                                   .orElseThrow(IllegalArgumentException::new);

        userLoanHistory.doReturn();

        // @Transactional을 사용하기 때문에 영속성으로 인해
        // save 처리를 해주지 않아도 변경을 감지하고 수정한다.

//        userLoanHistoryRepository.save(new UserLoanHistory(userLoanHistory.getUserId(),
//                                                           userLoanHistory.getBookName(),
//                                                           userLoanHistory.doReturn()));

    }

}
