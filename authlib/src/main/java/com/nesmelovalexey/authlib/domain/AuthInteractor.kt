package com.nesmelovalexey.authlib.domain

import com.nesmelovalexey.authlib.data.IAuthRepository
import io.reactivex.Completable

/**
 * Default implementation of [IAuthInteractor]
 *
 * @author Alexey Nesmelov
 */
class AuthInteractor(private val repository: IAuthRepository) : IAuthInteractor {

    override fun signIn(email: String, password: String): Completable = repository.signIn(email, password)

    override fun register(email: String, password: String): Completable = repository.register(email, password)
}