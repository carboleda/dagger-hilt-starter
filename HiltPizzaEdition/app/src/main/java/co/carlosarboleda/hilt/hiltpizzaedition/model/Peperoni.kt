package co.carlosarboleda.hilt.hiltpizzaedition.model

import co.carlosarboleda.hilt.hiltpizzaedition.model.Ingredient

data class Peperoni(override val quantity: Int) : Ingredient("Peperoni", quantity)