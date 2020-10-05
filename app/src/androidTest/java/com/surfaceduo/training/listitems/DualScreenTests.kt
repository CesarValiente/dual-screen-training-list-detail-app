package com.surfaceduo.training.listitems

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.UiDevice
import com.surfaceduo.training.listitems.recyclerview.ItemViewHolder
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class DualScreenTests {
    private val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @get:Rule
    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun displayListAndDetails_whenInDualMode() {
        spanApplication()

        onView(withId(R.id.first_container_id)).check(matches(isDisplayed()))
        onView(withId(R.id.second_container_id)).check(matches(isDisplayed()))

        onView(withId(R.id.list_items)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun item_in_detail_view_when_dual_screen_mode_is_shown_correctly() {
        spanApplication()

        onView(withId(R.id.first_container_id)).check(matches(isDisplayed()))
        onView(withId(R.id.second_container_id)).check(matches(isDisplayed()))

        onView(withId(R.id.list_items))
            .perform(
                actionOnItem<ItemViewHolder>(
                    hasDescendant(withText("This is number 2")), click()
                )
            );

        onView(withId(R.id.detail_layout)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.detail_number), withText("2"))).check(matches(isDisplayed()))
        onView(
            allOf(
                withId(R.id.detail_body),
                withText("This is number 2" + activityRule.activity.getString(R.string.body_text_suffix))
            )
        ).check(matches(isDisplayed()))
    }

    private fun spanApplication() {
        device.swipe(675, 1780, 1350, 900, 400)
    }
}
