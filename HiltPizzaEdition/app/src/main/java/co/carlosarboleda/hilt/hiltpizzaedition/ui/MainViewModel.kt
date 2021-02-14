package co.carlosarboleda.hilt.hiltpizzaedition.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.carlosarboleda.hilt.hiltpizzaedition.model.*

class MainViewModel : ViewModel() {
    private val pizzaHawaiana = factoryPizza("Hawaiana")
    private val pizzaPeperoni = factoryPizza("Peperoni")
    private val _pizza = MutableLiveData<Pizza>()
    val pizza: LiveData<Pizza> = _pizza

    init {
        _pizza.value = pizzaHawaiana
    }

    fun pizzaHawaiana() {
        _pizza.postValue(pizzaHawaiana)
    }

    fun pizzaPeperoni() {
        _pizza.postValue(pizzaPeperoni)
    }

    private fun factoryPizza(name: String): Pizza? {
        val masa = Masa(
                Harina(500),
                Sal(10),
                Levadura(20),
                Aceite(50),
                Agua(300)
        )

        if (name == "Hawaiana") {
            val ingredients: List<Ingredient> = listOf(
                    Salsa(200),
                    Queso(300),
                    Pina(400),
                    Jamon(30),
            )

            return Pizza(name, masa, ingredients)
        } else if (name == "Peperoni") {
            val ingredients: List<Ingredient> = listOf(
                    Salsa(200),
                    Queso(400),
                    Peperoni(300),
            )

            return Pizza(name, masa, ingredients)
        }

        return null
    }
}