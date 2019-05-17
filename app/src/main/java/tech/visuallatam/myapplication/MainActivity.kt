package tech.visuallatam.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import tech.visuallatam.myapplication.ViewModel.GithubViewModel
import tech.visuallatam.myapplication.datab.GithubRepo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this@MainActivity).get(GithubViewModel::class.java)

        btn_add.setOnClickListener {
            val name = et_repo.text.toString()
            if(name.isEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }
        viewModel.getAll().observe(this, Observer { repos->
            Log.d("Lista de repos", "_____________________________")
            for(repo in repos){
                Log.d("Lista de repos",repo.name)
            }
        })
    }
}
