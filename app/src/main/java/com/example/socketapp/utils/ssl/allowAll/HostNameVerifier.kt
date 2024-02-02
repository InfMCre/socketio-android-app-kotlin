package com.example.socketapp.utils.ssl.allowAll

import javax.net.ssl.HostnameVerifier

// como objeto validando cualquier hostname
var hostnameVerifier = HostnameVerifier { hostname, sslSession -> true }