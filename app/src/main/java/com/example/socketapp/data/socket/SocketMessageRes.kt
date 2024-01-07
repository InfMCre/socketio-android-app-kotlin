package com.example.socketapp.data.socket

data class SocketMessageRes (
    val messageType: MessageType,
    val room: String,
    val message: String,
    val authorName: String,
    val authorId: Integer
)
