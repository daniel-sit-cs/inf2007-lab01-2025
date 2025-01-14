package com.inf2007.lab01

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun mainScreenTest() {
        // Set up the UI
        composeTestRule.setContent {
            MainScreen()
        }

        // Check the TextField is displayed
        composeTestRule.onNodeWithTag("nameInput").assertIsDisplayed()

        // Check the Submit button is displayed
        composeTestRule.onNodeWithTag("submitButton").assertIsDisplayed()

        // Check the greeting message is not displayed initially
        composeTestRule.onNodeWithTag("greetingMsg").assertDoesNotExist()
    }

    @Test
    fun testGreetingAppearsOnSubmit() {
        // Set up the UI
        composeTestRule.setContent {
            MainScreen()
        }

        // Enter a name in the TextField
        composeTestRule.onNodeWithTag("nameInput").performTextInput("John")

        // Click the Submit button
        composeTestRule.onNodeWithTag("submitButton").performClick()

        // Check the greeting message is displayed
        composeTestRule.onNodeWithTag("greetingMsg").assertIsDisplayed()

        // Check the greeting message text matches the expected value
        composeTestRule.onNodeWithTag("greetingMsg").assertTextEquals("Hello John!, Welcome to INF2007!")
    }

    @Test
    fun testGreetingDoesNotAppearForBlankInput() {
        // Set up the UI
        composeTestRule.setContent {
            MainScreen()
        }

        // Leave the TextField empty and click Submit
        composeTestRule.onNodeWithTag("submitButton").performClick()

        // Check the greeting message is not displayed
        composeTestRule.onNodeWithTag("greetingMsg").assertDoesNotExist()
    }

    @Test
    fun testGreetingUpdatesWithNewInput() {
        // Set up the UI
        composeTestRule.setContent {
            MainScreen()
        }

        // Enter the first name and submit
        composeTestRule.onNodeWithTag("nameInput").performTextInput("John")
        composeTestRule.onNodeWithTag("submitButton").performClick()

        // Check the greeting message matches the first name
        composeTestRule.onNodeWithTag("greetingMsg").assertTextEquals("Hello John!, Welcome to INF2007!")

        // Enter a new name and submit
        composeTestRule.onNodeWithTag("nameInput").performTextClearance()
        composeTestRule.onNodeWithTag("nameInput").performTextInput("Alice")
        composeTestRule.onNodeWithTag("submitButton").performClick()

        // Check the greeting message updates with the new name
        composeTestRule.onNodeWithTag("greetingMsg").assertTextEquals("Hello Alice!, Welcome to INF2007!")
    }
}
