package com.example.firebasekotlin.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FcmService : FirebaseMessagingService() {
    // token이 생성될 때마다 안드로이드가 호출해줌. 메서드 안에서 받은 token은 디바이스나 서버에 저장해두어야 함.
    override fun onNewToken(token: String) {
        Log.d(TAG, "onNewToken: $token")
    }

    // https://firebase.google.com/docs/cloud-messaging/android/receive?hl=ko
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // TODO(developer): Handle FCM messages here.

        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: ${remoteMessage.from}")
        // From: 614963117935

        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")
        // Message Notification Body: 앱이 실행되지 않은 경우 푸시 메시지가 수신되지 않습니다.
        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
        }

        Log.d(TAG, "remoteMessage: $remoteMessage")
    }

    companion object {
        val TAG = "FcmService"
    }
}