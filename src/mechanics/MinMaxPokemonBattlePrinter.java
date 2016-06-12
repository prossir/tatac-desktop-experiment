package mechanics;

import java.util.List;
import models.MinMaxBattleNode;
import models.Pokemon;

/**
 * @author paolo
 */
public class MinMaxPokemonBattlePrinter {
    public static void results(MinMaxBattleNode lastNode) {
        while (lastNode!=null) {
            List<Pokemon> pokemonsA = lastNode.getTeamA();
            List<Pokemon> pokemonsB = lastNode.getTeamB();
            System.out.print("A<vs>B:");
            for (int i = 0; i < pokemonsA.size(); i++) {
                System.out.print(pokemonsA.get(i).getName() + ">" + pokemonsA.get(i).getHitPoints() + " | ");
            }
            System.out.print("|| |");
            for (int i = 0; i < pokemonsB.size(); i++) {
                System.out.print(pokemonsB.get(i).getName() + ">" + pokemonsB.get(i).getHitPoints() + " | ");
            }
            
            System.out.println();
            lastNode = lastNode.getParentNode();
        }
    }
}