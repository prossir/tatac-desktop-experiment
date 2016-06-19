package mechanics;

import java.util.List;
import models.MinMaxBattleNode;
import models.Pokemon;

/**
 * @author paolo
 */
public class MinMaxAlgorithm {

    public static MinMaxBattleNode lastNode = null;

    //Team A is max, Team B is min
    public static MinMaxBattleNode generateMinMaxTree(List<Pokemon> teamA, int currentA,
            List<Pokemon> teamB, int currentB, int teamPlaying, int level) {
        if (level < 4) {
            MinMaxBattleNode head = new MinMaxBattleNode();
            head.setTeamA(teamA);
            head.setTeamB(teamB);
            //3 states: best movement  and change and already dead change 
            boolean killed;
            if (teamPlaying % 2 == 0) {
                if (teamA.get(currentA).getHitPoints() <= 0) {//current member is dead
                    for (int i = 0; i < teamA.size(); i++) {
                        if (i != currentA && teamA.get(i).getHitPoints() != 0) {
                            MinMaxBattleNode child = generateMinMaxTree(teamA, i,
                                    teamB, currentB, ++teamPlaying, ++level);
                            child.setParentNode(head);
                            head.getChildNodes().add(child);
                        }
                    }
                } else {//current member not dead
                    killed = teamA.get(currentA).bestDamage(teamB.get(currentB));
                    if (killed) {//current member kills oponent
                        for (int i = 0; i < teamB.size(); i++) {
                            if (i != currentB && teamB.get(i).getHitPoints() != 0) {
                                MinMaxBattleNode child = generateMinMaxTree(teamA, currentA,
                                        teamB, i, ++teamPlaying, ++level);
                                child.setParentNode(head);
                                head.getChildNodes().add(child);
                            }
                        }
                    }
                }
            } else if (teamB.get(currentB).getHitPoints() <= 0) {//current member is dead
                for (int i = 0; i < teamB.size(); i++) {
                    if (i != currentB && teamB.get(i).getHitPoints() != 0) {
                        MinMaxBattleNode child = generateMinMaxTree(teamA, currentA,
                                teamB, i, ++teamPlaying, ++level);
                        child.setParentNode(head);
                        head.getChildNodes().add(child);
                    }
                }
            } else {//current member not dead
                killed = teamB.get(currentB).bestDamage(teamA.get(currentA));
                if (killed) {//current member kills oponent
                    for (int i = 0; i < teamA.size(); i++) {
                        if (i != currentA && teamA.get(i).getHitPoints() != 0) {
                            MinMaxBattleNode child = generateMinMaxTree(teamA, i,
                                    teamB, currentB, ++teamPlaying, ++level);
                            child.setParentNode(head);
                            head.getChildNodes().add(child);
                        }
                    }
                }
            }
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
