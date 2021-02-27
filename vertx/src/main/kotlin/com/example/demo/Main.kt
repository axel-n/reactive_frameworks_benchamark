package com.example.demo


import io.vertx.core.AsyncResult
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServer
import io.vertx.core.http.HttpServerRequest

fun main() {

    Vertx.vertx()
        .createHttpServer()
        .requestHandler { req: HttpServerRequest ->
            req.response()
                .end("Hello World!")
        }
        .listen(8080) { handler: AsyncResult<HttpServer?> ->
            if (handler.succeeded()) {
                println("http://localhost:8080/")
            } else {
                println("Failed to listen on port 8080")
            }
        }
}

