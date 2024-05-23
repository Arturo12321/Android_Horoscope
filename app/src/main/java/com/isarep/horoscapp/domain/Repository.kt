package com.isarep.horoscapp.domain

import com.isarep.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String):PredictionModel?
}