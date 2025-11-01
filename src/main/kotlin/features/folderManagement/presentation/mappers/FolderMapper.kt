package features.folderManagement.presentation.mappers

import features.folderManagement.domain.model.Folder
import features.folderManagement.presentation.model.FolderDto

object FolderMapper {
    fun mapToFolder(folderDto: FolderDto): Folder {
        return Folder(
            folderIdentifier = folderDto.folderIdentifier,
            name = folderDto.name,
            userIdentifier = folderDto.userIdentifier,
            parentIdentifier = folderDto.parentIdentifier,
            createAt = folderDto.createAt,
            updatedAt = folderDto.updatedAt
        )
    }

    fun mapToFolderDto(folder: Folder): FolderDto {
        return FolderDto(
            folderIdentifier = folder.folderIdentifier,
            name = folder.name,
            userIdentifier = folder.userIdentifier,
            parentIdentifier = folder.parentIdentifier,
            createAt = folder.createAt,
            updatedAt = folder.updatedAt
        )
    }

    fun mapToFolderList(folderEntityList: List<FolderDto>): List<Folder> {
        return folderEntityList.map { mapToFolder(it) }
    }

    fun mapToFolderDtoList(folderList: List<Folder>): List<FolderDto> {
        return folderList.map { mapToFolderDto(it) }
    }
}