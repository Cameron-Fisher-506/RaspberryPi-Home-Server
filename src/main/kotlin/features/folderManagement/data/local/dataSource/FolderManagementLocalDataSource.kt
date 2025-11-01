package features.folderManagement.data.local.dataSource

import common.data.local.database.DatabaseResponse
import features.folderManagement.data.local.model.entity.FolderEntity

interface FolderManagementLocalDataSource {
    suspend fun fetchAll(): List<FolderEntity>
    suspend fun saveFolder(folderEntity: FolderEntity): DatabaseResponse<FolderEntity>
}