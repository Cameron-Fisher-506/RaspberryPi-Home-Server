package features.folderManagement.data.repository

import common.data.local.database.DatabaseResponse
import common.domain.Result
import features.folderManagement.data.local.dataSource.FolderManagementLocalDataSource
import features.folderManagement.data.local.mappers.FolderMapper
import features.folderManagement.data.local.model.entity.FolderEntity
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

    override suspend fun saveFolder(folder: Folder): Result<Folder> {
        return when (val databaseResponse = folderManagementLocalDataSource.saveFolder(FolderMapper.mapToFolderEntity(folder))) {
            is DatabaseResponse.Success<FolderEntity> -> {
               Result.Success(FolderMapper.mapToFolder(databaseResponse.data))
            }
            is DatabaseResponse.Error -> {
                Result.Error(databaseResponse.errorMessage)
            }
        }
    }
}