package com.example.demoauditingwithjpa.repositories;

import com.example.demoauditingwithjpa.models.Book;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan("com.example.demoauditingwithjpa.models")
public interface BookRepository extends JpaRepository<Book, Integer> {
}
