package com.example.sudoku

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sudoku.databinding.ActivityDifficultyBinding

class DifficultyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDifficultyBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        val shouldClose = intent.getBooleanExtra("shouldClose", false)
        if(shouldClose){
            finishAffinity()
        }

        super.onCreate(savedInstanceState)

        binding = ActivityDifficultyBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }
    fun startMyMainActivityEasy(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("difficulty", 20)
        startActivity(intent)
    }

    fun startMyMainActivityMedium(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("difficulty", 35)
        startActivity(intent)
    }

    fun startMyMainActivityHard(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("difficulty", 50)
        startActivity(intent)
    }
}