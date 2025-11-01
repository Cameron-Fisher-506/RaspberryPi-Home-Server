package features.folderManagement.data.local.model.entity

data class FolderEntity(
    val folderIdentifier: Int,
    val name: String,
    val userIdentifier: Int,
    val parentIdentifier: Int?,
    val createAt: String,
    val updatedAt: String
)