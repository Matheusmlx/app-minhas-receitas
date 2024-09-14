package br.pucpr.appdev.minhas_receitas

import br.pucpr.appdev.minhas_receitas.model.Ingrediente
import br.pucpr.appdev.minhas_receitas.model.Receita
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addIngrediente() {
        val ingrediente = mutableListOf<Ingrediente>(
            Ingrediente(1,"Ovo", 5),
            Ingrediente(2, "Cenoura Picada", 5)
        )

        Receita(1, "Bolo de cenoura",ingrediente, "Receita simples para ser vendida nas empresas e para os amigos").let {
            it.addIngrediente(Ingrediente(null, nome = "Leite", quantidade = 5))
            it.addIngrediente(Ingrediente(null, nome = "Farinha 400g", quantidade = 1))
            assertEquals(it.ingredientes.size, 4)
            assertEquals(it.ingredientes[0], Ingrediente(1, nome = "Ovo", quantidade = 5))
        }
    }

    @Test
    fun removeIngrediente() {
        val ingrediente = mutableListOf<Ingrediente>(
            Ingrediente(1,"Ovo", 3),
            Ingrediente(2, "Chocolate", 5)
        )

        Receita(1, "Bolo de chocolate",ingrediente, "Receita para um delicioso bolo de chocolate").let {
            it.addIngrediente(Ingrediente(null, nome = "Leite", quantidade = 5))
            it.remover(1)
            assertEquals(it.ingredientes.size, 2)
            assertEquals(it.ingredientes[0], Ingrediente(1, nome = "Ovo", quantidade = 3))
        }
    }

    @Test
    fun atualizarIngrediente() {
        val ingrediente = mutableListOf<Ingrediente>(
            Ingrediente(1,"Ovo", 3),
            Ingrediente(2, "Chocolate", 5)
        )

        Receita(1, "Bolo de chocolate",ingrediente, "Receita para um delicioso bolo de chocolate").let {
            it.addIngrediente(Ingrediente(null, nome = "Leite", quantidade = 5))
            it.atualizarIngrediente(1, Ingrediente(2, "Cholate em pó", 5))
            assertEquals(it.ingredientes.size, 3)
            assertEquals(it.ingredientes[0], Ingrediente(2, nome = "Cholate em pó", quantidade = 5))
        }
    }
}