package com.techk.pixar.app.screens.home

import android.view.LayoutInflater
import com.techk.pixar.databinding.ActivityMainBinding
import com.techk.pixar.app.screens.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun initViews() {

    }

    override fun setObservers() {

    }

}