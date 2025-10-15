package features.folderManagement.presentation.routes

import features.folderManagement.domain.usecase.FetchAllFoldersUseCase
import features.folderManagement.presentation.mappers.FolderMapper
import features.folderManagement.presentation.model.FolderDto

class FolderManagementController(
    private val fetchAllFoldersUseCase: FetchAllFoldersUseCase
) {
    suspend fun fetchAllFolders(): List<FolderDto> {
        return FolderMapper.mapToFolderDtoList(fetchAllFoldersUseCase())
    }
}