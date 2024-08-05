package com.ifsp.edu.medias.Strategy

interface MediaStrategy {
    fun calcularMedia(valores: List<Double>, pesos: List<Double>? = null): Double
}

class MediaAritmetica : MediaStrategy {
    override fun calcularMedia(valores: List<Double>, pesos: List<Double>?): Double {
        return valores.sum() / valores.size
    }
}

class MediaPonderada : MediaStrategy {
    override fun calcularMedia(valores: List<Double>, pesos: List<Double>?): Double {
        val totalPesos = pesos!!.sum()
        return valores.zip(pesos).sumOf { it.first * it.second } / totalPesos
    }
}

class MediaHarmonica : MediaStrategy {
    override fun calcularMedia(valores: List<Double>, pesos: List<Double>?): Double {
        return valores.size / valores.sumOf { 1.0 / it }
    }
}
