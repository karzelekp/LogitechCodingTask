package pl.karzelek.logitechcodingtask

import android.app.Application
import androidx.room.Room
import pl.karzelek.logitechcodingtask.db.TaskDatabase

class App : Application() {

    val database by lazy {
        Room.databaseBuilder(
            this,
            TaskDatabase::class.java,
            TaskDatabase.NAME
        ).build()
    }
}