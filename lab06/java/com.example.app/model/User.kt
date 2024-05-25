// User.kt
package com.example.app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    var name: String,
    var email: String,
    var imageResourceId: Int
) : Parcelable
