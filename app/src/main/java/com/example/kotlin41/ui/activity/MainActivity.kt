package com.example.kotlin41.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlin41.R
import com.example.kotlin41.ui.prefernce.SharedPreference

class MainActivity : AppCompatActivity() {
    private val preferenceHelper: SharedPreference by lazy {
        SharedPreference(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation(savedInstanceState)
    }

    private fun setupNavigation(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        if (savedInstanceState == null) {
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

            if (!preferenceHelper.isShowRegister){
            navGraph.setStartDestination(R.id.firstFragment)
            navController.graph = navGraph
            }
        }
    }
}
