package co.carlosarboleda.hilt.hiltpizzaedition.model

import co.carlosarboleda.hilt.hiltpizzaedition.model.Ingredient

data class Levadura(override val quantity: Int) : Ingredient("Levadura", quantity)