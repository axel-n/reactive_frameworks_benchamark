package com.example.demo.services

import com.example.demo.dto.BookCreateDto
import com.example.demo.dto.BookDto
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class BookService {
    suspend fun getBookById(uuid: UUID): BookDto {
        // TODO add delay from properties
        return BookDto(
            id = UUID.randomUUID(),
            name = "book name"
        )
    }

    suspend fun createBook(dto: BookCreateDto): UUID {
        // TODO add delay from properties
        return UUID.randomUUID()
    }
}
