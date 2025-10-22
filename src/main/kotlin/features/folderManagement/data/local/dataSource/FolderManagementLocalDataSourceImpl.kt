package features.folderManagement.data.local.dataSource

import common.data.local.database.DummyDatabase
import features.folderManagement.data.local.model.FolderEntity

class FolderManagementLocalDataSourceImpl(
): FolderManagementLocalDataSource {
    override suspend fun fetchAll(): List<FolderEntity> {
        return DummyDatabase.folderStore
    }
}