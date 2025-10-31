package common.data.local.model

import org.jetbrains.exposed.sql.Table

class UserEntity: Table() {
    val userIdentifier = integer("userIdentifier").autoIncrement()
    val name = varchar("name", 50)
    override val primaryKey = PrimaryKey(userIdentifier)
}