package co.carlosarboleda.hilt.hiltpizzaedition.model

import co.carlosarboleda.hilt.hiltpizzaedition.model.Ingredient

data class Jamon(override val quantity: Int) : Ingredient("Jamón", quantity)