package com.example.domain.usecases

import com.example.domain.repository.IUserAuthRepository

class VerifyPhoneNumberUseCase(private val userAuthRepository: IUserAuthRepository) {
    suspend fun execute(phoneNumber: String, verificationCode: String): Result<Unit> {
        return Result.success(Unit)
    }
}