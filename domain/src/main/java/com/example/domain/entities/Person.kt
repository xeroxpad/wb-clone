package com.example.domain.entities

data class Person(
    val name: String,
    val secondName: String?,
    val numberPhone: String,
    val avatarUrl: String?,
    val socialMediaIcons: List<String>
)
