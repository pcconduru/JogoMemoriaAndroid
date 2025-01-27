package com.example.jogomemoriaandroid

import android.os.Bundle
import android.util.Size
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.jogomemoriaandroid.databinding.ActivityMainBinding
import com.example.jogomemoriaandroid.databinding.CardDesingBinding

internal var dificuldadeSelecionada = "DIFICIL"

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var lista : Set<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rvCards = binding.rvCards

        /*val lista = listOf(
            "Android",
            "Windows",
            "IOS",
            "",
            "",
            "",
            "",
            "",
            ""
        )*/
        val card = Card()
        val lista = card.embaralhar(dificuldadeSelecionada).toList()

        rvCards.adapter = CardAdapter( lista )
        rvCards.layoutManager = StaggeredGridLayoutManager(6, RecyclerView.VERTICAL)
    }
}