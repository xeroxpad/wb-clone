package com.example.domain.repository

interface IUserAuthRepository {
    suspend fun verifyPhoneNumber(phoneNumber: String, verificationCode: String)
}