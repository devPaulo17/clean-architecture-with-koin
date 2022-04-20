package com.spacexapp.rockets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spacexapp.rockets.databinding.ActivityRocketListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RocketListActivity : AppCompatActivity() {

    private var binding: ActivityRocketListBinding? = null


    val myViewModel: MyViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketListBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.textView?.text = myViewModel.sayHello()

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}