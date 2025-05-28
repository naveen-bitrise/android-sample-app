package com.example.android_sample_app

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.core.app.ActivityScenario // Import for ActivityScenario
import androidx.test.espresso.Espresso.onView // Import for Espresso onView
import androidx.test.espresso.assertion.ViewAssertions.matches // Import for matches
import androidx.test.espresso.matcher.ViewMatchers.withText // Import for withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed // Import for isDisplayed


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.concurrent.TimeUnit

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.android_sample_app", appContext.packageName)
    }

    @Test
    fun oneMinuteRunningTest() {
        // Test that sleeps for 10 minutes
        println("Starting 1-minute sleep test")
        try {
            // Sleep for 1 minutes (60,000 milliseconds)
            Thread.sleep(TimeUnit.MINUTES.toMillis(1))
            println("1-minute sleep completed")
        } catch (e: InterruptedException) {
            println("Sleep was interrupted: ${e.message}")
            throw e
        }
        // Simple assertion to make sure the test passes after sleeping
        assertTrue(true)
    }

    @Test
    fun testGreetingTextDisplayed() {
        // Launch the MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Verify that the text "Hello; Bitrise!" is displayed
        onView(withText("Hello; Bitrise!"))
            .check(matches(isDisplayed()))
    }


}