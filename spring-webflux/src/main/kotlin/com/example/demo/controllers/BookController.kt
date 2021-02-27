package com.example.demo.controllers

import com.example.demo.dto.BookCreateDto
import com.example.demo.dto.BookDto
import com.example.demo.services.BookService
import java.util.UUID
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    private val bookService: BookService
) {

    @GetMapping("/books/{uuid}")
    suspend fun getBookById(@PathVariable uuid: UUID): BookDto =
        bookService.getBookById(uuid)

    @PostMapping("/books")
    suspend fun createBook(@RequestBody dto: BookCreateDto): UUID =
        bookService.createBook(dto)
}
