package com.example.compose.sceens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class CharacteristicModel(
    val title: String,
    val value: String
)

class ProductViewModel : ViewModel() {

    private val _article = MutableLiveData("Артикул: 89789")
    val article: LiveData<String> = _article

    private val _title = MutableLiveData("Дрель акк")
    val title: LiveData<String> = _title

    private val _itemsInCard = MutableLiveData(0)
    val itemsInCard: LiveData<Int> = _itemsInCard

    fun addToCart() = _itemsInCard.postValue(1)

    private val _availableCount = MutableLiveData(9999)
    val availableCount: LiveData<Int> = _availableCount

    private val _pickupStoreCount = MutableLiveData(10)
    val pickupStoreCount: LiveData<Int> = _pickupStoreCount

    private val _characteristic =
        MutableLiveData(
            listOf(
                CharacteristicModel(title = "Толщина", value = "12.5"),
                CharacteristicModel(title = "Вес", value = "8.8"),
                CharacteristicModel(title = "Марка", value = "KNAUF"),
                CharacteristicModel(title = "Производитель", value = "KNAUF"),
            )
        )
    val characteristic: LiveData<List<CharacteristicModel>> = _characteristic
}