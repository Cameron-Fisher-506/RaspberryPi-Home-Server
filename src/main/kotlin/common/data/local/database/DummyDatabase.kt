package common.data.local.database

import features.folderManagement.data.local.model.FolderEntity
import java.util.Date

object DummyDatabase {
    val folderStore = mutableListOf(
        FolderEntity(0, "Documents", null, Date().time.toString())
    )

    init {
        folderStore.addAll(
            listOf(
                FolderEntity(1, "Photos", null, Date().time.toString()),
                FolderEntity(2, "Projects", null, Date().time.toString()),

                FolderEntity(3, "Vacation", 1, Date().time.toString()),
                FolderEntity(4, "Work", 1, Date().time.toString()),

                FolderEntity(5, "Invoices", 0, Date().time.toString())
            )
        )
    }
}