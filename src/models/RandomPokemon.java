/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.sun.org.apache.xml.internal.utils.SerializableLocatorImpl;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author LUIS
 */
public class RandomPokemon implements Serializable {
    private String name;
    private double hp;
    private int atack;
    private int defense;
    private int speed;
    private ArrayList<RandomMovement> allMov = new ArrayList<RandomMovement>();
    private ArrayList<RandomMovement> plaMov = new ArrayList<RandomMovement>();

    public RandomPokemon(){
        
    }
    
    public RandomPokemon(RandomPokemon p){
        name = p.name;
        hp=p.hp;
        atack = p.atack;
        defense = p.defense;
        speed=p.speed;
        plaMov = p.plaMov;
        allMov =p.allMov;
    }
    /**
     * @return the hp
     */
    public double getHp() {
        return hp;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(double hp) {
        this.hp = hp;
    }

    /**
     * @return the atack
     */
    public int getAtack() {
        return atack;
    }

    /**
     * @param atack the atack to set
     */
    public void setAtack(int atack) {
        this.atack = atack;
    }

    /**
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * @param defense the defense to set
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the allMov
     */
    public ArrayList<RandomMovement> getAllMov() {
        return allMov;
    }

    /**
     * @param allMov the allMov to set
     */
    public void setAllMov(ArrayList<RandomMovement> allMov) {
        this.allMov = allMov;
    }

    /**
     * @return the plaMov
     */
    public ArrayList<RandomMovement> getPlaMov() {
        return plaMov;
    }

    /**
     * @param plaMov the plaMov to set
     */
    public void setPlaMov(ArrayList<RandomMovement> plaMov) {
        this.plaMov = plaMov;
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
