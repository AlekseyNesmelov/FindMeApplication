package com.nesmelovalexey.findmeapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.nesmelovalexey.authlib.domain.IAuthInteractor
import com.nesmelovalexey.userdatalib.data.IUserDataRepository
import org.koin.android.ext.android.inject

/**
 * [FragmentActivity] that presents the main screen.
 * It is entry point of other screens of the application.
 *
 * @author Alexey Nesmelov
 */
class MainActivity : FragmentActivity() {

    // TODO it is just a test
    private val interactor: IAuthInteractor by inject()
    private val usersRep: IUserDataRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // TODO it is just a test
        /*interactor.register("70508010alex@mail.ru", "123ewq")
            .subscribe({
                Log.d("MainActivity", "onComplete")
            }, {
                Log.d("MainActivity", "onError", it)
            })*/
        interactor.signIn("70508010alex@mail.ru", "123ewq")
            .andThen(usersRep.add("Alexey", "Nesmelov"))
            .subscribe({
                Log.d("MainActivity", "onComplete")
            }, {
                Log.d("MainActivity", "onError", it)
            })
    }
}