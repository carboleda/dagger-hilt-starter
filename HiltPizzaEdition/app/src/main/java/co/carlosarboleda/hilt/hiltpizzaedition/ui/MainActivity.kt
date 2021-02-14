package co.carlosarboleda.hilt.hiltpizzaedition.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import co.carlosarboleda.hilt.hiltpizzaedition.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)

            binding.btnHawaiana.setOnClickListener { mainViewModel.pizzaHawaiana() }
            binding.btnPeperoni.setOnClickListener { mainViewModel.pizzaPeperoni() }
            binding.rvIngredients.also {
                it.adapter = IngredientsAdapter()
                it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            }

            mainViewModel.pizza.observe(this) {
                val ingredients = it.ingredients.toMutableList().apply {
                    add(0, it.masa)
                }
                binding.tvPizzaName.text = it.name
                (binding.rvIngredients.adapter as IngredientsAdapter)
                    .setIngredients(ingredients)
            }
        } catch (error: Exception) {
            Log.e(TAG, "onCreate", error)
        }
    }

    companion object {
        private const val TAG = "mainActivity"
    }
}