package com.example.worldcup.ui.base

import MatchFragment
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.worldcup.data.DataManager
import com.example.worldcup.data.DataManagerImpl
import com.example.worldcup.data.datasource.CsvDataSource
import com.example.worldcup.data.datasource.utils.CsvParser
import com.example.worldcup.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private lateinit var dataManager: DataManager
    override fun onCreate(savedInstanceState: Bundle?) {
        initDataManager(savedInstanceState)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSubView()

    }
    fun getDataManager():DataManager{
        return dataManager
    }
    private fun initSubView(){
        setFragment(MatchFragment(), "Home")
    }
    private fun setFragment(fragment: Fragment, tag: String) {
        val currentFragment = supportFragmentManager.findFragmentById(binding.fragmentContainer.id)
        if (currentFragment == null || currentFragment.javaClass != fragment.javaClass)
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, fragment, tag)
                .addToBackStack(null)
                .commit()
    }
    private fun initDataManager(savedInstanceState: Bundle?) {
        dataManager = when (savedInstanceState) {
            null -> DataManagerImpl(CsvDataSource(CsvParser(), this))
            else -> savedInstanceState.getSerializable(KEY_DATA_MANAGER) as DataManager
        }
    }
    companion object {
        const val KEY_DATA_MANAGER = "DATA_MANAGER"

    }
}

