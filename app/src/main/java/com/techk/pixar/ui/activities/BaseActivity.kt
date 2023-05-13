package com.techk.pixar.ui.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T: ViewBinding>: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)

        initViews()
        setObservers()

    }

    abstract fun initViews()

    abstract fun setObservers()

    abstract val binding: T

}