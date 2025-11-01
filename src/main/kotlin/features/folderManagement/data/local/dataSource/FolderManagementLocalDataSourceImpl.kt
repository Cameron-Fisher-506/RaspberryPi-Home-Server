package features.folderManagement.data.local.dataSource

import common.data.local.database.DatabaseResponse
import features.folderManagement.data.local.model.entity.FolderEntity
import features.folderManagement.data.local.model.table.FolderTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class FolderManagementLocalDataSourceImpl(
    private val database: Database
): FolderManagementLocalDataSource {
    override suspend fun fetchAll(): List<FolderEntity> {
        return transaction(database) {
            SchemaUtils.create(FolderTable)
            FolderTable.selectAll().map { row ->
                FolderEntity(
                    folderIdentifier = row[FolderTable.folderIdentifier],
                    name = row[FolderTable.name],
                    userIdentifier = row[FolderTable.userIdentifier],
                    parentIdentifier = row[FolderTable.parentIdentifier],
                    createAt = row[FolderTable.createAt],
                    updatedAt = row[FolderTable.updatedAt]
                )
            }
        }
    }

    override suspend fun saveFolder(folderEntity: FolderEntity): DatabaseResponse<FolderEntity> {
        return transaction(database) {
            SchemaUtils.create(FolderTable)
            try {
                val result = FolderTable.insert {
                    it[FolderTable.folderIdentifier] = folderEntity.folderIdentifier
                    it[FolderTable.name] = folderEntity.name
                    it[FolderTable.userIdentifier] = folderEntity.userIdentifier
                    it[FolderTable.parentIdentifier] = folderEntity.parentIdentifier
                    it[FolderTable.createAt] = folderEntity.createAt
                    it[FolderTable.updatedAt] = folderEntity.updatedAt
                }.resultedValues?.firstOrNull()

                if (result != null) {
                    DatabaseResponse.Success(
                        FolderEntity(
                            folderIdentifier = result[FolderTable.folderIdentifier],
                            name = result[FolderTable.name],
                            userIdentifier = result[FolderTable.userIdentifier],
                            parentIdentifier = result[FolderTable.parentIdentifier],
                            createAt = result[FolderTable.createAt],
                            updatedAt = result[FolderTable.updatedAt]
                        )
                    )
                } else {
                    DatabaseResponse.Error("Failed to insert.")
                }
            } catch(e: Exception) {
                DatabaseResponse.Error(e.toString())
            }
        }
    }
}