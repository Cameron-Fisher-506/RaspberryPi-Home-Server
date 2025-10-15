package features.folderManagement.data.local.dataSource

import features.folderManagement.data.local.model.FolderEntity

interface FolderManagementLocalDataSource {
    suspend fun fetchAll(): List<FolderEntity>
}