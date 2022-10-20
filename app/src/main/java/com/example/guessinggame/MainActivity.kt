package com.example.guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the buttons
        val buttonLeft = findViewById<Button>(R.id.buttonLeft)
        val buttonRight = findViewById<Button>(R.id.buttonRight)

        // Get references to score field
        val scoreViewText = findViewById<TextView>(R.id.scoreView)

        // choose numbers to display on buttons
        var  leftNum = Random.nextInt(0,10)
        var  rightNum = Random.nextInt(0,10)

        buttonLeft.setText(leftNum.toString())
        buttonRight.setText(rightNum.toString())



        // game score
        var score = 0

        buttonLeft.setOnClickListener {
            Toast.makeText(this@MainActivity, "You clicked Left", Toast.LENGTH_SHORT).show()
            leftNum = buttonLeft.getText().toString().toInt()
            if(leftNum > rightNum) {
                score++
            }
            else {
                score --
            }
            scoreViewText.setText("Score: " + score)

            leftNum = Random.nextInt(0,10)
            rightNum = Random.nextInt(0,10)

            while(leftNum == rightNum) {
                rightNum = Random.nextInt(0,10)
            }

            buttonLeft.setText(leftNum.toString())
            buttonRight.setText(rightNum.toString())
        }

        buttonRight.setOnClickListener{
            Toast.makeText(this@MainActivity, "You clicked Right", Toast.LENGTH_SHORT).show()
            rightNum = buttonRight.getText().toString().toInt()

            if(leftNum < rightNum) {
                score++
            }
            else {
                score --
            }
            scoreViewText.setText("Score: " + score)

            leftNum = Random.nextInt(0,10)
            rightNum = Random.nextInt(0,10)

            while(leftNum == rightNum) {
                rightNum = Random.nextInt(0,10)
            }

            buttonLeft.setText(leftNum.toString())
            buttonRight.setText(rightNum.toString())
        }
    }
}