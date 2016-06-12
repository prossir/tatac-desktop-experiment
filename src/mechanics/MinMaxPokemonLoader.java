package mechanics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import models.MinMaxMove;
import models.MinMaxPokemon;

/**
 *
 * @author paolo
 */
public class MinMaxPokemonLoader {
    public static List<MinMaxPokemon> loadPokemon(){
        List<MinMaxPokemon> challengers =  new ArrayList<>();
        try{
            
        File file = new File("input.txt");
	FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
	StringBuilder stringBuffer = new StringBuilder();
	String line;
	challengers = new ArrayList<> ();
        for (int i = 0 ; i < 20 ; i++){ // Una iteracion por cada pokemon
            line = bufferedReader.readLine();
        
            MinMaxPokemon a = new MinMaxPokemon ();
                a.setName(line);
                line = bufferedReader.readLine();
                a.setHitPoints(Integer.parseInt(line));
                line = bufferedReader.readLine();
                a.setAttack(Integer.parseInt(line));
                line = bufferedReader.readLine();
                a.setDefense(Integer.parseInt(line));
                line = bufferedReader.readLine();
                a.setSpeed(Integer.parseInt(line));
                ArrayList<MinMaxMove> powers = new ArrayList<>();
                for (int j = 0 ; j < 8 ; j++){ //Una iteracion por cada poder 
                    MinMaxMove move = new MinMaxMove ();
                    line = bufferedReader.readLine();//nombre
                    move.setName(line);
                    line = bufferedReader.readLine();   //basepower
                    move.setBasePower(Integer.parseInt(line));
                    line = bufferedReader.readLine();   //accuracy
                    move.setAccuracy(Integer.parseInt(line));
                    line = bufferedReader.readLine();   //
                    move.setType(line);                    
                    powers.add(move);
                }
                a.setMoves(powers);
                challengers.add(a);
                bufferedReader.readLine();
            }
        }
        catch (IOException | NumberFormatException e){
            System.out.println("Error de lectura");
        }
        return challengers;
     }
    
    public static void init(List<MinMaxPokemon> pokemones, 
            List<MinMaxPokemon> teamA, 
            List<MinMaxPokemon> teamB, 
            int max){
        
        for (int i =0;i<max;i++){
            Random ran = new Random();
            int a = ran.nextInt(20);
            int b = ran.nextInt(20);
            MinMaxPokemon pa = new MinMaxPokemon (pokemones.get(a));
            choosePowers(pa);
            MinMaxPokemon pb = new MinMaxPokemon (pokemones.get(b));
            choosePowers(pb);
            teamA.add(pa);
            teamB.add(pb);
        }
        
        
    }
    
    private static void choosePowers(MinMaxPokemon p){    
        Random ran = new Random();
        int a = ran.nextInt(8);
        int b = ran.nextInt(8);
        int c = ran.nextInt(8);
        int d = ran.nextInt(8);
        while (b==a) b=ran.nextInt(8);
        while (c==a || c==b) c=ran.nextInt(8);
        while (d==a || d==b || d==c) d=ran.nextInt(8);
        p.getChosenMoves().add(p.getMoves().get(a));
        p.getChosenMoves().add(p.getMoves().get(b));
        p.getChosenMoves().add(p.getMoves().get(c));
        p.getChosenMoves().add(p.getMoves().get(d));
    }
}