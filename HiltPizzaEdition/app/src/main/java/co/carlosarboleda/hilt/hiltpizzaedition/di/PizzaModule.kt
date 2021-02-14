package co.carlosarboleda.hilt.hiltpizzaedition.di

import android.content.Context
import co.carlosarboleda.hilt.hiltpizzaedition.R
import co.carlosarboleda.hilt.hiltpizzaedition.model.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
object PizzaModule {

    @Provides
    fun provideMasa() = Masa(
        Harina(500),
        Sal(10),
        Levadura(20),
        Aceite(50),
        Agua(300)
    )

    @Named("Hawaiana")
    @Provides
    fun providePizzaHawaiana(
        masa: Masa, @ApplicationContext
        context: Context
    ): Pizza {
        val ingredients: List<Ingredient> = listOf(
            Salsa(200),
            Queso(300),
            Pina(400),
            Jamon(30),
        )

        return Pizza(context.getString(R.string.hawaiana), masa, ingredients)
    }

    @Named("Peperoni")
    @Provides
    fun providePizzaPeperoni(
        masa: Masa,
        @ApplicationContext context: Context
    ): Pizza {
        val ingredients: List<Ingredient> = listOf(
            Salsa(200),
            Queso(400),
            Peperoni(300),
        )

        return Pizza(context.getString(R.string.peperoni), masa, ingredients)
    }
}