package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tictactoe.databinding.ActivityGetStartedBinding

class GetStartedActivity : AppCompatActivity() {

    private val binding: ActivityGetStartedBinding by lazy {
        ActivityGetStartedBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.playerX.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            intent.putExtra("playerX",1)
            Toast.makeText(this, "Player X turns first", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
        binding.playerO.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            intent.putExtra("playerO",2)
            Toast.makeText(this, "Player O turns first", Toast.LENGTH_SHORT).show()

            startActivity(intent)
            finish()
        }

    }
}