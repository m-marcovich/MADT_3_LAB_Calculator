package com.example.madt_3_lab_calculator;

import android.widget.TextView;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testNumericInput() {
        Espresso.onView(ViewMatchers.withId(R.id.n1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.n2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.n3)).perform(ViewActions.click());
        Assert.assertEquals("123", getCalculatorScreenText());
    }

    @Test
    public void testArithmeticOperation() {
        Espresso.onView(ViewMatchers.withId(R.id.n8)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.addition)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.n4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.equals)).perform(ViewActions.click());
        Assert.assertEquals("12", getCalculatorScreenText());
    }


    private String getCalculatorScreenText() {
        return ((TextView) activityRule.getActivity().findViewById(R.id.calculatorScreen)).getText().toString();
    }
}
