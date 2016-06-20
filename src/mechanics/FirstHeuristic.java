/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import java.util.List;
import models.Pokemon;

/**
 * @author paolo
 */
public class FirstHeuristic {
    public static int value(List<Pokemon> playerTeam, List<Pokemon> enemyTeam) {
        int total = 0;//Valor  de cada nodo final = vidaRestanteDeLosPokemonesDePC  - vidaRestanteDeNuestros pokemones
        for (int i = 0; i < playerTeam.size(); i++) {
            total = total + playerTeam.get(i).getHitPoints()/2 - 2*enemyTeam.get(i).getHitPoints();
        }
        return total;
    }
}