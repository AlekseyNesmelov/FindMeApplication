package com.nesmelovalexey.authlib.domain

import com.nesmelovalexey.authlib.data.IAuthRepository
import io.reactivex.Completable

/**
 * Interface for interactions with [IAuthRepository]
 *
 * @author Alexey Nesmelov
 */
interface IAuthInteractor {

    /**
     * Create a new user with the certain email and password.
     *
     * @return [Completable] of the result.
     */
    fun register(email : String, password : String) : Completable

    /**
     * Sign in with the certain email and password.
     *
     * @return [Completable] of the result.
     */
    fun signIn(email : String, password : String) : Completable
}