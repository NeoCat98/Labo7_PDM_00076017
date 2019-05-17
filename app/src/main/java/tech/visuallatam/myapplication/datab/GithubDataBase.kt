package tech.visuallatam.myapplication.datab

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GithubRepo::class], version = 1,exportSchema = false)
public abstract  class GithubDataBase: RoomDatabase() {
    abstract fun repoDAO():GithubDAO

    companion object {
        private var INSTANCE: GithubDataBase? = null

        fun getInstance(context: Context): GithubDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance
            synchronized(this){
                 val instance = Room.databaseBuilder(context,GithubDataBase::class.java,"repoBD").build()
                INSTANCE =  instance
                return instance
            }
        }
    }
}