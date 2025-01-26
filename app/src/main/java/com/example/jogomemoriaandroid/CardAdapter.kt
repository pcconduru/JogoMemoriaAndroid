package com.example.jogomemoriaandroid

import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.jogomemoriaandroid.databinding.CardDesingBinding

class CardAdapter(
    private val lista: List<String>
): Adapter<CardAdapter.CardViewHolder>()
{

    inner class CardViewHolder(
        private val binding: CardDesingBinding
    ) : RecyclerView.ViewHolder( binding.root ) {
        fun bind(cardsId : String){}
        fun cardSize(){
            val layoutParams = binding.cvMemoria.layoutParams
            val Altura = layoutParams.height
            val Largura = layoutParams.width
            var porcentagem = 0f

            when( linhas ){
                1 -> porcentagem = 1f
                2 -> porcentagem = 0.5f
                3 -> porcentagem = 0.33f
                4 -> porcentagem = 0.25f
                5 -> porcentagem = 0.20f
            }

            layoutParams.width = (Altura * porcentagem).toInt()
            layoutParams.height = (Largura * porcentagem).toInt()
            binding.cvMemoria.radius = 10f
            binding.cvMemoria.layoutParams = layoutParams
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(
            parent.context
        )
        val itemView = CardDesingBinding.inflate(
            layoutInflater, parent, false
        )
        return CardViewHolder( itemView )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardsId = lista[position]
        holder.bind(cardsId)
        holder.cardSize()
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}

