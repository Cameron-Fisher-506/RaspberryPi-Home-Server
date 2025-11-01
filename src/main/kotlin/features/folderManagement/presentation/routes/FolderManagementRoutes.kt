package features.folderManagement.presentation.routes

import common.data.local.database.DatabaseFactory
import common.presentation.ApiResponse
import features.folderManagement.data.local.dataSource.FolderManagementLocalDataSourceImpl
import features.folderManagement.data.repository.FolderManagementRepositoryImpl
import features.folderManagement.domain.usecase.FetchAllFoldersUseCase
import features.folderManagement.domain.usecase.SaveFolderUseCase
import features.folderManagement.presentation.model.FolderDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.Database

fun Application.configureFolderManagementRouting(database: Database) {
    val folderManagementController = FolderManagementController(
        FetchAllFoldersUseCase(
            FolderManagementRepositoryImpl(
                FolderManagementLocalDataSourceImpl(database)
            )
        ),
        SaveFolderUseCase(FolderManagementRepositoryImpl(
            FolderManagementLocalDataSourceImpl(database)
        ))
    )
    routing {
        get("/folders") {
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

        post("/folder") {
            val folderDto = call.receive<FolderDto>()
            when(val apiResponse = folderManagementController.create(folderDto)) {
                is ApiResponse.Success<FolderDto> -> {
                    call.respond(HttpStatusCode.OK, apiResponse.data)
                }
                is ApiResponse.Error -> {
                    call.respond(HttpStatusCode.BadRequest, apiResponse.message)
                }
            }
        }
    }
}