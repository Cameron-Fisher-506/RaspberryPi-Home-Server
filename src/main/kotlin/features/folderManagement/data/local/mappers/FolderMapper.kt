package features.folderManagement.data.local.mappers

import features.folderManagement.data.local.model.entity.FolderEntity
import features.folderManagement.domain.model.Folder

object FolderMapper {
    fun mapToFolder(folderEntity: FolderEntity): Folder {
        return Folder(
            folderIdentifier = folderEntity.folderIdentifier,
            name = folderEntity.name,
            userIdentifier = folderEntity.userIdentifier,
            parentIdentifier = folderEntity.parentIdentifier,
            createAt = folderEntity.createAt,
            updatedAt = folderEntity.updatedAt
        )
    }

    fun mapToFolderEntity(folder: Folder): FolderEntity {
        return FolderEntity(
            folderIdentifier = folder.folderIdentifier,
            name = folder.name,
            userIdentifier = folder.userIdentifier,
            parentIdentifier = folder.parentIdentifier,
            createAt = folder.createAt,
            updatedAt = folder.updatedAt
        )
    }

    fun mapToFolderList(folderEntityList: List<FolderEntity>): List<Folder> {
        return folderEntityList.map { mapToFolder(it) }
    }

    fun mapToFolderEntityList(folderList: List<Folder>): List<FolderEntity> {
        return folderList.map { mapToFolderEntity(it) }
    }
}