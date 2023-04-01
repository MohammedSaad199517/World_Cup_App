package com.example.worldcup.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.worldcup.data.DataManager
import com.example.worldcup.data.DataManagerImpl
import com.example.worldcup.data.datasource.CsvDataSource
import com.example.worldcup.data.datasource.utils.CsvParser


abstract class BaseActivity<VB: ViewBinding> :AppCompatActivity(){
    abstract val bindingInflater:(LayoutInflater) -> VB
    private var _binding :ViewBinding? = null
    protected val binding
    get() =_binding as VB

    lateinit var dataManager: DataManager
    override fun onCreate(savedInstanceState: Bundle?) {
        initDataManager(savedInstanceState)
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setup()
        addCallBack()
    }
    abstract fun setup()
    abstract fun addCallBack()
    private fun initDataManager(savedInstanceState: Bundle?) {
        dataManager = when (savedInstanceState) {
            null -> DataManagerImpl(CsvDataSource(CsvParser(), this))
            else -> savedInstanceState.getSerializable(KEY_DATA_MANAGER) as DataManager
        }
    }
    companion object {
        const val KEY_DATA_MANAGER = "DATA_MANAGER"
        const val TAG_HOME_FRAGMENT = "Home"
        const val TAG_EXPLORE_FRAGMENT = "Explore"
        const val TAG_MAKE_MEAL_FRAGMENT = "MakeMeal"
        const val TAG_FAVOURITE_FRAGMENT = "Favorite"
    }

}