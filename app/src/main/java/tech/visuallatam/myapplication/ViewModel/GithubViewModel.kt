package tech.visuallatam.myapplication.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.visuallatam.myapplication.datab.GithubDataBase
import tech.visuallatam.myapplication.datab.GithubRepo
import tech.visuallatam.myapplication.repository.GithubRepository

class GithubViewModel(app:Application): AndroidViewModel(app) {

    private val repository: GithubRepository

    init {
        val repoDao = GithubDataBase.getInstance(app).repoDAO()
        repository = GithubRepository(repoDao)
    }

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()

    fun delete() = repository.delete()

}