package features.folderManagement.presentation.model

import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class FolderDto(
    val id: Int,
    val name: String,
    val parentId: Int? = null,
    val createAt: String,
    val itemType: String = "folder"
)