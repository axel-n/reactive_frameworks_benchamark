package com.example.demo.config

import java.time.Duration
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "app")
data class AppProperties(
    val databaseMock: DatabaseMock = DatabaseMock()
) {

    data class DatabaseMock(

        val enabled: Boolean = true,

        val readDelay: DelayProperties = DelayProperties(
            min = Duration.ofMillis(50),
            max = Duration.ofMillis(100)
        ),

        val writeDelay: DelayProperties = DelayProperties(
            min = Duration.ofMillis(100),
            max = Duration.ofMillis(150)
        )
    )

    data class DelayProperties(
        val min: Duration,
        val max: Duration
    )

    fun printInfo(): String =
        "databaseMock properties=(" +
            "readDelay={" +
                "min=${databaseMock.readDelay.min.toMillis()}, " +
                "max=${databaseMock.readDelay.max.toMillis()}" +
            "}" +
            ", writeDelay={" +
                "min=${databaseMock.writeDelay.min.toMillis()}, " +
                "max=${databaseMock.writeDelay.max.toMillis()}" +
            "}" +
        ")"
}
