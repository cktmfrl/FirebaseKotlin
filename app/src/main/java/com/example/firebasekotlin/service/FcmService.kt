package com.example.firebasekotlin.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class FcmService : FirebaseMessagingService() {
    // token이 생성될 때마다 안드로이드가 호출해줌. 메서드 안에서 받은 token은 디바이스나 서버에 저장해두어야 함.
    override fun onNewToken(token: String) {
        Log.d(TAG, "onNewToken: $token")
    }

    companion object {
        val TAG = "FcmService"
    }
}