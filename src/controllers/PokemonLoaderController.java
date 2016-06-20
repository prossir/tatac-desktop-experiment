package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import models.Move;
import models.Pokemon;

/* * @author paolo */
public class PokemonLoaderController {

    public static List<Pokemon> loadPokemon(int max) {
        List<Pokemon> challengers = new ArrayList<>();
        try {
            File file = new File("pokemons.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuffer = new StringBuilder();
            String line;
            challengers = new ArrayList<>();
            for (int i = 0; i < max; i++) { // Una iteracion por cada pokemon
                Pokemon pokemon = new Pokemon();
                line = bufferedReader.readLine();
                String[] arrPokemonData = line.split(",");

                pokemon.setName(arrPokemonData[0]);
                pokemon.setHitPoints(Integer.parseInt(arrPokemonData[1])*2 + 110);
                pokemon.setTotalHitPoints(Integer.parseInt(arrPokemonData[1])*2 + 110);
                pokemon.setAttack(Integer.parseInt(arrPokemonData[2])*2 + 5);
                pokemon.setDefense(Integer.parseInt(arrPokemonData[3])*2 + 5);
                pokemon.setSpAttack(Integer.parseInt(arrPokemonData[4])*2 + 5);
                pokemon.setSpDefense(Integer.parseInt(arrPokemonData[5])*2 + 5);
                pokemon.setSpeed(Integer.parseInt(arrPokemonData[6])*2 + 5);
                pokemon.setType(arrPokemonData[7]);

                //we set the new moves
                ArrayList<Move> powers = new ArrayList<>();
                for (int j = 0; j < 6; j++) {
                    line = bufferedReader.readLine();//nombre
                    Move move = new Move();
                    String[] arrMoveData = line.split(",");
                    move.setName(arrMoveData[0]);
                    move.setBasePower(Integer.parseInt(arrMoveData[1]));
                    move.setAccuracy(Integer.parseInt(arrMoveData[2]));
                    move.setType(arrMoveData[3]);
                    move.setKind(arrMoveData[4]);
                    move.setSpecial(arrMoveData[5]);
                    move.setSpecialChance(Integer.parseInt(arrMoveData[6]));
                    powers.add(move);
                }
                pokemon.setMoves(powers);
                challengers.add(pokemon);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return challengers;
    }

    public static void init(List<Pokemon> pokemones, List<Pokemon> teamA,
            List<Pokemon> teamB, int max, int numberOfPokemonsOnDatabase) {

        for (int i = 0; i < max; i++) {
            Random ran = new Random();
            int a = ran.nextInt(numberOfPokemonsOnDatabase);
            int b = ran.nextInt(numberOfPokemonsOnDatabase);
            Pokemon pa = new Pokemon(pokemones.get(a));
            choosePowers(pa);
            Pokemon pb = new Pokemon(pokemones.get(b));
            choosePowers(pb);
            teamA.add(pa);
            teamB.add(pb);
        }
    }

    private static void choosePowers(Pokemon p) {
        Random ran = new Random();
        int a = ran.nextInt(6);
        int b = ran.nextInt(6);
        int c = ran.nextInt(6);
        int d = ran.nextInt(6);
        while (b == a) {
            b = ran.nextInt(6);
        }
        while (c == a || c == b) {
            c = ran.nextInt(6);
        }
        while (d == a || d == b || d == c) {
            d = ran.nextInt(6);
        }
        p.getChosenMoves().add(p.getMoves().get(a));
        p.getChosenMoves().add(p.getMoves().get(b));
        p.getChosenMoves().add(p.getMoves().get(c));
        p.getChosenMoves().add(p.getMoves().get(d));
    }
}
