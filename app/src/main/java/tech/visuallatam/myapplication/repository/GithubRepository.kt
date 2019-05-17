package tech.visuallatam.myapplication.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import tech.visuallatam.myapplication.datab.GithubDAO
import tech.visuallatam.myapplication.datab.GithubRepo

class GithubRepository (private val repoDao: GithubDAO){

    @WorkerThread
    suspend fun insert(repo: GithubRepo){
        repoDao.insertarRepo(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun delete() = repoDao.deletaTable()
}