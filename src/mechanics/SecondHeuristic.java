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
    
    private double[] pesos;
    private double heuristicValue;
    
    public SecondHeuristic (){
        //Pesos manuales
        pesos[0] = 0.5;
        pesos[1] = 0.2;
        pesos[2] = 0.2;
        pesos[3] = 0.1;
        
        
        
        //Algoritmo genetico
        
        //Poblacion
        
    }
    
    public double value(List<Pokemon> playerTeam, List<Pokemon> enemyTeam) {
        double total = 0;//Funcion propuesta por el profesor de acuerdo a pesos
        total = total + calculate_factor_1(playerTeam,enemyTeam)*pesos[0] +
                calculate_factor_2(playerTeam,enemyTeam)*pesos[1] + 
                calculate_factor_3(playerTeam,enemyTeam)*pesos[2] + 
                calculate_factor_4(playerTeam,enemyTeam)*pesos[3] ;
        heuristicValue = total;
        return total;
    }
    
    // FACTORES PARA CREAR ESTRATEGIA EN JUGADA DE LA PC
    public double calculate_factor_1(List<Pokemon> playerTeam, List<Pokemon> enemyTeam){
        //suponiendo que A es player (humano), B es enemy (PC)
        int sumaVidaEnemy = 0, sumaVidaPlayer=0;
        for (int i = 0; i<playerTeam.size();i++){
            sumaVidaPlayer=sumaVidaPlayer+playerTeam.get(i).getHitPoints();
        }
        for (int i = 0; i<enemyTeam.size();i++){
            sumaVidaEnemy=sumaVidaEnemy+enemyTeam.get(i).getHitPoints();
        }        
        return sumaVidaEnemy - sumaVidaPlayer;
    }
    public double calculate_factor_2(List<Pokemon> playerTeam, List<Pokemon> enemyTeam){
        int vivosEnemy = 0, vivosPlayer=0;
        for (int i = 0; i<playerTeam.size();i++){
            if(playerTeam.get(i).getHitPoints()>0)
                vivosPlayer++;
        }
        for (int i = 0; i<enemyTeam.size();i++){
            if(enemyTeam.get(i).getHitPoints()>0)
                vivosEnemy++;
        }       
        return vivosEnemy - vivosPlayer;
    }
    public double calculate_factor_3(List<Pokemon> playerTeam, List<Pokemon> enemyTeam){
        int sumaAtaqueEnemy = 0, sumaAtaquePlayer=0;
        for (int i = 0; i<playerTeam.size();i++){
            sumaAtaquePlayer=sumaAtaquePlayer+playerTeam.get(i).getAttack();
        }
        for (int i = 0; i<enemyTeam.size();i++){
            sumaAtaqueEnemy=sumaAtaqueEnemy+enemyTeam.get(i).getAttack();
        }        
        return sumaAtaqueEnemy - sumaAtaquePlayer;
    }
    public double calculate_factor_4(List<Pokemon> playerTeam, List<Pokemon> enemyTeam){
        int sumaDefensaEnemy = 0, sumaDefensaPlayer=0;
        for (int i = 0; i<playerTeam.size();i++){
            sumaDefensaPlayer=sumaDefensaPlayer+playerTeam.get(i).getAttack();
        }
        for (int i = 0; i<enemyTeam.size();i++){
            sumaDefensaEnemy=sumaDefensaEnemy+enemyTeam.get(i).getAttack();
        }        
        return sumaDefensaEnemy - sumaDefensaPlayer;
    }

    /**
     * @return the heuristicValue
     */
    public double getHeuristicValue() {
        return heuristicValue;
    }

    /**
     * @param heuristicValue the heuristicValue to set
     */
    public void setHeuristicValue(double heuristicValue) {
        this.heuristicValue = heuristicValue;
    }
    
}
