package com.example.data.repository.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class FixPersonEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val avatarUrl: String?,
    val interests: String,
)