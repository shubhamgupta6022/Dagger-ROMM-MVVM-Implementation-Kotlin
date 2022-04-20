package com.example.dagger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.dagger.databinding.ActivityRegisterBinding
import com.example.dagger.db.User
import com.example.dagger.db.UserRepository
import com.example.dagger.db.UserViewModel
import com.example.dagger.db.UserViewModelFactory
import javax.inject.Inject

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var userViewModel: UserViewModel

    @Inject
    lateinit var viewModelFactory: UserViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        userViewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]

        binding.textViewLoginNow.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.buttonRegister.setOnClickListener {
            register()
        }

    }

    private fun register() {

        userViewModel.insert(
            User(
                uid = 0,
                name = binding.editTextTextPersonName.text.toString(),
                emailId = binding.editTextTextEmailAddress.text.toString(),
                password = binding.editTextTextPassword.text.toString()
            )
        )

        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()

        startActivity(Intent(this, MainActivity::class.java))
    }
}