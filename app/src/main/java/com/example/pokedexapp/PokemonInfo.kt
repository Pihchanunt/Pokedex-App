package com.example.pokedexapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PokemonInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_info)

    // Get IDs
    val nameText: TextView = findViewById(R.id.pokemon_name)
    val pokemonPic: ImageView = findViewById(R.id.pokemon_pic)
    val numbText: TextView = findViewById(R.id.pokedex_number)
    val backbutton: Button = findViewById(R.id.backbutton)
    val primarytype: TextView = findViewById(R.id.primary_type)
    val secondarytype: TextView = findViewById(R.id.secondary_type)
    val hpstats: TextView = findViewById(R.id.hpstats)
    val atkstats: TextView = findViewById(R.id.atkstats)
    val defstats: TextView = findViewById(R.id.defstats)
    val spatkstats: TextView = findViewById(R.id.spatkstats)
    val spdefstats: TextView = findViewById(R.id.spdefstats)
    val spdstats: TextView = findViewById(R.id.spdstats)
    val totalstats: TextView = findViewById(R.id.totalstats)


    // Back button
    backbutton.setOnClickListener{
        val backintent = Intent(this, MainActivity::class.java)
        startActivity(backintent)
    }

    // Get data from intent
    val name = intent.getStringExtra("name") ?: "Unknown"
    val number = intent.getIntExtra("number", 0)
    val typeone = intent.getStringExtra("typeone")
    val typetwo = intent.getStringExtra("typetwo")
    val total = intent.getIntExtra("total", 0)
    val hp = intent.getIntExtra("hp", 0)
    val atk = intent.getIntExtra("atk", 0)
    val def = intent.getIntExtra("def", 0)
    val spatk = intent.getIntExtra("spatk", 0)
    val spdef = intent.getIntExtra("spdef", 0)
    val spd = intent.getIntExtra("spd", 0)

    // Set image
    val picName = name.lowercase()
    val picid = resources.getIdentifier(picName, "drawable", packageName)
    pokemonPic.setImageResource(picid)

    // Set name
    nameText.text = name

    // Set pokedex number
    numbText.text = String.format("No."+"%04d", number)

    // Set type
    val typeoneBack = typeone?.lowercase()
    val typetwoBack = typetwo?.lowercase()
    val typeoneid = resources.getIdentifier("type_"+typeoneBack, "drawable", packageName)
    val typetwoid = resources.getIdentifier("type_"+typetwoBack, "drawable", packageName)
    primarytype.setBackgroundResource(typeoneid)
    secondarytype.setBackgroundResource(typetwoid)
    val typeoneText = typeone?.uppercase()
    val typetwoText = typetwo?.uppercase()
    primarytype.text = typeoneText
    secondarytype.text = typetwoText

    // Set HP stats
    hpstats.text = hp.toString()
    // Set ATK stats
    atkstats.text = atk.toString()
    // Set DEF stats
    defstats.text = def.toString()
    // Set Sp. ATK stats
    spatkstats.text = spatk.toString()
    // Set Sp. DEF stats
    spdefstats.text = spdef.toString()
    // Set SPD stats
    spdstats.text = spd.toString()
    // Set Total stats
    totalstats.text = total.toString()

    }
}