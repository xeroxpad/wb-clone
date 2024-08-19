package com.example.domain.entities

data class Community(
    val id: Int,
    val icon: String?,
    val title: String,
    val countPersons: String?,
)


data class FixEvent(
    val id: Int,
    val icon: String?,
    val title: String,
)