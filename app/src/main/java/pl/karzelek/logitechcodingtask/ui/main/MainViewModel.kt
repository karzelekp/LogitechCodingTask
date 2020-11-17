package pl.karzelek.logitechcodingtask.ui.main

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.karzelek.logitechcodingtask.App
import pl.karzelek.logitechcodingtask.db.Repository

class MainViewModel(application: App) : AndroidViewModel(application) {

    private val repository = Repository(application)

    val johnEmployeesLiveData = repository.johnEmployeesLiveData

    fun onActivityCreated() {
        viewModelScope.launch {
            repository.saveTestData()
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(private val application: App) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return (if (modelClass == MainViewModel::class.java) MainViewModel(application) as T
            else throw IllegalArgumentException("unknown modelClass"))
        }
    }
}