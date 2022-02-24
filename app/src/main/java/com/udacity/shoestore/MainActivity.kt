package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DataBindingUtil class to inlfate layout for MainActivity
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        setSupportActionBar(toolbar)

        // Find NavController
        navController = this.findNavController(R.id.NavHostFragment)

        // Link the NavController to our ActionBar.
        NavigationUI.setupActionBarWithNavController(this, navController)

        // Create an appBarConfiguration with the navController.graph
        appBarConfiguration = AppBarConfiguration(navController.graph)


    }

    // Handle Back pressed
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.NavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

}
