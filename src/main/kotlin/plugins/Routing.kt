package za.co.raspberrypi.plugins

import io.ktor.http.HttpMethod
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(RoutingRoot) {
        route("/", HttpMethod.Get) {
            handle {
                call.respondText("Hello")
            }
        }
    }

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("blog/{id}") {
            val id = call.parameters["id"]
            call.respondText("blog with id $id")
        }
    }
}
