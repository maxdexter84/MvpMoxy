package com.maxdexter.mvpmoxy.espresso;

import com.maxdexter.mvpmoxy.R;
import com.maxdexter.mvpmoxy.test.unit.TextActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;






public class TextActivityTest {

        @Rule
        public ActivityTestRule<TextActivity> activityRule = new ActivityTestRule<>(TextActivity.class);

        @Test
        public void onClick() {
            onView(withId(R.id.text_button)).perform(click());
            onView(withId(R.id.tv_text_activity)).check(matches(withText("TextView")));
        }

}
