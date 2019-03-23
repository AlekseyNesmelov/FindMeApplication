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
     * @param login    user login
     * @param first    user first name
     * @param last     user last name
     * @param photoUrl user avatar url
     */
    fun add(login: String, first: String, last: String, photoUrl: String?) : Completable
}