package com.example.firebasekotlin.ui.main

import android.os.Bundle
import android.util.Log
import com.example.firebasekotlin.BaseActivity
import com.example.firebasekotlin.databinding.ActivityMainBinding
import com.example.firebasekotlin.ui.ViewInit
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : BaseActivity(), ViewInit {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initView()
    }

    override fun initView() {
        setContentView(binding.root)
        fetchPushToken()
    }

    private fun fetchPushToken() {
        // token이 갱신되기 전까지는 앱을 재실행해도 onNewToken()이 다시 호출되지 않음. 토큰을 다시 출력하기 위해서는 다음 코드가 필요함.
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.d(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            val token = task.result
            Log.d(TAG, "재호출=${token}")
        })
    }

    companion object {
        val TAG = "MainActivity"
    }

}