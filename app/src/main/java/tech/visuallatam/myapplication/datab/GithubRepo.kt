package tech.visuallatam.myapplication.datab

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "repos")
data class GithubRepo (
    var name:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}