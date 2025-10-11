package za.co.raspberrypi.plugins

import io.ktor.server.resources.*
import io.ktor.server.application.Application
import io.ktor.server.application.install


fun Application.configureResources() {
    install(Resources)
}