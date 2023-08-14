package com.ahmad.aghazadeh.noteita

import android.app.Application
import android.content.Intent
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class NoteApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        // Setup handler for uncaught exceptions.
        Thread.setDefaultUncaughtExceptionHandler { thread, e ->
            handleUncaughtException(
                thread,
                e
            )
        }
    }
    fun handleUncaughtException(thread: Thread?, e: Throwable) {
        e.printStackTrace() // not all Android versions will print the stack trace automatically
        val intent = Intent()
        intent.action = "com.mydomain.SEND_LOG" // see step 5.
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK // required when starting from Application
        startActivity(intent)
        System.exit(1) // kill off the crashed app
    }
}