package com.group.libraryapprimi.controller.book;

import com.group.libraryapprimi.dto.book.request.BookCreatRequest;
import com.group.libraryapprimi.dto.book.request.BookLoanRequest;
import com.group.libraryapprimi.service.book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreatRequest request) {
        bookService.saveBook(request);
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {
        bookService.loanBook(request);
    }

}
