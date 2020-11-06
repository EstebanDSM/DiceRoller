package com.example.diceroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding
import java.util.*


private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        /* Ancienne façon d'aller chercher les vues et de s'en servir dans le code */

//        val rollButton: Button = findViewById(R.id.roll_button)
//        rollButton.text = "Let's Roll"
//
//        rollButton.setOnClickListener { Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show() }

        /* Nouvelle façon depuis android 3.6 ;-)  */

        binding.rollButton.text = getString(R.string.roll)

//        binding.rollButton.setOnClickListener {
//            Toast.makeText(
//                this,
//                "Button clicked",
//                Toast.LENGTH_LONG
//            ).show()
//        }

        binding.rollButton.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        val drawableResource = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImage.setImageResource(drawableResource)
    }
}