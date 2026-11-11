package com.example.navigationdrawer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // VIEW BINDING
    private lateinit var binding: ActivityMainBinding

    // NAVIGATION
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // INFLATE BINDING
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // SET TOOLBAR
        setSupportActionBar(binding.toolbar)

        // MEMANGGIL NAV HOST FRAGMENT
        val navHostFragment =
            supportFragmentManager.findFragmentById(
                R.id.navHostFragment
            ) as NavHostFragment

        // MEMANGGIL NAV CONTROLLER
        navController = navHostFragment.navController

        // APP BAR CONFIGURATION
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.profileFragment,
                R.id.settingFragment
            ),
            binding.drawer
        )

        // MENGHUBUNGKAN TOOLBAR DENGAN NAVIGATION
        setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )

        // MENGHUBUNGKAN DRAWER DENGAN NAVIGATION
        binding.navView.setupWithNavController(
            navController
        )
    }

    // TOMBOL BACK DAN MENU
    override fun onSupportNavigateUp(): Boolean {

        return navController.navigateUp(
            appBarConfiguration
        ) || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
