package mechanics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import models.Move;
import models.Pokemon;

/**
 * @author LUIS
 */
public class RandomAlgorithm {

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
    
        public static final void ElegirPoder(Pokemon p) {
        Random ran = new Random();
        int a = ran.nextInt(8);
        int b = ran.nextInt(8);
        int c = ran.nextInt(8);
        int d = ran.nextInt(8);

        while (b == a) {
            b = ran.nextInt(8);
        }

        while (c == a || c == b) {
            c = ran.nextInt(8);
        }

        while (d == a || d == b || d == c) {
            d = ran.nextInt(8);
        }

        p.getChosenMoves().add(p.getMoves().get(a));
        p.getChosenMoves().add(p.getMoves().get(b));
        p.getChosenMoves().add(p.getMoves().get(c));
        p.getChosenMoves().add(p.getMoves().get(d));
    }

    static void Pelear(ArrayList<Pokemon> teamA, ArrayList<Pokemon> teamB) {
        Random ran = new Random();

        boolean perdioA = false;
        boolean perdioB = false;
        int nMov = ran.nextInt(5);
        while (!perdioA && !perdioB) {
            //Jugada de A
            System.out.println("Humano juega.");
            int Turno = 0;
            Jugada(teamA, teamB);
            int currB = 0;
            if (Murio(teamB, currB)) {
                int alivesB = 0;
                alivesB--;
                if (Perdio(teamB)) {
                    perdioB = true;
                    break;
                } else {
                    currB = cambiarPokemon(teamB, currB);
                }
            }
            //Jugada de B
            System.out.println("Computador juega.");
            Turno = 1;
            Jugada(teamA, teamB);
            int currA = 0;
            if (Murio(teamA, currA)) {
                int alivesA = 0;
                alivesA--;
                if (Perdio(teamA)) {
                    perdioA = true;
                    break;
                } else {
                    currA = cambiarPokemon(teamA, currA);
                }
            }
        }

    }

    static final void Jugada(ArrayList<Pokemon> teamA, ArrayList<Pokemon> teamB) {
        Random ran = new Random();
        //jugada del 0 al 3, el numero 4 es cambiar
        int jugada = ran.nextInt(5);
        int Turno = 0;
        int alivesB = 0;
        int currA = 0;
        int currB = 0;
        if (Turno == 0) {
            int alivesA = 0;
//Turno humano

            if (alivesA == 1) {
                jugada = ran.nextInt(4);
            }
        } else//Turno computador
        {
            if (alivesB == 1) {
                jugada = ran.nextInt(4);
            }
        }

        if (jugada == 4) {
            if (Turno == 0) {
                currA = cambiarPokemon(teamA, currA);
            } else {
                currB = cambiarPokemon(teamB, currB);
            }
        } else if (Turno == 0) {
            Ataque(teamA.get(currA), teamB.get(currB), jugada);
        } else {
            Ataque(teamB.get(currB), teamA.get(currA), jugada);
        }
    }

    static final void Ataque(Pokemon pa, Pokemon pb, int n) {
        double atack = pa.getAttack();
        double defense = pb.getDefense();
        double basepower = pa.getChosenMoves().get(n).getBasePower();
        double speed = pb.getSpeed();
        double danio = (atack / (defense + speed * 2)) * basepower;
        double hpA = pa.getHitPoints();
        double hpB = pb.getHitPoints();
        System.out.println("El pokemon " + pa.getName() + " uso "
                + pa.getChosenMoves().get(n).getName() + " en " + pb.getName());
        System.out.println("Le inflingio " + danio + " de danio.");
        if ((hpB - danio) > 0) {
            pb.setHitPoints((int) (hpB - danio));
            System.out.println("Al pokemon " + pb.getName() + " le queda " + (hpB - danio) + " de vida.");
        } else {
            pb.setHitPoints(0);
            System.out.println("El pokemon " + pb.getName() + " Murio.");
        }
    }

    static final int cambiarPokemon(ArrayList<Pokemon> team, int curr) {
        int tam = team.size();
        Random ran = new Random();
        int random = ran.nextInt(tam);
        while (team.get(random).getHitPoints() == 0 || random == curr) {
            random = ran.nextInt(tam);
        }
        System.out.println("Se cambio el pokemon " + team.get(curr).getName() + " por " + team.get(random).getName());
        /*
        for (int i=0;i<tam;i++){
            if (team.get(i).getHp()>0 && i !=curr) return i;
        }
         */
        //return -1;
        return random;
    }

    static final boolean Murio(ArrayList<Pokemon> team, int curr) {
        if (team.get(curr).getHitPoints() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    static final boolean Perdio(ArrayList<Pokemon> team) {
        int tam = team.size();
        boolean murio = true;
        for (int i = 0; i < tam; i++) {
            if (team.get(i).getHitPoints() > 0) {
                murio = false;
            }
        }
        return murio;
    }

}