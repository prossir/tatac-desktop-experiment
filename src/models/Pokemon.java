package models;

import java.util.ArrayList;
import java.util.List;

/* @author paolo */
public class Pokemon {

    private String name;
    private int totalHitPoints;
    private int hitPoints;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    private List<Move> moves;
    private List<Move> choosenMoves;
    private String pokemonType;

    //Para el minMax
    private int rateBurning;
    private int ratePoisoning;
    private int paralized; // 0,1,2,3, etc que son los turnos que estara dormido

    public Pokemon() {

    }

    public Pokemon(Pokemon pokemon) {
        name = pokemon.name;
        hitPoints = pokemon.hitPoints;
        totalHitPoints = pokemon.totalHitPoints;
        attack = pokemon.attack;
        defense = pokemon.defense;
        speed = pokemon.speed;
        moves = pokemon.moves;
        choosenMoves = new ArrayList<>();

        choosenMoves.add(pokemon.getChosenMoves().get(0));
        choosenMoves.add(pokemon.getChosenMoves().get(1));
        choosenMoves.add(pokemon.getChosenMoves().get(2));
        choosenMoves.add(pokemon.getChosenMoves().get(3));

        rateBurning = pokemon.rateBurning;
        ratePoisoning = pokemon.ratePoisoning;
        paralized = pokemon.paralized;
    }

    public int getRateBurning() {
        return rateBurning;
    }

    public void setRateBurning(int rateBurning) {
        this.rateBurning = rateBurning;
    }

    public int getRatePoisoning() {
        return ratePoisoning;
    }

    public void setRatePoisoning(int ratePoisoning) {
        this.ratePoisoning = ratePoisoning;
    }

    public int getParalized() {
        return paralized;
    }

    public void setParalized(int paralized) {
        this.paralized = paralized;
    }

    /**
     * @return the hitPoints
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * @param hitPoints the hitPoints to set
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @param attack the attack to set
     */
    public void setAttack(int attack) {
        this.attack = attack;
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

    /**
     * @return the moves
     */
    public List<Move> getMoves() {
        return moves;
    }

    /**
     * @param moves the moves to set
     */
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    /**
     * TODO These are "bussiness" function
     *
     * @param pokemon
     * @param moveNumber
     * @return
     */
    public int attack(Pokemon pokemon, int moveNumber) {
        int badLuck = (int) (Math.random() * 100);
        if (badLuck < moves.get(moveNumber).getAccuracy()) {
            //Sí le cae el ataque
            int newlife = pokemon.getHitPoints() - this.damage(pokemon, moveNumber);
            if (newlife < 0) {
                newlife = 0;
            }
            pokemon.setHitPoints(newlife);
            //Daños en futuro, aparte del daño instantaneo.
            //Si el daño anterior se esquiva, este tambien :v
            int r;
            r = moves.get(moveNumber).getRateBurning();
            if (r > pokemon.getRateBurning()) {
                pokemon.setRateBurning(r);
            }

            r = moves.get(moveNumber).getRatePoisoning();
            if (r > pokemon.getRatePoisoning()) {
                pokemon.setRatePoisoning(r);
            }

            //Se acumulan las paralizaciones :v
            r = moves.get(moveNumber).getParalized() + pokemon.getParalized();
            pokemon.setParalized(r);
            return 1;
        }
        return 0;
    }

    public int damage(Pokemon pokemon, int moveNumber) {
        int damage = (int) ((this.attack / (pokemon.getDefense() + pokemon.getSpeed() * 0.1))
                * moves.get(moveNumber).getBasePower());
        pokemon.setHitPoints(pokemon.getHitPoints() - damage);
        return damage;
    }

    public void getChosenMoves(List<Move> choosenMoves) {
        this.choosenMoves = choosenMoves;
    }

    public List<Move> getChosenMoves() {
        return choosenMoves;
    }

    public boolean lowHP() {
        return (totalHitPoints / 10 <= hitPoints);
    }

    /**
     * @return the totalHitPoints
     */
    public int getTotalHitPoints() {
        return totalHitPoints;
    }

    /**
     * @param totalHitPoints the totalHitPoints to set
     */
    public void setTotalHitPoints(int totalHitPoints) {
        this.totalHitPoints = totalHitPoints;
    }

    public String getType() {
        return pokemonType;
    }

    public void setType(String pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }

    public boolean bestDamage(Pokemon p) {
        int maxDamage = -9999;
        int damage;
//jugada del 0 al 3, el numero 4 es cambiar
        for (int i = 0; i < this.getChosenMoves().size(); i++) {
            damage = this.calculateDamage(p, i);
            if (maxDamage < damage) {
                maxDamage = damage;
            }
        }

        if (p.getHitPoints() - maxDamage <= 0) {
            p.setHitPoints(0);
            return true;
        }

        p.setHitPoints(p.getHitPoints() - maxDamage);
        return false;
    }

    private int calculateDamage(Pokemon pokemon, int moveNumber) {
        int damage = (int) ((this.attack / (pokemon.getDefense() + pokemon.getSpeed() * 0.1))
                * moves.get(moveNumber).getBasePower());
        return damage;
    }
}
