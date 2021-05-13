package com.example.orama.components

import android.app.Activity
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController

@RunWith(RobolectricTestRunner::class)
abstract class ComponentUnitTest {

    private lateinit var activityController: ActivityController<Activity>

    @Before
    fun setup() {
        activityController = Robolectric.buildActivity(Activity::class.java)
            .create()
            .start()
            .resume()
            .visible()
        val activity: Activity = activityController.get()
        setupComponent(activity)
    }

    abstract fun setupComponent(activity: Activity)

    @After
    fun tearDown() {
        activityController
            .pause()
            .stop()
            .destroy()
    }



}