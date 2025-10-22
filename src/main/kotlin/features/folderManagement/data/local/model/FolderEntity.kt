package features.folderManagement.data.local.model

data class FolderEntity(
    val id: Int,
    val name: String,
    val parentId: Int? = null,
    val createAt: String
)