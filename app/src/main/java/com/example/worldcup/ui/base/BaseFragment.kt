package com.example.worldcup.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.viewbinding.ViewBinding
import com.example.worldcup.data.DataManager


abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    private var _binding: VB? = null
    lateinit var dataManager: DataManager

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataManager = (activity as MainActivity).getDataManager()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater, container, false)
        return requireNotNull(_binding).root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}