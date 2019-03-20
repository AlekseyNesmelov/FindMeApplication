package com.nesmelovalexey.userdatalib.data

import io.reactivex.Single

interface IUserPhotoRepository {

    fun uploadPhoto() : Single<String>
}