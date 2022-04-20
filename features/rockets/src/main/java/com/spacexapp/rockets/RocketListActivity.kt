package com.spacexapp.rockets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spacexapp.domain.Hello
import com.spacexapp.rockets.databinding.ActivityRocketListBinding
import com.spacexapp.rockets.states.RocketsUiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class RocketListActivity : AppCompatActivity() {

    private var binding: ActivityRocketListBinding? = null


    val myViewModel: MyViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketListBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        addObservers()
        myViewModel.sayHello()


    }

    private fun addObservers() {
        myViewModel.viewState.observe(this, ::handleViewState)
    }


    private fun handleViewState(viewState: RocketsUiState) {
        when (viewState) {
            is RocketsUiState.ListCategories -> {
                setDataCategoriesList(viewState.data)
            }
        }
    }

    private fun setDataCategoriesList(data: List<Hello>) {
        binding?.textView?.text = "Este es el rocket ${data[0].name} y es del tipo ${data[0].type}"
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}