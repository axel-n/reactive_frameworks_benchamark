package com.example.demo

import java.util.UUID

class BooksService {
     suspend fun findBookById(uuid: UUID): BookDto {
        return BookDto(
            id = UUID.randomUUID(),
            name = "book name"
        )
    }
}
