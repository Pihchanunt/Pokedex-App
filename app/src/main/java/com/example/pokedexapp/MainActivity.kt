package com.example.pokedexapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var pokemon_list_spinner: Spinner

    data class PokemonData( // Create a data class for Pokemon
        val number: Int,
        val name: String,
        val typeone: String,
        val typetwo: String,
        val total: Int,
        val hp: Int,
        val atk: Int,
        val def: Int,
        val spatk: Int,
        val spdef: Int,
        val spd: Int
    )

    fun readPokemonFromCSV(context: Context): List<PokemonData> { // read CSV file
        val pokemonList = mutableListOf<PokemonData>()
        try {
            val inputStream = context.assets.open("FavPokemon.csv") // file in assets folder
            val reader = inputStream.bufferedReader()

            reader.useLines { lines ->
                lines.drop(1).forEach { line ->
                    val parts = line.split(",")
                    if (parts.size >= 11) {
                        val pokemondata = PokemonData(
                            number = parts[0].toIntOrNull() ?: 0,
                            name = parts[1],
                            typeone = parts[2],
                            typetwo = parts[3],
                            total = parts[4].toIntOrNull() ?: 0,
                            hp = parts[5].toIntOrNull() ?: 0,
                            atk = parts[6].toIntOrNull() ?: 0,
                            def = parts[7].toIntOrNull() ?: 0,
                            spatk = parts[8].toIntOrNull() ?: 0,
                            spdef = parts[9].toIntOrNull() ?: 0,
                            spd = parts[10].toIntOrNull() ?: 0
                        )
                        pokemonList.add(pokemondata)
                    } else {
                        Log.w("CSVWarning", "Skipped line: $line")
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("CSVError", "Failed to read CSV", e)
        }
        return pokemonList
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get IDs
        pokemon_list_spinner = findViewById(R.id.pokemon_spinner)
        val pokemonsubmitbutton = findViewById<Button>(R.id.submitbutton)

        // Load CSV data
        val pokedexdata = readPokemonFromCSV(this)
        if (pokedexdata.isEmpty()) Log.e("MainActivity", "No Pokémon loaded from CSV!")

        // Put name in drop down
        val pokemonNames = pokedexdata.map { it.name }
        val adapter = ArrayAdapter(this, R.layout.my_selected_item, pokemonNames)
        adapter.setDropDownViewResource(R.layout.my_dropdown_item)
        pokemon_list_spinner.adapter = adapter

        // Submit button
        pokemonsubmitbutton.setOnClickListener {
            val selectedIndex = pokemon_list_spinner.selectedItemPosition
            if (selectedIndex in pokedexdata.indices) {
                val selectedPokemon = pokedexdata[selectedIndex]
                val intent = Intent(this, PokemonInfo::class.java)
                intent.putExtra("number", selectedPokemon.number)
                intent.putExtra("name", selectedPokemon.name)
                intent.putExtra("typeone", selectedPokemon.typeone)
                intent.putExtra("typetwo", selectedPokemon.typetwo)
                intent.putExtra("total", selectedPokemon.total)
                intent.putExtra("hp", selectedPokemon.hp)
                intent.putExtra("atk", selectedPokemon.atk)
                intent.putExtra("def", selectedPokemon.def)
                intent.putExtra("spatk", selectedPokemon.spatk)
                intent.putExtra("spdef", selectedPokemon.spdef)
                intent.putExtra("spd", selectedPokemon.spd)
                startActivity(intent)
            }
        }

        // Debug log
        pokedexdata.forEach {
            Log.d("PokedexData", it.name)
        }
    }
}
