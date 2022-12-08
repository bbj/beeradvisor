package com.bbj.beeradvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener {
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            //selectedItem can hold any type so need convert to String
            //can also be used in a string template: "${beerColor.selectedItem}"
            val color = beerColor.selectedItem //.toString()
            val beerList = getBeers(color.toString())

            //kotlin's reduce: initializes a String -str- with the first item
            //in beerList. It then loops through the remaining items in beerList,
            //and adds each one to str, separated by a new line.
            var beers = beerList.reduce { str, item -> str + '\n' + item }

            val brands = findViewById<TextView>(R.id.brands)
            brands.text = beers;
        }
    }

    fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}