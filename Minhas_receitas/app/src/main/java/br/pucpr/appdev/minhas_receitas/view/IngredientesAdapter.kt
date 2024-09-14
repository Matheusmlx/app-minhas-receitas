package br.pucpr.appdev.minhas_receitas.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.pucpr.appdev.minhas_receitas.R
import br.pucpr.appdev.minhas_receitas.model.Ingrediente

class IngredientesAdapter (
    private val items: MutableList<Ingrediente>
) : RecyclerView.Adapter<IngredientesAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        private val itemQuantidade: TextView = itemView.findViewById(R.id.itemQuantityTextView)

        fun bind(item: Ingrediente) {
            itemNameTextView.text = item.nome
            itemQuantidade.text = item.quantidade.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pres_ingredientes, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}