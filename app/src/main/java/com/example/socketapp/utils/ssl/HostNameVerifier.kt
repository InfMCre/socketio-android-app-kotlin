package com.example.socketapp.utils.ssl

import android.util.Log
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession

class MyHostnameVerifier : HostnameVerifier {

    private val TAG = "TrustManager"
    override fun verify(hostname: String?, session: SSLSession?): Boolean {
        // host verification logic. Check that is one of our hosts

        // only for debug
        if (hostname != null) {
            Log.d(TAG, "MyHostnameVerifier hostname: $hostname")
        }

        if (hostname != null
            && hostname == "10.0.2.2"
            // other hostnames
        ) {
            return true // true is is verified
        }
        Log.e(TAG, "MyHostnameVerifier verify KO")
        return false

    }
}