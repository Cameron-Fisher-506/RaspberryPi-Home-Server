package features.folderManagement.data.local.mappers

import features.folderManagement.data.local.model.FolderEntity
import features.folderManagement.domain.model.Folder

object FolderMapper {
    fun mapToFolder(folderEntity: FolderEntity): Folder {
        return Folder(
            id = folderEntity.id,
            name = folderEntity.name,
            parentId = folderEntity.parentId,
            createAt = folderEntity.createAt
        )
    }

    fun mapToFolderEntity(folder: Folder): FolderEntity {
        return FolderEntity(
            id = folder.id,
            name = folder.name,
            parentId = folder.parentId,
            createAt = folder.createAt
        )
    }

    fun mapToFolderList(folderEntityList: List<FolderEntity>): List<Folder> {
        return folderEntityList.map { mapToFolder(it) }
    }

    fun mapToFolderEntityList(folderList: List<Folder>): List<FolderEntity> {
        return folderList.map { mapToFolderEntity(it) }
    }
}