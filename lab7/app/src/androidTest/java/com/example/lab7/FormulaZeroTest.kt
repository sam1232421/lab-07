package com.example.lab7

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity


    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
    @Test
    fun navigate_to_drivers_add_driver_clear_and_return_home() {  //test for drivers
        // 1. Navigate to Drivers screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // Verify Drivers screen loaded
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // 2. Enter and add a driver
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Lewis Hamilton")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // Verify driver appears in list
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertExists()

        // 3. Clear driver list
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // Verify driver is removed
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertDoesNotExist()

        // 4. Return to home screen
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        // Verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}

