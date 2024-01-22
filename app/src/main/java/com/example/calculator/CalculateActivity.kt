package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        val geo = receiveName()
        val input = findViewById<EditText>(R.id.editText)
        val output = findViewById<TextView>(R.id.output)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            val calc12:String = input.text.toString()
            val calc1 = Integer.parseInt(calc12)
            var calc = 0

            if(geo.trim() == "Sphere"){
                calc = calc1*calc1*3*4
            }else if(geo.trim() == "Cube"){
                calc = calc1*6*calc1
            }else if(geo.trim() == "Cylinder"){
                calc = 12*calc1
            }else{
                calc = 6*calc1
            }

            output.text = "You chose $geo and area is : ${calc}"
        }

    }






    fun receiveName():String{
        var bnd:Bundle?= intent.extras
        var username = bnd?.getString("name")
        return username.toString()
    }
}