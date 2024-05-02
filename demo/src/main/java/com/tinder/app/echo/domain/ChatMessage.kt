/*
 * © 2018 Match Group, LLC.
 */

package com.tinder.app.echo.domain

import android.graphics.Bitmap

sealed class ChatMessage {
    abstract val id: Int
    abstract val source: Source
    abstract val timestamp: Long

    data class Text(
        override val id: Int,
        val value: String,
        override val source: Source,
        override val timestamp: Long = System.currentTimeMillis()
    ) : ChatMessage()

    data class Image(
        override val id: Int,
        val bitmap: Bitmap,
        override val source: Source,
        override val timestamp: Long = System.currentTimeMillis()
    ) : ChatMessage()

    enum class Source {
        SENT, RECEIVED
    }
}
