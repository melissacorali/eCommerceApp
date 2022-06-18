package com.example.ecommerceapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.supportActionBar?.hide()


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnavigation)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.categoriesFragment,
                R.id.basketFragment,
                R.id.favoriteFragment,
                R.id.profileFragment
                )
        )

       setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{ _, destination, _ ->
         if(destination.id == R.id.loginFragment){
             bottomNavigationView.visibility = View.GONE
         }
            else if(destination.id == R.id.entryFragment){
             bottomNavigationView.visibility = View.GONE
         }
            else if(destination.id == R.id.signUpFragment) {
             bottomNavigationView.visibility = View.GONE
         }
            else if(destination.id == R.id.forgetPasswordFragment){
             bottomNavigationView.visibility = View.GONE
            }
            else{
             bottomNavigationView.visibility = View.VISIBLE
         }
         }

        }
    }
