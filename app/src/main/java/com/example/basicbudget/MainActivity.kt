package com.example.basicbudget

import android.animation.LayoutTransition
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.basicbudget.Adapters.CategoryAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //Here is where we'll gather the data
        val categories = listOf(
            Category(R.drawable.ic_home_black_24dp,
                "Home",
                listOf("Rent", "Stairs", "Things", "Love Jesse")),
            Category(R.drawable.ic_directions_car_black_24dp,
                "Auto",
                listOf("Payment","Petrol", "Insurance", "Service", "Repairs"))
        )

        root.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        main_category_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        main_category_recycler.adapter = CategoryAdapter(categories)
    }

    //Options Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Options Selected
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_theme -> {
                Log.d("DSS", "Theme menu chosen")
                Toast.makeText(this, "Theme menu chosen", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_Manage_Categories -> {
                Log.d("DSS", "Manage Categories menu chosen")
                Toast.makeText(this, "Manage Categories menu chosen", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_transaction -> {
                Log.d("DSS", "Icon pressed")
                toolbar.title = "Icon pressed"
                Toast.makeText(this, "Icon pressed", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_dark -> {
                Log.d("DSS", "Dark Theme Selected")
                Toast.makeText(this, "Dark Theme Selected", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_light -> {
                Log.d("DSS", "Light Theme Selected")
                Toast.makeText(this, "Light Theme Selected", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}