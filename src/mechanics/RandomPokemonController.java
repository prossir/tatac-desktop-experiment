package mechanics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import static mechanics.RandomMovementController.ElegirPoder;
import models.Move;
import models.Pokemon;

/**
 * @author LUIS
 */
public class RandomPokemonController {

    static final ArrayList<Pokemon> LeerArchivo(String arch, ArrayList<Pokemon> pokemones) {
        ArrayList<Pokemon> pokemones2 = null;
        try {

            File file = new File("input.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            //line = bufferedReader.readLine();
            //System.out.println(line);
            //ArrayList<Pokemon> pokemones2;
            pokemones2 = new ArrayList<Pokemon>();
            for (int i = 0; i < 20; i++) { // Una iteracion por cada pokemon
                line = bufferedReader.readLine();

                Pokemon a = new Pokemon();
                a.setName(line);
                line = bufferedReader.readLine();
                a.setHitPoints(Integer.parseInt(line));
                line = bufferedReader.readLine();
                a.setAttack(Integer.parseInt(line));
                line = bufferedReader.readLine();
                a.setDefense(Integer.parseInt(line));
                line = bufferedReader.readLine();
                a.setSpeed(Integer.parseInt(line));
                ArrayList<Move> poderes = new ArrayList<>();
                for (int j = 0; j < 8; j++) { //Una iteracion por cada poder 
                    Move b = new Move();
                    line = bufferedReader.readLine();//nombre
                    b.setName(line);
                    line = bufferedReader.readLine();   //basepower
                    b.setBasePower(Integer.parseInt(line));
                    line = bufferedReader.readLine();   //accuracy
                    b.setAccuracy(Integer.parseInt(line));
                    line = bufferedReader.readLine();   //
                    b.setType(line);
                    poderes.add(b);
                }
                a.setMoves(poderes);
                pokemones2.add(a);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error de lectura");
        }
        pokemones = pokemones2;
        System.out.println("Lectura completada");
        return pokemones2;
    }

    static void IniciarPelea(ArrayList<Pokemon> pokemones,
            ArrayList<Pokemon> teamA, ArrayList<Pokemon> teamB, int numero) {

        for (int i = 0; i < numero; i++) {
            Random ran = new Random();
            int a = ran.nextInt(20);
            int b = ran.nextInt(20);
            Pokemon pa = new Pokemon(pokemones.get(a));
            ElegirPoder(pa);
            Pokemon pb = new Pokemon(pokemones.get(b));
            ElegirPoder(pb);
            teamA.add(pa);
            teamB.add(pb);
        }

    }

    static void ImprimirPokemones(ArrayList<Pokemon> pokemones) {
        for (int i = 0; i < 20; i++) {
            System.out.println(pokemones.get(i).getName());
            for (int j = 0; j < 8; j++) {
                System.out.println("  " + pokemones.get(i).getChosenMoves().get(j).getName());
            }
        }
    }

    static void Resumen(ArrayList<Pokemon> teamA, ArrayList<Pokemon> teamB) {
        int tam = teamA.size();
        System.out.println("Equipo A");
        for (int i = 0; i < tam; i++) {
            System.out.println(teamA.get(i).getName() + " : " + teamA.get(i).getHitPoints());
        }
        System.out.println("Equipo B");
        for (int i = 0; i < tam; i++) {
            System.out.println(teamB.get(i).getName() + " : " + teamB.get(i).getHitPoints());

        }

        String ganador;
        int alivesA = 0;
        if (alivesA > 0) {
            ganador = "Equipo A";
        } else {
            ganador = "Equipo B";
        }
        System.out.println("El ganador es el " + ganador);
    }

}
