package com.nesmelovalexey.userdatalib.data.firebase

import com.google.firebase.storage.FirebaseStorage
import com.nesmelovalexey.userdatalib.data.IUserPhotoRepository
import io.reactivex.Single

/**
 * User data repository, that uses Firebase.
 *
 * @author Alexey Nesmelov
 */
class FirebaseUserPhotoRepository(private val dataBase : FirebaseStorage) : IUserPhotoRepository {

    override fun uploadPhoto(): Single<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}