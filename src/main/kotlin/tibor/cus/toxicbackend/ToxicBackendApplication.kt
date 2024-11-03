package tibor.cus.toxicbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToxicBackendApplication

fun main(args: Array<String>) {
	runApplication<ToxicBackendApplication>(*args)
}
