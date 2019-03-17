package com.nesmelovalexey.authlib.data

import io.reactivex.Completable

/**
 * The main interface of registration and authentication actions.
 *
 * @author Alexey Nesmelov
 */
interface IAuthRepository {

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