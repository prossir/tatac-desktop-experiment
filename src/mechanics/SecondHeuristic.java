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
    public SecondHeuristic (List<Pokemon> playerTeam, List<Pokemon> enemyTeam){
        //Pesos manuales
        pesos[0] = 0.5;
        pesos[1] = 0.2;
        pesos[2] = 0.2;
        pesos[3] = 0.1;
        
        
        
        //Algoritmo genetico
        
        //Poblacion
        
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
    
    //FUNCION DE CREACION DE POBLACION
    public void crear_poblacion(){
        
    }
    
    //FUNCION DE FITNESS
}
