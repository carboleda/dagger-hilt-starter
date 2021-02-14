package co.carlosarboleda.hilt.hiltpizzaedition.model

data class Masa(
    val harina: Harina,
    val sal: Sal,
    val levadura: Levadura,
    val aceite: Aceite,
    val agua: Agua
) : Ingredient(
    name = "Masa",
    quantity = harina.quantity + sal.quantity + levadura.quantity + aceite.quantity + agua.quantity
)