/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import java.util.ArrayList;
import java.util.List;
import models.MinMaxBattleNode;
import models.Pokemon;

/**
 *
 * @author alulab14
 */

/*
Se usa la siguiente info del nodo:
nodo.teamA
nodo.teamB
nodo.actualA
nodo.actualB
nodo.turnoAoB // Si es par es turno A, si es impar turno de B
nodo.nivel
nodo.chosenMove  //0,1,2,3 ataque Pokemon; 4,5: cambio de pokemon

//Team A is max, Team B is min
*/
public class MinMaxAlgorithmRecursive {
    
    public static double  fh (MinMaxBattleNode nodo ){
        if (nodo.getGeneticFlag()==0){
            int vidaA = 0, vidaB = 0;
            for (Pokemon p : nodo.getTeamA()) {
                vidaA += p.getHitPoints();
            }
            for (Pokemon p : nodo.getTeamB()) {
                vidaB += p.getHitPoints();
            }
            return vidaA - vidaB;
        } else {
            return SecondHeuristic.value(nodo.getTeamB(), nodo.getTeamA());
        }
    }
    
    
    
    public static double nextMove ( MinMaxBattleNode nodo){  //Devuelve valor de la funcion heuristica, el mejor movimiento esta en nodo.chosenMove
        
        if ( nodo.getNivel() == 5 )  return fh(nodo); //Llego al final xd            
        if (seAcabo(nodo)) return fh(nodo); // Si los pokemon del weon que le toca jugar no tienen vida, ya perdio xd
        
        
        List<MinMaxBattleNode> nodosHijos = new ArrayList<MinMaxBattleNode>(6);
        // Si la vida del pokemon actual del team actual tiene vida mayor a cero, entonces puede hacer sus movimientos    
        if ( vidaPokemonActualTeamActual(nodo)>0){
            
            for (int i=0;i<4;i++){
                nodosHijos.add(crearNodoAtaque(nodo,i));              
                
                //System.out.println("despues "+nodosHijos.get(nodosHijos.size()).getTeamB().get(nodosHijos.get(nodosHijos.size()).getActualB()).getName()+" "+ nodosHijos.get(nodosHijos.size()).getTeamB().get(nodosHijos.get(nodosHijos.size()).getActualB()).getHitPoints()+"");
            }
            
        }
        if (nodosHijos.isEmpty())
            for (int i=0;i<4;i++){
                nodosHijos.add(null);            
            }
        //Se crean otros nodos para los pokemones cambiables
            
            for ( int i=0;i<3;i++){
                if (nodo.getTurnoAoB()%2 ==0){ //Analizamos pokemones cambiables de A
                    if (i != nodo.getActualA()){
                        if ( nodo.getTeamA().get(i).getHitPoints() > 0) {
                            nodosHijos.add(crearNodoCambio(nodo,i));
                        }
                        else nodosHijos.add(null);
                    }
                }
                else { //Analizamos pokemones cambiables de B
                    if (i != nodo.getActualB()){
                        if ( nodo.getTeamB().get(i).getHitPoints() > 0) { 
                            nodosHijos.add(crearNodoCambio(nodo,i));
                        }
                        else nodosHijos.add(null);
                    }
                }
                    
            }
            
        System.out.println("tamaño "+nodosHijos.size());
        //Se escoge el movimiento mas idoneo dependiendo del turno A o B    
        double max =-999999, min =99999999,val = 0; 
        int imax=-1, imin=-1;
        for (int i=0;i<6;i++){
            if (nodosHijos.get(i)!= null) val = nextMove(nodosHijos.get(i));   //ACA ESTA LA RECURSIVIDAD PAPUS, CON HILOS CORRERIA MAS RAPIDO
            if ( val > max){
                imax =i;
                max=val;
            }
            if ( val < min){
                imin =i;
                min=val;
            }
        }
        
        if (nodo.getTurnoAoB() % 2 ==0 ) {
            nodo.setChosenMove(imax);
            return max;
        }
        nodo.setChosenMove(imin);
        return min;
    }
    public static boolean seAcabo (MinMaxBattleNode nodo){
        int vidaP=0;
        if ( nodo.getTurnoAoB() % 2 ==0 ) {//Turno de A
            for (Pokemon p : nodo.getTeamA()){
            vidaP+= p.getHitPoints();
            }
        }
        else {
            for (Pokemon p : nodo.getTeamB()){
            vidaP+= p.getHitPoints();
            }           
        }
        if (vidaP>0) return false;
        return true;
            
    }
    public static int vidaPokemonActualTeamActual(MinMaxBattleNode nodo){
        if ( nodo.getTurnoAoB() % 2 ==0 ) {//Turno de A
            return (nodo.getTeamA().get(nodo.getActualA()).getHitPoints());
        } else { //turno de B
            return (nodo.getTeamB().get(nodo.getActualB()).getHitPoints());
        }
    }
    
    public static MinMaxBattleNode crearNodoCambio ( MinMaxBattleNode nodo, int i){
        int tempA = nodo.getActualA(), tempB = nodo.getActualB();
        
        if ( nodo.getTurnoAoB() % 2 ==0 ){
        
        nodo.setActualA(i);
        nodo.setTurnoAoB(nodo.getTurnoAoB()+1);
        nodo.setNivel(nodo.getNivel()+1);
        
        } else {
        nodo.setActualB(i);
        nodo.setTurnoAoB(nodo.getTurnoAoB()+1);
        nodo.setNivel(nodo.getNivel()+1);        
        }
        return nodo;
        
    }
    
    public static MinMaxBattleNode crearNodoAtaque (MinMaxBattleNode nodo, int i){
        
        if (nodo.getTurnoAoB()%2 ==0) {
            //turno de atacar de A
            
            nodo.getTeamA().get(nodo.getActualA()).atacar(nodo.getTeamB().get(nodo.getActualB()), i);
           
        }
        else //turno de atacar de B 
            nodo.getTeamB().get(nodo.getActualB()).atacar(nodo.getTeamA().get(nodo.getActualA()), i);
        
        nodo.setNivel(nodo.getNivel()+1);
        nodo.setTurnoAoB(nodo.getTurnoAoB()+1);
        
        return nodo;        
    }    
}
