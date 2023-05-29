package DefiningClasses.P6_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {

    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public int getBadges() {
        return badges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public boolean hasPokemonWithGivenElement(String element) {
        return this.pokemons.stream()
                            .map(Pokemon::getElement)
                            .collect(Collectors.toList())
                            .contains(element);
    }

    public void increaseBadges() {
        this.badges += 1;
    }

    public void decreasePokemonsHealth() {
        this.pokemons.forEach(p -> p.setHealth(p.getHealth() - 10));
    }

    public void removeDiedPokemons() {
        this.pokemons.removeIf(p -> p.getHealth() <= 0);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, badges, pokemons.size());
    }
}
