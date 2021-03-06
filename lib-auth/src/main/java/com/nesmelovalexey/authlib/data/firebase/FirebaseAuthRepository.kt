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
import com.nesmelovalexey.corelib.logger.Logger
import io.reactivex.Completable
import io.reactivex.CompletableEmitter

/**
 * Implementation of the [IAuthRepository] interface, that uses Firebase
 * for registration and authentication.
 *
 * @param auth [FirebaseAuth], that is used for authorization.
 * @author Alexey Nesmelov
 */
class FirebaseAuthRepository(private val auth: FirebaseAuth) : IAuthRepository {

    override fun register(email: String, password: String): Completable = Completable.create {
        Logger.d(TAG, "registration for email = $email, pass = $password")
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(AuthCompleteListener(it))
    }

    override fun signIn(email: String, password: String) : Completable = Completable.create {
        Logger.d(TAG, "sign in for email = $email, pass = $password")
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(AuthCompleteListener(it))
    }

    /**
     * Listener of the result of authorization.
     *
     * @param emitter [CompletableEmitter] that is used to set the result
     */
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

    companion object {
        const val TAG = "FirebaseAuthRepository"
    }
}

