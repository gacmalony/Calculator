package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<GridView>(R.id.gridview)

        var data1:MyData = MyData("Sphere", R.drawable.sphere)
        var data2:MyData = MyData("Cube", R.drawable.cube)
        var data3:MyData = MyData("Cylinder", R.drawable.cylender)
        var data4:MyData = MyData("Prism", R.drawable.prism)

        val gridItems = listOf<MyData>(
            data1, data2, data3, data4
        )

        val adapter = MyAdapter(this, gridItems)
        gridView.adapter = adapter

        gridView.setOnItemClickListener{_,_,position,_ ->
        val clickedItem = adapter.getItem(position)
            val item = clickedItem?.title.toString()


        val i = Intent(this, CalculateActivity::class.java)
            i.putExtra("name",item)
            startActivity(i)
        }


    }
}