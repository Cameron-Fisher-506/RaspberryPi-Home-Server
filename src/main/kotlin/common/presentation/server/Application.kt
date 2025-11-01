package common.presentation.server

import common.data.local.database.DatabaseFactory
import common.presentation.plugins.configureResources
import common.presentation.plugins.configureSerialization
import common.presentation.plugins.configureStatusPages
import features.fileManagement.presentation.plugins.configureFileManagementRouting
import features.folderManagement.presentation.routes.configureFolderManagementRouting
import io.ktor.server.application.*
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    val databaseFactory = DatabaseFactory()

    configureResources()
    configureSerialization()
    configureStatusPages()

    configureFileManagementRouting()
    configureFolderManagementRouting(databaseFactory.database)
}
