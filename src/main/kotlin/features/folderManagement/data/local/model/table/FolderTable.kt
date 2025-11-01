package features.folderManagement.data.local.model.table

import org.jetbrains.exposed.sql.Table

object FolderTable : Table("folder") {
    val folderIdentifier = integer("folderIdentifier").autoIncrement()
    val name = varchar("name", 50)
    val userIdentifier = integer("userIdentifier")
    val parentIdentifier = integer("parentIdentifier").nullable()
    val createAt = varchar("createAt", 50)
    val updatedAt = varchar("updatedAt", 50)

    override val primaryKey = PrimaryKey(folderIdentifier)
}