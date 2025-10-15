package features.folderManagement.presentation.mappers

import features.folderManagement.domain.model.Folder
import features.folderManagement.presentation.model.FolderDto

object FolderMapper {
    fun mapToFolder(folderDto: FolderDto): Folder {
        return Folder(
            id = folderDto.id,
            name = folderDto.name,
            itemType = folderDto.itemType,
            parentId = folderDto.parentId,
            createAt = folderDto.createAt
        )
    }

    fun mapToFolderDto(folder: Folder): FolderDto {
        return FolderDto(
            id = folder.id,
            name = folder.name,
            itemType = folder.itemType,
            parentId = folder.parentId,
            createAt = folder.createAt
        )
    }

    fun mapToFolderList(folderEntityList: List<FolderDto>): List<Folder> {
        return folderEntityList.map { mapToFolder(it) }
    }

    fun mapToFolderDtoList(folderList: List<Folder>): List<FolderDto> {
        return folderList.map { mapToFolderDto(it) }
    }
}