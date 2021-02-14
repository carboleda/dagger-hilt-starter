package co.carlosarboleda.hilt.hiltpizzaedition.model

data class Aceite(override var quantity: Int) : Ingredient("Aceite", quantity) {
    var proveedor: String = "Exito"
}