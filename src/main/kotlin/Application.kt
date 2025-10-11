package za.co.raspberrypi

import io.ktor.server.application.*
import za.co.raspberrypi.plugins.configureResources
import za.co.raspberrypi.plugins.configureRouting
import za.co.raspberrypi.plugins.configureSerialization

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureResources()
    configureRouting()
    configureSerialization()
}
