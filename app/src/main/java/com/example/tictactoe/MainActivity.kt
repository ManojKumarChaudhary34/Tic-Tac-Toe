package com.example.tictactoe

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tictactoe.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    var currentPlayer = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val playerX = intent.getIntExtra("playerX", 0)
        val playerO = intent.getIntExtra("playerO", 0)
        currentPlayer= playerX
    }


    fun onClickFun(view: View) {
        val button: ImageView = view as ImageView
        var cellID = 0
        when (button.id) {
            R.id.imageButton2 -> cellID = 1
            R.id.imageButton7 -> cellID = 2
            R.id.imageButton10 -> cellID = 3
            R.id.imageButton8 -> cellID = 4
            R.id.imageButton3 -> cellID = 5
            R.id.imageButton9 -> cellID = 6
            R.id.imageButton6 -> cellID = 7
            R.id.imageButton5 -> cellID = 8
            R.id.imageButton4 -> cellID = 9
        }
//        Log.d("tag", "$cellID")
        playNow(button, cellID)
        checkWinner()

    }

    private fun checkWinner() {
        var winner = 0
        //row for player1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
//        column for player1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
//        diagonal for player1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        //row for player2
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
//        column for player2
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
//        diagonal for player1
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }
        if (winner == 1) {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.show()
            val btnOk = dialog.findViewById<Button>(R.id.btnOk)
            val btnExit = dialog.findViewById<Button>(R.id.btnExit)
            btnOk.setOnClickListener {
                startActivity(Intent(this, GetStartedActivity::class.java))
                finish()
              /*  resetGame()
                dialog.dismiss()*/
            }
            btnExit.setOnClickListener {
                finish()
            }
        } else if (winner == 2) {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.custom_dialog2)
            dialog.show()
            val btnOk = dialog.findViewById<Button>(R.id.btnOk)
            val btnExit = dialog.findViewById<Button>(R.id.btnExit)
            btnOk.setOnClickListener {
                startActivity(Intent(this, GetStartedActivity::class.java))
                finish()
               /* resetGame()
                dialog.dismiss()*/
            }
            btnExit.setOnClickListener {
                finish()
            }

        }
    }

   /* private fun resetGame() {
        player1.clear()
        player2.clear()
        recreate()
        currentPlayer = 1
    }*/




    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    fun playNow(button: ImageView, cellID: Int) {
        if (currentPlayer == 1) {
            button.setBackgroundResource(R.drawable.red_x)
            player1.add(cellID)
            currentPlayer = 2
            binding.showText.text = "Player O turns"
            button.isEnabled = false
        } else {
            button.setBackgroundResource(R.drawable.green_o)
            player2.add(cellID)
            currentPlayer = 1
            binding.showText.text = "Player X turns"
            button.isEnabled = false

        }
    }
}


