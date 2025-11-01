package features.folderManagement.domain.usecase

import common.domain.Result
import features.folderManagement.domain.model.Folder
import features.folderManagement.domain.repository.FolderManagementRepository

class SaveFolderUseCase(
    private val folderManagementRepository: FolderManagementRepository
) {
    suspend operator fun invoke(folder: Folder): Result<Folder> {
        return folderManagementRepository.saveFolder(folder)
    }
}