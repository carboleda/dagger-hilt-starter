package co.carlosarboleda.hilt.hiltpizzaedition.model

import co.carlosarboleda.hilt.hiltpizzaedition.model.Ingredient

data class Pina(override val quantity: Int) : Ingredient("Piña", quantity)