package features.folderManagement.domain.usecase

import features.folderManagement.domain.model.Folder
import features.folderManagement.domain.repository.FolderManagementRepository

class FetchAllFoldersUseCase(
    private val folderManagementRepository: FolderManagementRepository
) {
    suspend operator fun invoke(): List<Folder> {
        return folderManagementRepository.fetchAllFolders()
    }
}