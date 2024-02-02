package com.example.socketapp.utils.ssl

import android.content.Context
import android.util.Log
import com.example.socketapp.R
import java.io.IOException
import java.io.InputStream
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.net.ssl.X509TrustManager

class MyTrustManager(val context: Context) {

    private val TAG = "TrustManager"

    private var myCert: X509Certificate? = loadCertificate()

    val trustManager = object : X509TrustManager {
        override fun getAcceptedIssuers(): Array<X509Certificate> {
            return arrayOf()
        }

        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
            if (chain.isNotEmpty() && chain[0] == myCert) {
                // El certificado del cliente es el mismo que tu certificado público
                Log.d(TAG, "checkClientTrusted ok")
            } else {
                Log.e(TAG, "checkClientTrusted KO")
                throw CertificateException("El certificado del cliente no es válido.")
            }
        }

        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
            if (chain.isNotEmpty() && chain[0] == myCert) {
                Log.d(TAG, "checkServerTrusted ok")
                // El certificado del servidor es el mismo que tu certificado público
            } else {
                Log.e(TAG, "checkServerTrusted KO")
                throw CertificateException("El certificado del servidor no es válido.")
            }
        }
    }


    private fun loadCertificate(): X509Certificate? {

        Log.d(TAG, "loadCertificate")
        val certificateFactory = CertificateFactory.getInstance("X.509")
        val certificadoResId = R.raw.certificate

        try {
            val inputStream: InputStream = context.resources.openRawResource(certificadoResId)
            val myCert = certificateFactory.generateCertificate(inputStream) as X509Certificate
            inputStream.close()
            return myCert
        } catch (ex: IOException) {
            Log.e(TAG, "loadCertificate IOException")
        }
        return null
    }


}