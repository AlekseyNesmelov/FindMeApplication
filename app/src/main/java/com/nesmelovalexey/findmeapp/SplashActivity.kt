package com.nesmelovalexey.findmeapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.nesmelovalexey.authlib.ui.AuthActivity

/**
 * It is entry point of other screens of the application.
 *
 * @author Alexey Nesmelov
 */
class SplashActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }
}