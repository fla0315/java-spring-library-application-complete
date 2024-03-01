package com.group.libraryapprimi.service.book;

import com.group.libraryapprimi.domain.book.Book;
import com.group.libraryapprimi.domain.book.BookRepository;
import com.group.libraryapprimi.dto.book.request.BookCreatRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveBook(BookCreatRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

}
