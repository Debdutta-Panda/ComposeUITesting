package com.debduttapanda.composeuitesting

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.debduttapanda.composeuitesting.ui.theme.ComposeUITestingTheme
import org.junit.Rule
import org.junit.Test

class MyComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun blankInputTest() {
        // Start the app
        composeTestRule.setContent {
            ComposeUITestingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainUi()
                }
            }
        }

        composeTestRule.onNode(hasContentDescription("my_button")).performClick()

        composeTestRule.onNodeWithText("No one is here").assertExists()
    }

    @Test
    fun filledInputTest() {
        // Start the app
        composeTestRule.setContent {
            ComposeUITestingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainUi()
                }
            }
        }

        val name = "deb"
        composeTestRule.onNode(hasContentDescription("my_input")).performTextInput(name)
        composeTestRule.onNode(hasContentDescription("my_button")).performClick()
        composeTestRule.onNodeWithText("hi $name").assertExists()
    }
}