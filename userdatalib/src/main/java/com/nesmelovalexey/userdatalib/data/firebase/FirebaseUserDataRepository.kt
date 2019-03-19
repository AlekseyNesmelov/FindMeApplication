package com.nesmelovalexey.userdatalib.data.firebase

import android.util.Log
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.nesmelovalexey.userdatalib.data.IUserDataRepository
import io.reactivex.Completable
import io.reactivex.CompletableEmitter

/**
 * User data repository, that uses Firebase.
 *
 * @author Alexey Nesmelov
 */
class FirebaseUserDataRepository(private val dataBase : FirebaseFirestore) : IUserDataRepository {

    override fun add(first: String, last: String) : Completable = Completable.create {
        val user = HashMap<String, Any>()
        user[PROP_FIRST_NAME] = first
        user[PROP_LAST_NAME] = last

        dataBase.collection(COLLECTION_USERS)
            .add(user)
            .addOnSuccessListener(UserDbSuccessListener(it))
            .addOnFailureListener(UserDbFailureListener(it))
    }

    class UserDbSuccessListener<T>(private val emitter: CompletableEmitter) : OnSuccessListener<T> {

        override fun onSuccess(doc: T) {
            if (doc is DocumentReference) {
                Log.d(TAG, "DocumentSnapshot added with ID: " + doc.id)
            }
            emitter.onComplete()
        }
    }

    class UserDbFailureListener(private val emitter: CompletableEmitter) : OnFailureListener {

        override fun onFailure(e: Exception) {
            Log.w(TAG, "Error adding document", e)
            emitter.onError(e)
        }
    }

    companion object {
        const val TAG = "FirebaseUserDataRep"

        const val PROP_FIRST_NAME = "first"
        const val PROP_LAST_NAME = "last"

        const val COLLECTION_USERS = "users"
    }
}