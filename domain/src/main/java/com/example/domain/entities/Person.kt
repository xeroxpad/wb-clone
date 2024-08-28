package com.example.domain.entities

data class Person(
    val id: Int,
    val name: String,
    val secondName: String?,
    val numberPhone: String,
    val avatarUrl: String?,
    val socialMediaIcons: List<String>,
)

data class FixPerson(
    val id: Int,
    val name: String,
    val avatarUrl: String?,
    val interests: String,
)
