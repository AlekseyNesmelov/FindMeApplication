package com.nesmelovalexey.userdatalib.data

import io.reactivex.Completable

/**
 * Interface of repository, that allows you to get access to users.
 *
 * @author Alexey Nesmelov
 */
interface IUserDataRepository {

    /**
     * Add new user to the database.
     *
     * @param first user first name
     * @param last  user last name
     */
    fun add(first: String, last: String) : Completable
}