package com.example.domain.repository

import com.example.domain.entities.FixPerson
import com.example.domain.entities.Person
import java.net.URI

interface IProfileRepository {
//    fun getDataProfileUseCase(): Person
fun getDataProfileUseCase(): FixPerson
}
