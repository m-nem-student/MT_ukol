package com.example.playercount.action

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.playercount.MyApplication
import com.example.playercount.R
import com.example.playercount.databinding.ActivityActionBinding

class ActionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActionBinding
    private lateinit var viewModel: ActionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)

        binding = ActivityActionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val app = application as MyApplication
        viewModel = ViewModelProvider(this, ActionViewModelFactory(app.repository, this)).get(
            ActionViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}