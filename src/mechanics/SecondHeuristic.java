/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import java.util.List;
import models.Move;
import models.Pokemon;

/**
 *
 * @author paolo
 */
public class SecondHeuristic {
    
    int cantPoblacionMax = 26;
    double[] pesos;
    public SecondHeuristic (){
        //Pesos manuales
        pesos[0] = 0.5;
        pesos[1] = 0.2;
        pesos[2] = 0.2;
        pesos[3] = 0.1;
    }
    public double calculate_factor_1(List<Pokemon> playerTeam, List<Pokemon> enemyTeam, double [] weights){
        return 0;
    }
    public double calculate_factor_2(List<Pokemon> playerTeam, List<Pokemon> enemyTeam, double [] weights){
        return 0;
    }
    public double calculate_factor_3(List<Pokemon> playerTeam, List<Pokemon> enemyTeam, double [] weights){
        return 0;
    }
    public double calculate_factor_4(List<Pokemon> playerTeam, List<Pokemon> enemyTeam, double [] weights){
        return 0;
    }
}
