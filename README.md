# Pokedex App
A mobile Pokédex application developed in Kotlin for Android that allows users to browse through a small selection of Pokémon data and view detailed statistics for each Pokémon.
## Features
* Browse Pokémon through a searchable dropdown list
* Display Pokemon through a dropdown list
  * Pokedex Number
  * Pokemon Name
  * Primary and Secondary Types
  * HP
  * Attack
  * Defense
  * Special Attack
  * Special Defense
  * Speed
  * Total Stats
* Dynamic Pokemon image loading
* Type-specific visual styling
* Multi-screen navigation between selection and details pages
## Technologies Used
* Kotlin
* Android Studio
* XML Layouts
* CSV Data Processing
## Data Structure
Pokemon information is stored locally in a CSV file and loaded into the application at runtime. The app parses the dataset and populates the user interface dynamically.
## Architecture
#### Main Screen
* Loads Pokemon data from CSV assets
* Populates a Spinner dropdown with Pokemon names
* Allow users to select a Pokemon
<p align="center">
<img width="270" height="480" alt="image" src="https://github.com/user-attachments/assets/f8ebe8d7-c86c-4ef0-9d8a-4063fc24ce30" />
<img width="270" height="480" alt="image" src="https://github.com/user-attachments/assets/72fb4c2f-be42-4270-9f05-64b4402aa732" />
</p>

### Detail Screen
* Receives Pokemon information
* Displays Pokemon image and statistics
* Dynamically loads type badges and resources
<p align="center">
<img width="270" height="480" alt="image" src="https://github.com/user-attachments/assets/6c1d00c8-bedf-4d76-b739-6f67ba280bc4" />
</p>
