package com.example.demoauditingwithjpa.services;

import com.example.demoauditingwithjpa.models.Book;
import com.example.demoauditingwithjpa.repositories.BookRepository;
import com.example.demoauditingwithjpa.responses.BooksResponse;
import com.example.demoauditingwithjpa.utils.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ReadBookService {
    @Autowired
    BookRepository repository;

    public BooksResponse getAllBooks(Integer pageNo, Integer pageSize) {
        PageRequest page = PageRequest.of(pageNo, pageSize);
        EntityMapper mapper = new EntityMapper();
        Page<Book> bookPage = repository.findAll(page);
        return mapper.toBooksResponse(bookPage);
    }
}
