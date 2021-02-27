package com.example.demo

import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.json.Json
import io.vertx.ext.web.Router
import java.util.UUID
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

fun main() {
    val vertx = Vertx.vertx()
    val server = vertx.createHttpServer()
    val router = Router.router(vertx)

    val booksService = BooksService()

    router.get("/books/:id")
        .handler { ctx ->
            GlobalScope.async {
                val id = ctx.pathParam("id")
                val book = booksService.findBookById(UUID.fromString(id))
                ctx.response().toJson(book)
            }
        }

    server.requestHandler(router).listen(8080)

    println("running...")
}


fun HttpServerResponse.toJson(obj: Any) {
    putHeader("Content-Type", "application/json; charset=utf-8").end(Json.encode(obj))
}
