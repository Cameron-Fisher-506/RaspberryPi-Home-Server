package features.folderManagement.domain.repository

import features.folderManagement.domain.model.Folder

interface FolderManagementRepository {
    suspend fun fetchAllFolders(): List<Folder>
}