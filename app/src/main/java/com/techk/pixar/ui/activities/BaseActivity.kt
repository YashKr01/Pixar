package com.techk.pixar.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    private var _binding: T? = null
    abstract val bindingInflater: (LayoutInflater) -> T

    protected val binding: T
        get() = _binding as T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)

    }

    abstract fun initViews()

    abstract fun setObservers()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}