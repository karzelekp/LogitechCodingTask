package pl.karzelek.logitechcodingtask.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import pl.karzelek.logitechcodingtask.company.Report

@Dao
interface ReportDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: Collection<Report>)
}