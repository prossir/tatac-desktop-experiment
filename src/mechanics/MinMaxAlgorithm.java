package mechanics;

import java.util.ArrayList;
import java.util.List;
import models.MinMaxBattleNode;
import models.Pokemon;

/**
 * @author paolo
 */
public class MinMaxAlgorithm {

    private static int maxValuation;
    public static MinMaxBattleNode lastNode = null;

    //Team A is max, Team B is min
    public static MinMaxBattleNode generateMinMaxTree(List<Pokemon> teamA, int currentA,
            List<Pokemon> teamB, int currentB, int teamPlaying, int level) {
        if (level < 5) {
            MinMaxBattleNode head = new MinMaxBattleNode();
            head.setTeamA(teamA);
            head.setTeamB(teamB);
            //3 states: best movement  and change and already dead change 
            boolean killed;
            if (teamPlaying == 0 || teamPlaying % 2 == 0) {
                if (teamA.get(currentA).getHitPoints() <= 0) {//current member is 
                    boolean noReplacement = findReplacement(teamA, currentA);
                    if (!noReplacement) {
                        return head;
                    } else {
                        branchOut(teamA, currentA, teamB, currentB, teamPlaying, level, 0, head);
                    }
                } else {//current member not dead
                    killed = teamA.get(currentA).bestDamage(teamB.get(currentB));
                    if (killed) {//current member kills oponent
                        boolean noReplacement = findReplacement(teamB, currentB);
                        if (!noReplacement) {
                            return head;
                        } else {
                            branchOut(teamA, currentA, teamB, currentB, teamPlaying, level, 1, head);
                        }
                    }
                }
            } else if (teamB.get(currentB).getHitPoints() <= 0) {//current member is dead
                boolean noReplacement = findReplacement(teamB, currentB);
                if (!noReplacement) {
                    return head;
                } else {
                    branchOut(teamA, currentA, teamB, currentB, teamPlaying, level, 1, head);
                }
            } else {//current member not dead
                killed = teamB.get(currentB).bestDamage(teamA.get(currentA));
                if (killed) {//current member kills oponent
                    boolean noReplacement = findReplacement(teamA, currentA);
                    if (!noReplacement) {
                        return head;
                    } else {
                        branchOut(teamA, currentA, teamB, currentB, teamPlaying, level, 0, head);
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
        int chosenMove, endgame = 0;
        maxValuation = 0;
        MinMaxBattleNode cursor = root;

        //for (int i = 0; i < cursor.getChildNodes().size(); i++) {
        //    if (cursor.getChildNodes().get(i).getChildNodes().isEmpty()) {
        //        endgame++;
        //    }
        //}

        //if (endgame == cursor.getChildNodes().size()) {
        //    return -4;
        //}

        for (int i = 0; i < cursor.getChildNodes().size(); i++) {
            nexPossibleMove(cursor.getChildNodes().get(i));
        }
        maxValuation = 0;

        //encontramos la raiz y el hijo con el movimiento elegido si el hijo y la
        //raiz son iguales, la partida termina
        while (lastNode.getParentNode() != null && lastNode.getParentNode().getParentNode() != null) {
            lastNode = lastNode.getParentNode();
        }
        return lastNode.getChosenMove();
    }

    private static void nexPossibleMove(MinMaxBattleNode currentBattle) {
        if (currentBattle.getChildNodes().isEmpty()) {
            int value = FirstHeuristic.value(currentBattle.getTeamA(), currentBattle.getTeamB());
            if (value > maxValuation) {
                maxValuation = value;
                lastNode = currentBattle;
            }
        } else {
            for (int i = 0; i < currentBattle.getChildNodes().size(); i++) {
                nexPossibleMove(currentBattle.getChildNodes().get(i));
            }
        }
    }

    private static boolean findReplacement(List<Pokemon> teamA, int currentA) {
        for (int i = 0; i < teamA.size(); i++) {
            if (i != currentA && teamA.get(i).getHitPoints() != 0) {
                return true;
            }
        }
        return false;
    }

    private static void branchOut(List<Pokemon> teamA, int currentA, List<Pokemon> teamB,
            int currentB, int teamPlaying, int level, int AorB, MinMaxBattleNode head) {
        if (AorB == 0) {
            for (int i = 0; i < teamA.size(); i++) {
                if (i != currentA && teamA.get(i).getHitPoints() != 0) {
                    List<Pokemon> copyTeamA = copyTeam(teamA);
                    List<Pokemon> copyTeamB = copyTeam(teamA);
                    MinMaxBattleNode child = generateMinMaxTree(copyTeamA, i,
                            copyTeamB, currentB, 1 + teamPlaying, 1 + level);
                    child.setParentNode(head);
                    switch (i) {
                        case 0:
                            child.setChosenMove(-1);
                            break;
                        case 1:
                            child.setChosenMove(-2);
                            break;
                        case 2:
                            child.setChosenMove(-3);
                            break;
                    }
                    head.getChildNodes().add(child);
                }
            }
        } else {
            for (int i = 0; i < teamB.size(); i++) {
                if (i != currentB && teamB.get(i).getHitPoints() != 0) {
                    List<Pokemon> copyTeamA = copyTeam(teamA);
                    List<Pokemon> copyTeamB = copyTeam(teamA);
                    MinMaxBattleNode child = generateMinMaxTree(copyTeamA, currentA,
                            copyTeamB, i, 1 + teamPlaying, 1 + level);
                    child.setParentNode(head);
                    switch (i) {
                        case 0:
                            child.setChosenMove(-1);
                            break;
                        case 1:
                            child.setChosenMove(-2);
                            break;
                        case 2:
                            child.setChosenMove(-3);
                            break;
                    }
                    head.getChildNodes().add(child);
                }
            }
        }
    }

    private static List<Pokemon> copyTeam(List<Pokemon> originalTeam) {
        List<Pokemon> copyTeam = new ArrayList<>();
        for (int i = 0; i < originalTeam.size(); i++) {
            copyTeam.add(new Pokemon(originalTeam.get(i)));
        }
        return copyTeam;
    }
}