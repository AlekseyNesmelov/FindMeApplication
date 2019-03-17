package com.nesmelovalexey.authlib.data.firebase

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.nesmelovalexey.authlib.data.IAuthRepository
import com.nesmelovalexey.authlib.data.NetworkException
import com.nesmelovalexey.authlib.data.UnknownException
import com.nesmelovalexey.authlib.data.UserAlreadyExistsException
import io.reactivex.Completable
import io.reactivex.CompletableEmitter

/**
 * Implementation of the [IAuthRepository] interface, that uses Firebase
 * for registration and authentication.
 *
 * @author Alexey Nesmelov
 */
class FirebaseAuthRepository : IAuthRepository {

    companion object {
        const val TAG = "FirebaseAuthRepository"
    }

    private val auth = FirebaseAuth.getInstance() // TODO dagger

    // TODO find out the reason of warning
    override fun register(email: String, password: String) = Completable.create {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(AuthCompleteListener(it))
    }

    // TODO find out the reason of warning
    override fun signIn(email: String, password: String) = Completable.create {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(AuthCompleteListener(it))
    }

    class AuthCompleteListener<T>(private val emitter: CompletableEmitter) : OnCompleteListener<T> {

        override fun onComplete(task: Task<T>) {
            when {
                task.isSuccessful -> emitter.onComplete()
                // TODO add more cases
                task.exception is FirebaseAuthUserCollisionException -> emitter.onError(UserAlreadyExistsException())
                task.exception is FirebaseNetworkException -> emitter.onError(NetworkException())
                else -> emitter.onError(UnknownException())
            }
        }
    }
}

