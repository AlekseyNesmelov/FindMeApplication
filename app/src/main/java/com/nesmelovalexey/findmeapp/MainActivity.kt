package com.nesmelovalexey.findmeapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.nesmelovalexey.authlib.ui.AuthActivity
import com.nesmelovalexey.userdatalib.data.IUserDataRepository
import org.koin.android.ext.android.inject

/**
 * [FragmentActivity] that presents the main screen.
 * It is entry point of other screens of the application.
 *
 * @author Alexey Nesmelov
 */
class MainActivity : FragmentActivity() {

    private val usersRep: IUserDataRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }
}