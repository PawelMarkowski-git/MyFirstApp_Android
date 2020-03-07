package com.example.myfirstapp

import android.content.Intent
import android.service.autofill.Validators.not
import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.regex.Matcher
import javax.xml.validation.Validator

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun addTwoNumbers() {

        ActivityTestRule(MainActivity::class.java).launchActivity(null)
        onView(withId(R.id.Add_two_numbers)).perform(click())
        onView(withId(R.id.value_a)).perform(typeText("12"))
        onView(withId(R.id.value_a)).check(matches(withText("12")))
        onView(withId(R.id.value_b)).perform(typeText("12.43"))
        onView(withId(R.id.value_b)).check(matches(withText("12.43")))
        onView(withId(R.id.button_add)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("24.43")))

    }

    @Test
    fun addTwoNumbers_messages(){

        ActivityTestRule(MainActivity::class.java).launchActivity(null)
        onView(withId(R.id.Add_two_numbers)).perform(click())
        onView(withId(R.id.value_a)).perform(typeText("1234567890"))
        onView(withId(R.id.message_value_a)).check(matches(withText(R.string.maximum_number_of_characters)))
        onView(withId(R.id.value_a)).perform(replaceText("123456789"))
        onView(withId(R.id.message_value_a)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)))
        onView(withId(R.id.value_b)).perform(typeText("1234567890"))
        onView(withId(R.id.message_value_b)).check(matches(withText(R.string.maximum_number_of_characters)))
        onView(withId(R.id.value_b)).perform(replaceText("123456789"))
        onView(withId(R.id.message_value_b)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)))
        onView(withId(R.id.value_a)).perform(clearText())
        onView(withId(R.id.value_b)).perform(clearText())
        onView(withId(R.id.button_add)).perform(click())
        onView(withId(R.id.message_value_a)).check(matches(withText(R.string.must_be_something)))
        onView(withId(R.id.message_value_b)).check(matches(withText(R.string.must_be_something)))
        onView(withId(R.id.value_a)).perform(typeText("1"))
        onView(withId(R.id.message_value_a)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)))
        onView(withId(R.id.value_b)).perform(typeText("2.4"))
        onView(withId(R.id.message_value_b)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)))

    }

    @Test
    fun addTwoNumbersBackToMainActivity() {

        ActivityTestRule(MainActivity::class.java).launchActivity(null)
        onView(withId(R.id.Add_two_numbers)).perform(click())
        Espresso.pressBack()
        onView(withId(R.id.myFirstApp_Menu)).check(matches(withText(R.string.myFirstApp_Menu)))
        onView(withId(R.id.Add_two_numbers)).perform(click())
        onView(withId(R.id.value_a)).perform(typeText("123"), closeSoftKeyboard())
        Espresso.pressBack()
        onView(withId(R.id.Add_two_numbers)).perform(click())
        onView(withId(R.id.value_a)).check(matches(withText("")))
        Espresso.pressBack()
        onView(withId(R.id.Add_two_numbers)).perform(click())
        onView(withId(R.id.value_a)).perform(typeText("213"))
        onView(withId(R.id.value_b)).perform(typeText("123"), closeSoftKeyboard())
        Espresso.pressBack()
        onView(withId(R.id.Add_two_numbers)).perform(click())
        onView(withId(R.id.value_a)).check(matches(withText("")))
        onView(withId(R.id.value_b)).check(matches(withText("")))

    }

    @Test 
    fun StopWatchBackToMainActivity(){

        ActivityTestRule(MainActivity::class.java).launchActivity(null)
        onView(withId(R.id.Stop_watch)).perform(click())
        Espresso.pressBack()
        onView(withId(R.id.Stop_watch)).perform(click())
        onView(withId(R.id.value_stop_watch)).perform(typeText("13"), closeSoftKeyboard())
        Espresso.pressBack()
        onView(withId(R.id.Stop_watch)).perform(click())
        onView(withId(R.id.value_stop_watch)).check(matches(withText("")))

    }

}
