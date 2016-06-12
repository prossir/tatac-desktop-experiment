/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author LUIS
 */
public class RandomMovement implements Serializable{
    private String name;
    private int basePower;
    private int accuracy;
    private String type;
    
    public RandomMovement (){
        
    }
    
    public RandomMovement (RandomMovement e){
        name = e.name;
        basePower=e.basePower;
        accuracy = e.accuracy;
        type = e.type;
    }
    
    public RandomMovement (int a, int b, String c){
        basePower = a;
        accuracy = b;
        type = c;
    }

    /**
     * @return the basePower
     */
    public int getBasePower() {
        return basePower;
    }

    /**
     * @param basePower the basePower to set
     */
    public void setBasePower(int basePower) {
        this.basePower = basePower;
    }

    /**
     * @return the accuracy
     */
    public int getAccuracy() {
        return accuracy;
    }

    /**
     * @param accuracy the accuracy to set
     */
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
}
