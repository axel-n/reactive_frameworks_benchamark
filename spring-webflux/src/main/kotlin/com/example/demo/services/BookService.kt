package com.example.demo.services

import com.example.demo.config.AppProperties
import com.example.demo.dto.BookCreateDto
import com.example.demo.dto.BookDto
import java.util.UUID
import kotlin.math.log
import kotlin.random.Random
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BookService(
    private val properties: AppProperties,
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    init {
        val isEnabledDatabaseMock = properties.databaseMock.enabled
        logger.info("BookService started. databaseMock=${isEnabledDatabaseMock}")

        if (isEnabledDatabaseMock) {
            logger.info(properties.printInfo())
        }
    }

    suspend fun getBookById(uuid: UUID): BookDto {
        if (properties.databaseMock.enabled) {
            getRandomDelay(readMinDelay, readMaxDelay)
        }

        return BookDto(
            id = UUID.randomUUID(),
            name = "book name"
        )
    }

    suspend fun createBook(dto: BookCreateDto): UUID {
        if (properties.databaseMock.enabled) {
            getRandomDelay(writeMinDelay, writeMaxDelay)
        }
        return UUID.randomUUID()
    }

    fun getRandomDelay(min: Long, max: Long): Long =
        Random.nextLong(min, max)

    private val readMinDelay: Long = properties.databaseMock.readDelay.min.toMillis()
    private val readMaxDelay: Long = properties.databaseMock.readDelay.max.toMillis()

    private val writeMinDelay: Long = properties.databaseMock.writeDelay.min.toMillis()
    private val writeMaxDelay: Long = properties.databaseMock.writeDelay.max.toMillis()
}
