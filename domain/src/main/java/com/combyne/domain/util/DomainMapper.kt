package com.combyne.domain.util

interface DomainMapper<T, DomainModel> {
    fun toDomainModel(model: T): DomainModel
    fun fromDomainModel(model: DomainModel): T
}