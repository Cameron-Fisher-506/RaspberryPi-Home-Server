package features.folderManagement.data.repository

import features.folderManagement.data.local.dataSource.FolderManagementLocalDataSource
import features.folderManagement.data.local.mappers.FolderMapper
import features.folderManagement.domain.model.Folder
import features.folderManagement.domain.repository.FolderManagementRepository

class FolderManagementRepositoryImpl(
    private val folderManagementLocalDataSource: FolderManagementLocalDataSource
): FolderManagementRepository {
    override suspend fun fetchAllFolders(): List<Folder> {
        try {
            val folderEntityList = folderManagementLocalDataSource.fetchAll()
            return FolderMapper.mapToFolderList(folderEntityList)
        } catch (e: Exception) {
            throw e
        }
    }
}