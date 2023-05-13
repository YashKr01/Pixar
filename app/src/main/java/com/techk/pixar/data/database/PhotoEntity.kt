package com.techk.pixar.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.techk.pixar.data.network.responses.Urls
import com.techk.pixar.data.network.responses.User
import com.techk.pixar.utils.Constants

@Entity(tableName = Constants.TABLE_NAME)
data class PhotoEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val likes: Int?,
    val urls: Urls?,
    val user: User?,
    var saved: Boolean = false
)