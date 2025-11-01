package common.data.local.database

sealed class DatabaseResponse<out T> {
    data class Success<T>(val data: T): DatabaseResponse<T>()
    data class Error(val errorMessage: String): DatabaseResponse<Nothing>()
}