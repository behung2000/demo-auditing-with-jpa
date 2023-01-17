package com.example.demoauditingwithjpa.controllers;

import com.example.demoauditingwithjpa.responses.BookInfo;
import com.example.demoauditingwithjpa.responses.BookResponse;
import com.example.demoauditingwithjpa.responses.BooksResponse;
import com.example.demoauditingwithjpa.services.ReadBookService;
import com.example.demoauditingwithjpa.services.WriteBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/spring/book")
public class BookController {
    private ReadBookService readBookService;
    private WriteBookService writeBookService;

    public BookController(ReadBookService readBookService, WriteBookService writeBookService) {
        this.readBookService = readBookService;
        this.writeBookService = writeBookService;
    }

    @GetMapping("")
    public BooksResponse getAllBooks(
            @RequestParam(required = false) Integer pageNo,
            @RequestParam(required = false) Integer pageSize) {
        pageNo = (pageNo == null || pageNo < 0) ? 0 : pageNo;
        pageSize = (pageSize == null || pageSize <= 0) ? 10 : pageSize;
        return readBookService.getAllBooks(pageNo, pageSize);
    }

    @PostMapping("")
    public BookResponse postBook(@RequestBody BookInfo bookInfo) {
        return writeBookService.create(bookInfo);
    }

    @PutMapping("")
    public BookResponse putBook(@RequestBody BookInfo bookInfo) {
        return writeBookService.update(bookInfo);
    }
}
