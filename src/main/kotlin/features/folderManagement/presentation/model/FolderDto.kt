package features.folderManagement.presentation.model

import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class FolderDto(
    val folderIdentifier: Int,
    val name: String,
    val userIdentifier: Int,
    val parentIdentifier: Int? = null,
    val createAt: String,
    val updatedAt: String
)