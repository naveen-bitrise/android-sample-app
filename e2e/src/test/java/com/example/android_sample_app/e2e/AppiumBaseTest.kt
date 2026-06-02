package com.example.android_sample_app.e2e

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.After
import org.junit.Before
import java.net.URL
import java.time.Duration

abstract class AppiumBaseTest {

    protected lateinit var driver: AndroidDriver

    @Before
    fun setUp() {
        val serverUrl = System.getProperty("appium.server.url", "http://127.0.0.1:4723")
        val apkPath = System.getProperty("apk.path")

        val options = UiAutomator2Options()
            .setApp(apkPath)
            .setAppPackage("com.example.android_sample_app")
            .setAppActivity("com.example.android_sample_app.MainActivity")
            .setAutomationName("UiAutomator2")
            .setNewCommandTimeout(Duration.ofSeconds(60))

        driver = AndroidDriver(URL(serverUrl), options)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
    }

    @After
    fun tearDown() {
        if (::driver.isInitialized) driver.quit()
    }
}
