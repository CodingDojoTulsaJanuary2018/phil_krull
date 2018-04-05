package pokemon;

public class Pokedex extends AbstractPokemon {
	public String pokemonInfo(Pokemon pokemon) {
		return "Pokemon info:\n \t name: " + pokemon.getName() + "\n \t health: " + pokemon.getHealth() + "\n \t type: " + pokemon.getType();
	}
}
