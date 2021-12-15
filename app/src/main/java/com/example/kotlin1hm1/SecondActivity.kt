package com.example.kotlin1hm1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin1hm1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra(MainActivity.KEY)){
            setContent()
        }

        binding.btnSend.setOnClickListener {
            sendMsg()
        }
    }

    private fun sendMsg() {
        val msg = binding.etMsg.text.toString()
        if (msg.trim().isNotEmpty()){
            val intent = Intent()
            intent.putExtra(MainActivity.KEY, msg)
            setResult(Activity.RESULT_OK, intent)
            finish()
        } else {
            Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setContent() {
        binding.etMsg.setText(intent.getStringExtra(MainActivity.KEY).toString())
    }
}