package br.pucpr.appdev.minhas_receitas
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import br.pucpr.appdev.minhas_receitas.controller.AddReceita
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun AddReceitaActivity() {
        val scenario = launch(AddReceita::class.java)
        scenario.recreate()
    }

    @Test
    fun testIten() {
        launch(AddReceita::class.java)
        onView(withId(R.id.txtDescricao)).perform(clearText(), typeText("Bolo de cenoura"))
        onView(withId(R.id.adicionarItemRascunho)).perform(click())
        onView(withId(R.id.box_descricao)).check(matches(withText("Bolo de cenoura")))
    }

}