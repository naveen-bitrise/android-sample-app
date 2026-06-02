package com.example.android_sample_app.e2e

import io.appium.java_client.AppiumBy
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeScreenTest : AppiumBaseTest() {

    @Test
    fun mainScreen_launchesSuccessfully() {
        // Verifies the app launched and the root screen is visible
        val isDisplayed = driver
            .findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Hello\")"))
            .isDisplayed
        assertTrue(isDisplayed)
    }

    @Test
    fun mainScreen_packageIsRunning() {
        assertTrue(driver.currentPackage == "com.example.android_sample_app")
    }
}
