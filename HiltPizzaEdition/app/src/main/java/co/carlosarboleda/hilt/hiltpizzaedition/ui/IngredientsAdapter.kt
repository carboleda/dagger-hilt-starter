package co.carlosarboleda.hilt.hiltpizzaedition.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.carlosarboleda.hilt.hiltpizzaedition.R
import co.carlosarboleda.hilt.hiltpizzaedition.model.*

class IngredientsAdapter(private var dataSource: List<Ingredient>? = null) : RecyclerView.Adapter<IngredientsAdapter.IngredientHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ingredient_item, parent, false)
        return IngredientHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientHolder, position: Int) {
        if (dataSource == null) {
            return
        }

        holder.bind(dataSource!![position])
    }

    override fun getItemCount(): Int = dataSource?.size ?: 0

    fun setIngredients(ingredients: List<Ingredient>) {
        dataSource = ingredients
        notifyDataSetChanged()
    }

    class IngredientHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgImage: ImageView = itemView.findViewById(R.id.imgImage)
        private val tvName: TextView = itemView.findViewById(R.id.tvName)

        fun bind(ingredient: Ingredient) {
            tvName.text = itemView.context.getString(R.string.ingredient_text, ingredient.name, ingredient.quantity)
            imgImage.setImageResource(getImageIdForIngredient(ingredient))
        }

        private fun getImageIdForIngredient(ingredient: Ingredient): Int {
            return when (ingredient) {
                is Masa -> R.drawable.ic_masa
                is Aceite -> R.drawable.ic_aceite_de_oliva
                is Agua -> R.drawable.ic_agua
                is Harina -> R.drawable.ic_harina
                is Jamon -> R.drawable.ic_jamon
                is Levadura -> R.drawable.ic_levadura
                is Peperoni -> R.drawable.ic_peperoni
                is Pina -> R.drawable.ic_pina
                is Queso -> R.drawable.ic_queso
                is Sal -> R.drawable.ic_salero
                is Salsa -> R.drawable.ic_salsa_bbq
                else -> R.drawable.ic_launcher_background
            }
        }
    }

}