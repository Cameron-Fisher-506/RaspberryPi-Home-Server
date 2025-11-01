package features.folderManagement.domain.repository

import common.domain.Result
import features.folderManagement.domain.model.Folder

interface FolderManagementRepository {
    suspend fun fetchAllFolders(): List<Folder>
    suspend fun saveFolder(folder: Folder): Result<Folder>
}