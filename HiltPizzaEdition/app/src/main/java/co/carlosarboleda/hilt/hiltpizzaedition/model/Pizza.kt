package co.carlosarboleda.hilt.hiltpizzaedition.model

data class Pizza (
    val name: String,
    val masa: Masa,
    val ingredients: List<Ingredient> = emptyList()
)