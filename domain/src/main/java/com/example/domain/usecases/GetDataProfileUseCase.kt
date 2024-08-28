package com.example.domain.usecases

import com.example.domain.entities.FixPerson
import com.example.domain.entities.Person
import com.example.domain.repository.IProfileRepository

class GetDataProfileUseCase(
    val repository: IProfileRepository,
) {
//    fun execute(): Person = repository.getDataProfileUseCase()
fun execute(): FixPerson = repository.getDataProfileUseCase()

}
