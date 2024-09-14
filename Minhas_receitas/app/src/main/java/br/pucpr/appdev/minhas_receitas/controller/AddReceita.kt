package br.pucpr.appdev.minhas_receitas.controller

import br.pucpr.appdev.minhas_receitas.view.ReceitaAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.pucpr.appdev.minhas_receitas.databinding.ActivityAddReceitaBinding
import br.pucpr.appdev.minhas_receitas.model.DataHolder
import br.pucpr.appdev.minhas_receitas.model.Ingrediente
import br.pucpr.appdev.minhas_receitas.model.Receita
import br.pucpr.appdev.minhas_receitas.view.Ingrediente_item_preAdapter

class AddReceita : AppCompatActivity() {
    private lateinit var itemNameEditText: EditText
    private lateinit var itemQuantityEditText: EditText
    private lateinit var addButton: Button
    private lateinit var salvarReceita: Button
    private lateinit var receiteDescricao: EditText
    private lateinit var recyclerView: RecyclerView
    private  lateinit var itemDescricao: TextView
    private lateinit var nomeReceitaView: TextView
    private lateinit var itemAdapter: Ingrediente_item_preAdapter
    private lateinit var receitaAdapter: ReceitaAdapter
    private val  receitas  = DataHolder.getInstance()
    private val ingredientes = mutableListOf<Ingrediente>()

    private lateinit var binding: ActivityAddReceitaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddReceitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemNameEditText = binding.edNome
        receiteDescricao = binding.txtDescricao
        itemQuantityEditText = binding.edQuantidade
        itemDescricao = binding.boxDescricao
        addButton = binding.adicionarItemRascunho
        nomeReceitaView = binding.txtNomeReceita
        salvarReceita = binding.salvarReceita
        recyclerView = binding.listItem

        itemAdapter = Ingrediente_item_preAdapter(ingredientes)
        receitaAdapter = ReceitaAdapter(receitas.globalList, this)
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        addButton.setOnClickListener {
            val name = itemNameEditText.text.toString()
            val quantidade = itemQuantityEditText.text.toString()
            if(name.isNotEmpty()){
                ingredientes.add(Ingrediente(ingredientes.size,name,quantidade.toLong()))
                itemAdapter.notifyDataSetChanged()
                itemDescricao.text = receiteDescricao.text
                itemNameEditText.text.clear()
                itemQuantityEditText.text.clear()
            }
        }

        salvarReceita.setOnClickListener {
            val name = nomeReceitaView.text.toString()
            val descricao = receiteDescricao.text.toString()
            receitas.globalList.add((Receita(receitas.globalList.size,name,ingredientes, descricao)))
            receitaAdapter.notifyDataSetChanged()
            Intent(this, MainActivity::class.java).run {
                startActivity(this)
            }

        }
    }
}