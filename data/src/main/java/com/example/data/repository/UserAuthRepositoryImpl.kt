package com.example.data.repository

import com.example.domain.repository.IUserAuthRepository

class UserAuthRepositoryImpl: IUserAuthRepository {
    override suspend fun verifyPhoneNumber(phoneNumber: String, verificationCode: String) {
        TODO("Not yet implemented")
    }
}