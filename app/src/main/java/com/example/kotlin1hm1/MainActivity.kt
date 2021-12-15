package com.example.kotlin1hm1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin1hm1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY = "101"
    }

    private lateinit var binding: ActivityMainBinding

    private val startActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val data = result.data?.getStringExtra(KEY)
                binding.etMsg.setText(data)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            sendMsg()
        }
    }

    private fun sendMsg() {
        val msg = binding.etMsg.text.toString()
        if (msg.trim().isNotEmpty()){
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra(KEY, msg)
            startActivityForResult.launch(intent)
        } else {
            Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show()
        }
    }
}