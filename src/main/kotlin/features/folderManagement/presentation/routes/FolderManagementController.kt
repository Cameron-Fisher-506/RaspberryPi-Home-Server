package features.folderManagement.presentation.routes

import common.presentation.ApiResponse
import common.domain.Result
import features.folderManagement.domain.model.Folder
import features.folderManagement.domain.usecase.FetchAllFoldersUseCase
import features.folderManagement.domain.usecase.SaveFolderUseCase
import features.folderManagement.presentation.mappers.FolderMapper
import features.folderManagement.presentation.model.FolderDto

class FolderManagementController(
    private val fetchAllFoldersUseCase: FetchAllFoldersUseCase,
    private val saveFolderUseCase: SaveFolderUseCase
) {
    suspend fun fetchAllFolders(): List<FolderDto> {
        return FolderMapper.mapToFolderDtoList(fetchAllFoldersUseCase())
    }

    suspend fun create(folderDto: FolderDto): ApiResponse<FolderDto> {
        return when (val result = saveFolderUseCase(FolderMapper.mapToFolder(folderDto))) {
            is Result.Success<Folder> -> {
                ApiResponse.Success(FolderMapper.mapToFolderDto(result.data))
            }
            is Result.Error -> {
                ApiResponse.Error(result.message)
            }
        }
    }
}