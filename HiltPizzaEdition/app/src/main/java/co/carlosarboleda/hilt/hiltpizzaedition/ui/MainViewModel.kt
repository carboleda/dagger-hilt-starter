package co.carlosarboleda.hilt.hiltpizzaedition.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.carlosarboleda.hilt.hiltpizzaedition.model.Pizza
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainViewModel @Inject constructor(
    @Named("Hawaiana") private val pizzaHawaiana: Pizza,
    @Named("Peperoni") private val pizzaPeperoni: Pizza
) : ViewModel() {
    private val _pizza = MutableLiveData(pizzaPeperoni)
    val pizza: LiveData<Pizza> = _pizza

    fun pizzaHawaiana() {
        _pizza.postValue(pizzaHawaiana)
    }

    fun pizzaPeperoni() {
        _pizza.postValue(pizzaPeperoni)
    }
}