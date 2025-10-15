package features.folderManagement.presentation.routes

import features.folderManagement.data.local.dataSource.FolderManagementLocalDataSourceImpl
import features.folderManagement.data.repository.FolderManagementRepositoryImpl
import features.folderManagement.domain.usecase.FetchAllFoldersUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureFolderManagementRouting() {
    val folderManagementController = FolderManagementController(
        FetchAllFoldersUseCase(
            FolderManagementRepositoryImpl(
                FolderManagementLocalDataSourceImpl()
            )
        )
    )
    routing {
        get("/folder") {
            val parentIdParam = call.request.queryParameters["parentId"]
            val parentId = parentIdParam?.toIntOrNull()

            if (parentIdParam != null && parentId == null) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid parent identifier. The parent identifier must be an Integer."
                )
                return@get
            }

            val folderDtoList = folderManagementController.fetchAllFolders()
            call.respond(HttpStatusCode.OK, folderDtoList)
        }
    }
}