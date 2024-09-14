package br.pucpr.appdev.minhas_receitas.controller

import br.pucpr.appdev.minhas_receitas.view.ReceitaAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.pucpr.appdev.minhas_receitas.databinding.ActivityMainBinding
import br.pucpr.appdev.minhas_receitas.model.DataHolder

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private lateinit var adapter: ReceitaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ReceitaAdapter(DataHolder.getInstance().globalList, this)
        val listItens = binding.listaReceitas
        listItens.adapter = adapter
        listItens.layoutManager = LinearLayoutManager(this)
        listItens.setHasFixedSize(true)


        binding.btnNew.setOnClickListener {
            Intent(this, AddReceita::class.java).run {
                startActivity(this)
            }
        }

    }
}