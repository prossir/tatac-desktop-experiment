package mechanics;

import java.util.List;
import models.MinMaxBattleNode;
import models.Pokemon;

/**
 * @author paolo
 */
public class MinMaxPokemonGenerator {

    private static boolean flagDone = false;
    public static MinMaxBattleNode lastNode = null;

    //Team A is max, Team B is min
    public static MinMaxBattleNode generateMinMaxTree(List<Pokemon> teamA, int currentA,
            List<Pokemon> teamB, int currentB, int teamPlaying) {
        if (!flagDone) {
            MinMaxBattleNode head = new MinMaxBattleNode();
            head.setTeamA(teamA);
            head.setTeamB(teamB);
            //2 states: best movement  and change
            boolean killed;
            if (teamPlaying % 2 == 0) {
                killed = teamA.get(currentA).bestDamage(teamB.get(currentB));
            } else {
                killed = teamB.get(currentB).bestDamage(teamA.get(currentA));
            }
            if (killed) {
                if (teamPlaying % 2 == 0) {
                    currentB = changePokemon(teamB, currentB);
                    if (currentB == -1) {//Won the day
                        MinMaxBattleNode stump = new MinMaxBattleNode();
                        stump.setTeamA(teamA);
                        stump.setTeamB(teamB);
                        stump.setChildNodes(null);
                        stump.setParentNode(head);
                        head.getChildNodes().add(stump);
                        lastNode = stump;
                        flagDone = true;
                        return head;
                    }
                } else {
                    currentA = changePokemon(teamA, currentA);
                    if (currentA == -1) {//Lose the day
                        MinMaxBattleNode stump = new MinMaxBattleNode();
                        stump.setTeamA(teamA);
                        stump.setTeamB(teamB);
                        stump.setChildNodes(null);
                        stump.setParentNode(head);
                        head.getChildNodes().add(stump);
                        return head;
                    }
                }
            }

            MinMaxBattleNode child = generateMinMaxTree(teamA, currentA, teamB, currentB, ++teamPlaying);
            child.setParentNode(head);
            head.getChildNodes().add(child);
            return head;
        } else {
            return null;
        }
    }

    private static int changePokemon(List<Pokemon> team, int curr) {
        for (int i = 0; i < team.size(); i++) {
            if (i != curr && team.get(i).getHitPoints() != 0) {
                return i;
            }
        }
        return -1;
    }
}
