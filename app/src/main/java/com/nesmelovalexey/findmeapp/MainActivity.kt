package com.nesmelovalexey.findmeapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.nesmelovalexey.authlib.data.firebase.FirebaseAuthRepository

/**
 * [FragmentActivity] that presents the main screen.
 * It is entry point of other screens of the application.
 *
 * @author Alexey Nesmelov
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // TODO it is just a test
        val repository = FirebaseAuthRepository()
        repository.register("70508010alex@mail.ru", "123ewq")
            .subscribe({
                Log.d("MainActivity", "onComplete")
            }, {
                Log.d("MainActivity", "onError", it)
            })
        repository.signIn("70508010alex@mail.ru", "123ewq")
            .subscribe({
                Log.d("MainActivity", "onComplete")
            }, {
                Log.d("MainActivity", "onError", it)
            })
    }
}