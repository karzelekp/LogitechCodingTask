package pl.karzelek.logitechcodingtask.db

import androidx.lifecycle.LiveData
import androidx.room.*
import pl.karzelek.logitechcodingtask.company.Employee

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: Collection<Employee>)

    @Query("SELECT * FROM employees")
    fun getAll(): LiveData<List<Employee>>

    @Query("SELECT * FROM employees")
    @Transaction
    fun getEmployeesWithReports(): LiveData<List<EmployeeWithReports>>
}
