package com.example.socketapp.utils.ssl.allowAll

import java.security.cert.X509Certificate
import javax.net.ssl.X509TrustManager



// Please use with caution, as this defeats the whole purpose of using secure connections.
//
// This is equivalent to rejectUnauthorized: false for the JavaScript client.

// https://socketio.github.io/socket.io-client-java/initialization.html
val trustManager = object : X509TrustManager {
    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return arrayOf()
    }

    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
        // not implemented
    }

    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
        // not implemented
    }
}
