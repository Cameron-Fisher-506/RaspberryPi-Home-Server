package features.fileManagement.presentation.plugins

import io.ktor.http.HttpMethod
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.server.application.*
import io.ktor.server.request.receiveMultipart
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.cio.writeChannel
import io.ktor.utils.io.copyAndClose
import java.io.File

fun Application.configureFileManagementRouting() {
    install(RoutingRoot) {
        route("/", HttpMethod.Get) {
            handle {
                call.respondText("Hello")
            }
        }
    }

    routing {
        post("/upload") {
            val data = call.receiveMultipart(formFieldLimit = 1024 * 1024 * 50)

            val fields = mutableMapOf<String, MutableList<String>>()

            data.forEachPart { part ->
                when (part) {
                    is PartData.FormItem -> {
                        val key = part.name ?: return@forEachPart
                        fields.getOrPut(key) { mutableListOf() }.add(part.value)
                        part.dispose()
                    }

                    is PartData.FileItem -> {
                        val key = part.name ?: return@forEachPart
                        val fileName = part.originalFileName ?: return@forEachPart
                        fields.getOrPut(key) { mutableListOf() }.add(fileName)

                        val file = File("uploads/$fileName").apply {
                            parentFile.mkdirs()
                        }
                        part.provider().copyAndClose(file.writeChannel())
                        part.dispose()
                    }

                    else -> {

                    }
                }
            }
            call.respond("Form fields: $fields")
        }
    }
}
