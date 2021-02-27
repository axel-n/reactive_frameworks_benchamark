package com.example.demo

import java.util.UUID
import kotlin.random.Random

class BooksService {
    suspend fun findBookById(uuid: UUID): BookDto {

        getRandomDelay(150, 200)

        return BookDto(
            id = UUID.randomUUID(),
            name = "book name"
        )
    }

    private fun getRandomDelay(min: Long, max: Long): Long =
        Random.nextLong(min, max)
}
