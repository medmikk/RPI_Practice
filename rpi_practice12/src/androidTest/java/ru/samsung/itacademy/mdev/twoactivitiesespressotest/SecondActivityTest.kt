package ru.samsung.itacademy.mdev.twoactivitiesespressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
class SecondActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )

    @Test
    fun returnReply() {
    }

    @Test
    @Throws(Exception::class)
    fun clickLoginButton() {
        onView(withId(R.id.button_main))
        onView(withId(R.id.button_main)).check(matches(isDisplayed()))
        onView(withId(R.id.button_main)).perform(click())
    }

}