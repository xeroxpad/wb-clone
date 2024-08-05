package com.example.domain.usecases

import com.example.domain.repository.IUserAuthRepository

class VerifyPhoneNumberUseCase(private val userAuthRepository: IUserAuthRepository) {
    suspend fun invoke(phoneNumber: String) {
        userAuthRepository.verifyPhoneNumber(phoneNumber)
    }
}