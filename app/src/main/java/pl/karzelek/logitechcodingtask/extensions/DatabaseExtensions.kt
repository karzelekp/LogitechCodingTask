package pl.karzelek.logitechcodingtask.extensions

import androidx.room.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

suspend fun RoomDatabase.clearAllTablesSuspend() = withContext(Dispatchers.IO) {
    clearAllTables()
}

suspend fun RoomDatabase.runInTransactionSuspend(block: suspend () -> Unit) =
    withContext(Dispatchers.IO) {
        runInTransaction { runBlocking { block.invoke() } }
    }