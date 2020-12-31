package com.example.composerecipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {

    private val recipes = mutableListOf<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for (i in 0 until 5){
            recipes.add(Recipe(R.drawable.happy_meal_small,"Sample", listOf("Ingred 1","Ingred 2", "Ingred 3")))
        }
        setContent {
            Main()
        }

    }



    @Composable
    @Preview
    fun Main() {
        RecipeList(recipes = recipes)

    }

    @Composable
    fun RecipeCard(recipe:Recipe, modifier: Modifier){

        Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp, color = Color.White, modifier = modifier) {
            val image = imageResource(recipe.imageResource)
            Column {
                Image(asset = image, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth().height(200.dp))

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = recipe.title, style = MaterialTheme.typography.h4)

                    for (i in recipe.ingredients){
                        Text(text = "- $i", color = Color.Black, style = MaterialTheme.typography.h5)
                    }
                }

            }

        }
    }

    @Composable
    fun RecipeList(recipes:List<Recipe>){
        LazyColumnFor(items = recipes) {item->
            RecipeCard(recipe = item, Modifier.padding(16.dp))
        }
    }


}