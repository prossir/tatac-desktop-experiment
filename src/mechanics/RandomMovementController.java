/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import java.util.ArrayList;
import java.util.Random;
import models.Pokemon;

/**
 *
 * @author LUIS
 */
public class RandomMovementController {

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
