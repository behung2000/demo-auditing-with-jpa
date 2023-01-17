package com.example.demoauditingwithjpa.services;

import com.example.demoauditingwithjpa.models.Book;
import com.example.demoauditingwithjpa.repositories.BookRepository;
import com.example.demoauditingwithjpa.responses.BookInfo;
import com.example.demoauditingwithjpa.responses.BookResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteBookService {
    @Autowired
    private BookRepository repository;
    public BookResponse create(BookInfo bookInfo) {
        Book book = Book.builder().build();
        BeanUtils.copyProperties(bookInfo, book);
        book.setActive(true);
        return save(book);
    }

    public BookResponse update(BookInfo bookInfo) {
        Book book = search(bookInfo.getId());
        BeanUtils.copyProperties(bookInfo, book);
        return save(book);
    }

    public BookResponse delete(Integer id) {
        Book book = search(id);
        book.setActive(false);
        return save(book);
    }

    private BookResponse save(Book book) {
        BookInfo bookInfo = BookInfo.builder().build();
        Book saved = repository.save(book);
        BeanUtils.copyProperties(saved, bookInfo);
        return BookResponse.builder().status(0).messenger(null).bookInfo(bookInfo).build();
    }

    private Book search(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }
}
