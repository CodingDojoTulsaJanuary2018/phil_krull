package pokemon;

public class PokemonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pokedex game = new Pokedex();
		Pokemon p1 = game.createPokemon("Pikachu", 50, "short");
		Pokemon p2 = game.createPokemon("Absol", 20, "white");
		System.out.println("I have created " + Pokemon.getCount() + " Pokemon's");
		String info1 = game.pokemonInfo(p1);
		String info2 = game.pokemonInfo(p2);
		System.out.println(info1);
		System.out.println(info2);
		game.attackPokemon(p2);
		String info3 = game.pokemonInfo(p1);
		String info4 = game.pokemonInfo(p2);
		System.out.println(info3);
		System.out.println(info4);
	}

}
