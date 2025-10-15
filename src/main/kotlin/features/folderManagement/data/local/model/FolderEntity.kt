package features.folderManagement.data.local.model

import java.util.Date

data class FolderEntity(
    val id: Int,
    val name: String,
    val parentId: Int? = null,
    val createAt: String,
    val itemType: String = "folder"
)