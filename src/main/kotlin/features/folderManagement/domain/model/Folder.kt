package features.folderManagement.domain.model

import java.util.*

data class Folder(
    val id: Int,
    val name: String,
    val parentId: Int? = null,
    val createAt: String,
    val itemType: String = "folder"
)