package com.example.jogomemoriaandroid

class Card {
    //Niveis de Dificuldade -> Facil, Medio, Dificil

    fun nivel(nvl : String): Int{

        return when( nvl ){
            "SUPERFACIL" -> 2
            "FACIL" -> 8
            "MEDIA" -> 10
            "DIFICIL" -> 18
            else -> 0
        }
    }

    //Embaralhador -> Mutable SetOff e Random
    fun embaralhar(dif : String): Set<String> {
        val baralho = setOf(
            "CSS",
            "HTML",
            "JAVASCRIPT",
            "JAVA",
            "PYTHON",
            "PHP",
            "KOTLIN",
            "REACT",
            "GITHUB"
        )
        val novoBaralho = baralho.shuffled().take(nivel(dif)).toSet()
        return novoBaralho
    }

    //Função de Escolha e Interação -> Pegar Valor PrimaEscolha e SegundaEscolha (Visivel ou não)
    fun interacao(){

    }

    //Verificador -> Verifica os valores e Retorna Mudanças
    fun verificar(){

    }

}