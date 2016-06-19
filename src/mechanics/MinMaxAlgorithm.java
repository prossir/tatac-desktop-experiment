package mechanics;

import java.util.List;
import models.MinMaxBattleNode;
import models.Pokemon;

/**
 * @author paolo
 */
public class MinMaxAlgorithm {

    private static boolean flagDone = false;
    public static MinMaxBattleNode lastNode = null;

    //Team A is max, Team B is min
    public static MinMaxBattleNode generateMinMaxTree(List<Pokemon> teamA, int currentA,
            List<Pokemon> teamB, int currentB, int teamPlaying, int level) {
        if (level < 4) {
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
                    for (int i = 0; i < teamB.size(); i++) {
                        if (i != currentB && teamB.get(i).getHitPoints() != 0) {
                            return generateMinMaxTree(teamA, currentA, teamB,
                                    i, ++teamPlaying, ++level);
                        }
                    }

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
                    for (int i = 0; i < teamA.size(); i++) {
                        if (i != currentA && teamA.get(i).getHitPoints() != 0) {
                            return generateMinMaxTree(teamA, i, teamB,
                                    currentB, ++teamPlaying, ++level);
                        }
                    }

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

            MinMaxBattleNode child = generateMinMaxTree(teamA, currentA, teamB,
                    currentB, ++teamPlaying, ++level);
            child.setParentNode(head);
            head.getChildNodes().add(child);
            return head;
        } else {
            MinMaxBattleNode head = new MinMaxBattleNode();
            head.setTeamA(teamA);
            head.setTeamB(teamB);
            
            return head;
        }
    }

    public static int findInTree(MinMaxBattleNode root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
