package pl.karzelek.logitechcodingtask.db

import androidx.lifecycle.LiveData
import androidx.room.*
import pl.karzelek.logitechcodingtask.company.Employee

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(employees: Collection<Employee>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employee: Employee): Long

    @Query("SELECT * FROM employees")
    fun getAll(): LiveData<List<Employee>>

    @Query("SELECT * FROM employees")
    @Transaction
    fun getEmployeesWithReports(): LiveData<List<EmployeeWithReports>>

    @Query("SELECT * FROM employees WHERE name = :name")
    @Transaction
    fun getEmployeesWithReports(name: String): LiveData<List<EmployeeWithReports>>
}

suspend fun EmployeeDao.insertAndUpdateId(vararg employees: Employee) = employees.forEach {
    it.employeeId = insert(it)
}
