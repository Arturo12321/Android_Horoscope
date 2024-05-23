package com.isarep.horoscapp.data

import android.util.Log
import com.isarep.horoscapp.data.network.HoroscopeApiService
import com.isarep.horoscapp.domain.Repository
import com.isarep.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Arturo", "Ha ocurrido un error ${it.message}") }
        return null
    }
}