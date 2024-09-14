package br.pucpr.appdev.minhas_receitas.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.pucpr.appdev.minhas_receitas.R
import br.pucpr.appdev.minhas_receitas.model.Receita

class ReceitaAdapter(
    private val items: MutableList<Receita>,
    private val context: Context
) : RecyclerView.Adapter<ReceitaAdapter.ViewHolder>(){
    private lateinit var itemAdapter: IngredientesAdapter
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val itemTituloReceita: TextView = itemView.findViewById(R.id.txtTituloReceita)
        private val itensIngredientes: RecyclerView = itemView.findViewById(R.id.list_ingredientes)
        private val txtDescricaoReceita: TextView = itemView.findViewById(R.id.txtDescricaoReceita)
        fun bind(item: Receita){
            itemTituloReceita.text = item.titulo
            txtDescricaoReceita.text = item.descricao
            itemAdapter = IngredientesAdapter(item.ingredientes)
            itensIngredientes.adapter = itemAdapter
            itensIngredientes.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.receita_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
