package controllers;

import models.Move;
import models.Pokemon;

/**
 * @author paolo
 */
public class PokemonRulesController {

    private static final String DARK = "DARK";
    private static final String FIGTHING = "FIGHTING";
    private static final String NORMAL = "NORMAL";
    private static final String GHOST = "GHOST";
    private static final String GROUND = "GROUND";
    private static final String DRAGON = "DRAGON";
    private static final String GRASS = "GRASS";
    private static final String BUG = "BUG";
    private static final String POISON = "POISON";
    private static final String WATER = "WATER";
    private static final String ICE = "ICE";
    private static final String FIRE = "FIRE";
    private static final String FAIRY = "FAIRY";
    private static final String PSYCHIC = "PSYCHIC";
    private static final String ROCK = "ROCK";
    private static final String STEEL = "STEEL";
    private static final String FLYING = "FLYING";
    private static final String ELECTRIC = "ELECTRIC";

    public double stab(Pokemon attacker, Move move) {
        if (attacker.getType().equals(move.getType())) {
            return 1.5;
        }
        return 1;
    }

    public double effectiveness(Move move, Pokemon attacked) {
        switch (move.getType()) {
            case DARK:
                if (attacked.getType().equals(FIGTHING)) {//1/2 figth
                    return 0.5;
                }
                if (attacked.getType().equals(PSYCHIC)
                        || attacked.getType().equals(GHOST)) {//2 phy, gho
                    return 2;
                }
                break;

            case FIGTHING:
                if (attacked.getType().equals(GHOST)) {//0* ghos
                    return 0;
                }
                if (attacked.getType().equals(POISON)
                        || attacked.getType().equals(FLYING)
                        || attacked.getType().equals(PSYCHIC)
                        || attacked.getType().equals(BUG)) {//1/2 pois, fly,psy,bug,
                    return 0.5;
                }
                if (attacked.getType().equals(NORMAL)
                        || attacked.getType().equals(ICE)
                        || attacked.getType().equals(ROCK)
                        || attacked.getType().equals(DARK)
                        || attacked.getType().equals(STEEL)) {//2* nor,ice,rock,dark,steel
                    return 2;
                }
                break;

            case NORMAL:
                if (attacked.getType().equals(GHOST)) {//0* ghos
                    return 0;
                }
                if (attacked.getType().equals(ROCK)
                        || attacked.getType().equals(STEEL)) {//1/2 rock, steel
                    return 0.5;
                }

                break;
            case GHOST:
                if (attacked.getType().equals(NORMAL)) {//0 normal
                    return 0;
                }
                if (attacked.getType().equals(DARK)) {//1/2 dark
                    return 0.5;
                }
                if (attacked.getType().equals(PSYCHIC)
                        || attacked.getType().equals(GHOST)) {//2 psy, gho
                    return 2;
                }
                break;
            case GROUND:
                if (attacked.getType().equals(FLYING)) {//0 fly
                    return 0;
                }
                if (attacked.getType().equals(GRASS)
                        || attacked.getType().equals(BUG)) {//1/2 gras, bug
                    return 0.5;
                }
                if (attacked.getType().equals(FIRE)
                        || attacked.getType().equals(ELECTRIC)
                        || attacked.getType().equals(POISON)
                        || attacked.getType().equals(ROCK)
                        || attacked.getType().equals(STEEL)) {//2 fir, elec, poi, rock, steel
                    return 2;
                }
                break;
            case DRAGON:
                if (attacked.getType().equals(FAIRY)) {//0 fairy
                    return 0;
                }
                if (attacked.getType().equals(STEEL)) {//1/2 steel
                    return 0.5;
                }
                if (attacked.getType().equals(DRAGON)) {//2* dragon
                    return 2;
                }                
                break;
            case GRASS:
                //1/2 fir, poi, fly, bugdragon, steel
                //2 watm gro, rock
                break;
            case BUG:
                //1/2 fire, fig, poi, fly, ghos, steel, fair
                //2 grass, psy, dark
                break;
            case POISON:
                //1/2 poi, grou, rock, ghost
                //2, grass, fair
                break;
            case WATER:
                //1/2 wat, grass, dra
                //2 fire, ground, rock
                break;
            case ICE:
                //1/2 fire, water, ice, steel
                //2 grass, ground, fly, dragon
                break;
            case FIRE:
                //1/2 fire, water, rock, drag
                //2 grass, ice, bug, steel
                break;
            case FAIRY:
                //1/2 fire, pois, steel
                //2 figt, dragon, dark
                break;
            case PSYCHIC:
                //0 dark
                //1/2 psy, steel
                //2 fightnin, posi
                break;
            case ROCK:
                //1/2 figthnin, ground, steel
                //2 fire, ice, fly, bug
                break;
            case STEEL:
                // 1/2 fire, water, electric, steel
                //2 ice, rock, fair

                break;
            case FLYING:
                //1/2 electric, rock, steel
                //2 fighting, grass, bug
                break;
        }
        return 1;
    }
}
