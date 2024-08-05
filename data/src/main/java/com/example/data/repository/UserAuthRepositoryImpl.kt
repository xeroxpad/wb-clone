package com.example.data.repository

import com.example.domain.repository.IUserAuthRepository

class UserAuthRepositoryImpl: IUserAuthRepository {
    override suspend fun verifyPhoneNumber(phoneNumber: String) {
        TODO("Not yet implemented")
    }
}