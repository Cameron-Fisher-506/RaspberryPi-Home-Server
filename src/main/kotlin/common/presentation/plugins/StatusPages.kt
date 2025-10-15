package common.presentation.plugins

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(cause.message ?: "")
        }

        status(HttpStatusCode.Unauthorized) { call, cause ->
            call.respondText(cause.description)
        }

        statusFile(HttpStatusCode.BadRequest, filePattern = "error#.html")
    }
}