package com.bignerdranch.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)//присваиваем полю id кнопки


        rollButton.setOnClickListener {//объявляем слушателя
            rollDice()//передаём функцию которая будет выполняться после нажатия пользователем на кнопку
        }
        rollDice()//отображает содержимое функции при запуске приложения
    }

    private fun rollDice() {
        val dice = Dice(6)//получаем сылку на класс и передаём в конструктор число 6
        val diceRoll = dice.roll()//передаём в поле результат функции
        val diceRolling = dice.rolling()

        val diceImage: ImageView = findViewById(R.id.imageView)//объявляем вьювер
        val diceImageTwo: ImageView = findViewById(R.id.imageView2)//объявляем вьювер

        val drawableResource = when(diceRoll){//присваиваем полю какой ролл какое значение выводит
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        val drawableResourceTwo = when(diceRolling){//присваиваем полю какой ролл какое значение выводит
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)//задаем через сетер в вьювер что выводить на экран

        diceImage.contentDescription = diceRoll.toString()//необходимо для  программы чтения с экрана что бы сказать, какое число выпало.

        diceImageTwo.setImageResource(drawableResourceTwo)//задаем через сетер в вьювер что выводить на экран

        diceImageTwo.contentDescription = diceRolling.toString()//необходимо для  программы чтения с экрана что бы сказать, какое число выпало.
    }
}

class Dice(private val numSides: Int) {//объявлен класс с конструктором принимающим значение Int

    fun roll(): Int {//функция в которой происходит вся магия и которая возвращает значения Int
        return (1..numSides).random()
    }
    fun rolling(): Int {
        return (1..numSides).random()
    }
}