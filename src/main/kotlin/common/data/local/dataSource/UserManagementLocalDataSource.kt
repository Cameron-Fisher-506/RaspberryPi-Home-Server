package common.data.local.dataSource

import common.data.local.model.UserEntity
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class UserManagementLocalDataSource(
    private val database: Database
) {
    init {
        transaction(database) {
            SchemaUtils.create(UserEntity())
            UserEntity().insert {
                it[name] = "Cameron Fisher"
            }
        }
    }
}