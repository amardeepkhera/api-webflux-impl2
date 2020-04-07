package au.com.spike

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(argss: Array<String>) {
    runApplication<Application>(*argss)
}