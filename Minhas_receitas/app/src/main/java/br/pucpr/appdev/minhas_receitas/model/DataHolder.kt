package br.pucpr.appdev.minhas_receitas.model

class DataHolder {
    val globalList: MutableList<Receita> = mutableListOf(
        Receita(0, "Doguinho Sr Lourenço",
            mutableListOf(
                Ingrediente(1, "Copo de Agua", 1),
                Ingrediente(2, "Oleo", 1),
                Ingrediente(3, "Açucar", 1),
                Ingrediente(4, "Colher de Sal", 2),
                Ingrediente(5, "Trigo", 2),
                Ingrediente(6, "Fermento", 2),
            ),
            "Descansar por 1 hora para crescer abrir no rolo não muito fina. Cortar Rodelas com copo. Cortar vina 4 pedaços"
        ),
        Receita(0, "Massa Salgada P/ 40-45 unidades",
            mutableListOf(
                Ingrediente(1, "Açucar", 1),
                Ingrediente(2, "Sal", 1),
                Ingrediente(3, "Oleo", 1),
                Ingrediente(4, "Agua Morna", 2),
                Ingrediente(5, "", 2),
            ),
            ""
        ),
    )

    companion object {
        private var instance: DataHolder? = null

        fun getInstance(): DataHolder {
            if(instance == null) {
                instance = DataHolder()
            }
            return instance as DataHolder
        }
    }
}