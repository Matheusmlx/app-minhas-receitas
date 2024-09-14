package br.pucpr.appdev.minhas_receitas.model

data class Receita(val id: Int, val titulo: String, val ingrediente: MutableList<Ingrediente>, val novaDescricao: String){

    var ingredientes:MutableList<Ingrediente> = mutableListOf()
    var descricao: String = ""

    init {
        ingredientes = ingrediente
        descricao = novaDescricao
    }
    fun addIngrediente(ingrediente: Ingrediente) {
        ingrediente.id = ingredientes.size
        ingredientes.add(ingrediente.id!!, ingrediente)
    }

    fun remover(idIngrediente: Int) {
        ingredientes.removeAt(idIngrediente);
    }

    fun atualizarIngrediente(index: Int, ingrediente: Ingrediente) {
        ingredientes.find { it.id == index }?.run {
            this.id = ingrediente.id
            this.nome = ingrediente.nome
            this.quantidade = ingrediente.quantidade
        }
    }

}