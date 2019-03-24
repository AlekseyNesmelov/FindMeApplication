package com.nesmelovalexey.findmeapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.nesmelovalexey.findmeapp.R

/**
 * It is entry point of other screens of the application.
 *
 * @author Alexey Nesmelov
 */
class SplashActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        // TODO
        /*val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()*/

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}