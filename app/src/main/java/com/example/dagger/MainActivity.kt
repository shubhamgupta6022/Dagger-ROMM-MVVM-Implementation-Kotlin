package com.example.dagger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.dagger.databinding.ActivityMainBinding
import com.example.dagger.db.UserDb
import com.example.dagger.db.UserRepository
import com.example.dagger.db.UserViewModel
import com.example.dagger.db.UserViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var viewModelFactory: UserViewModelFactory
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as MyApplication).component.inject(this)

        userViewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]

        binding.buttonLogin.setOnClickListener {
            login()
        }

        binding.textViewRegisterNow.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

    private fun login() {
        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextTextPassword.text.toString()

        lifecycleScope.launch(Dispatchers.Main) {
            val uid = userViewModel.getUid(email, password)
            if (uid == null) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
            } else {
                Log.d("MainActivity", "uid: $uid")
                Toast.makeText(applicationContext, "uid: $uid", Toast.LENGTH_LONG).show()
            }
        }

    }
}