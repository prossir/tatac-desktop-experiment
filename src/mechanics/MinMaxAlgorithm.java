package mechanics;

import java.util.ArrayList;
import java.util.List;
import models.MinMaxBattleNode;
import models.Pokemon;

/**
 * @author paolo
 */
public class MinMaxAlgorithm {

    //Team A is max, Team B is min
    public static MinMaxBattleNode generateMinMaxTree(List<Pokemon> teamA, int currentA,
            List<Pokemon> teamB, int currentB, int teamPlaying, int level) {
        if (level < 5) {
            MinMaxBattleNode head = new MinMaxBattleNode();//the head is the parent event
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
                        head.setChildNodes(branchOut(teamA, currentA, teamB, currentB, teamPlaying, level, 0));
                        return head;
                    }
                } else {//current member not dead
                    killed = teamA.get(currentA).bestDamage(teamB.get(currentB));
                    if (killed) {//current member kills oponent
                        boolean noReplacement = findReplacement(teamB, currentB);
                        head.setChosenMove(1);//Only for testing purposes
                        if (!noReplacement) {
                            return head;
                        } else {
                            head.setChildNodes(branchOut(teamA, currentA, teamB, currentB, teamPlaying, level, 1));
                            return head;
                        }
                    } else {
                        head.setChosenMove(1);//Only for testing purposes
                        head.setChildNodes(branchOut(teamA, currentA, teamB, currentB, teamPlaying, level, 0));//create possible branches
                        head.getChildNodes().add(generateMinMaxTree(teamA, currentA, teamB, currentB, 1 + teamPlaying, 1 + level));
                        return head;

                    }
                }
            } else if (teamB.get(currentB).getHitPoints() <= 0) {//current member is dead
                boolean noReplacement = findReplacement(teamB, currentB);
                if (!noReplacement) {
                    return head;
                } else {
                    head.setChildNodes(branchOut(teamA, currentA, teamB, currentB, teamPlaying, level, 1));
                    return head;
                }
            } else {//current member not dead
                killed = teamB.get(currentB).bestDamage(teamA.get(currentA));
                head.setChosenMove(1);//Only for testing purposes
                if (killed) {//current member kills oponent
                    boolean noReplacement = findReplacement(teamA, currentA);
                    if (!noReplacement) {
                        return head;
                    } else {
                        head.setChosenMove(1);//Only for testing purposes
                        head.setChildNodes(branchOut(teamA, currentA, teamB, currentB, teamPlaying, level, 0));
                        return head;
                    }
                } else {
                    head.setChosenMove(1);//Only for testing purposes
                    head.setChildNodes(branchOut(teamA, currentA, teamB, currentB, teamPlaying, level, 0));
                    head.getChildNodes().add(generateMinMaxTree(teamA, currentA, teamB, currentB, 1 + teamPlaying, 1 + level));
                    return head;
                }
            }
        } else {
            MinMaxBattleNode head = new MinMaxBattleNode();
            head.setTeamA(teamA);
            head.setTeamB(teamB);

            return head;
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

    private static List<MinMaxBattleNode> branchOut(List<Pokemon> teamA, int currentA,
            List<Pokemon> teamB, int currentB, int teamPlaying, int level, int AorB) {
        List<MinMaxBattleNode> childNodes = new ArrayList<>();
        if (AorB == 0) {
            for (int i = 0; i < teamA.size(); i++) {
                if (i != currentA && teamA.get(i).getHitPoints() != 0) {
                    MinMaxBattleNode child = generateMinMaxTree(teamA, i,
                            teamB, currentB, 1 + teamPlaying, 1 + level);
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
                    childNodes.add(child);
                }
            }
            return childNodes;
        } else {
            for (int i = 0; i < teamB.size(); i++) {
                if (i != currentB && teamB.get(i).getHitPoints() != 0) {
                    MinMaxBattleNode child = generateMinMaxTree(teamA, currentA,
                            teamB, i, 1 + teamPlaying, 1 + level);
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
                    childNodes.add(child);
                }
            }
            return childNodes;
        }
    }

    public static int findInTree(MinMaxBattleNode root) {
        int chosenMove, endgame = 0;
        boolean chosen = false;
        MinMaxBattleNode cursor = root, trueNode = null;
        for (int i = 0; i < cursor.getChildNodes().size(); i++) {
            findLeaves(cursor.getChildNodes().get(i));
        }

        //encontramos los hijos de la raiz el que tenga mayor valor es el siguiente mov.
        trueNode = root.getChildNodes().get(0);
        for (int i = 0; i < root.getChildNodes().size(); i++) {
            if (root.getChildNodes().get(i).getEvaluation()
                    > trueNode.getEvaluation()) {
                trueNode = root.getChildNodes().get(i);
            }
        }

        System.out.println(trueNode.getChosenMove());
        return trueNode.getChosenMove();
    }

    private static void findLeaves(MinMaxBattleNode currentBattle) {
        if (currentBattle.getChildNodes().isEmpty()) {
            int value = FirstHeuristic.value(currentBattle.getTeamA(), currentBattle.getTeamB());
            currentBattle.setEvaluation(value);
            currentBattle.setEvaluated(true);
            //como es con 5 nodos max (1 a 2), min (2 a 3), max (3 a 4) y min (4 a 5)
            maximizeParent(currentBattle);

        } else {
            for (int i = 0; i < currentBattle.getChildNodes().size(); i++) {
                findLeaves(currentBattle.getChildNodes().get(i));
            }
        }
    }

    private static void maximizeParent(MinMaxBattleNode currentBattle) {
        List<MinMaxBattleNode> children = currentBattle.getChildNodes();
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).isEvaluated()) {
                if (!currentBattle.isEvaluated()) {
                    currentBattle.setEvaluation(children.get(i).getEvaluation());
                    currentBattle.setEvaluated(true);
                } else if (currentBattle.getEvaluation() <= children.get(i).getEvaluation()) {
                    currentBattle.setEvaluation(children.get(i).getEvaluation());
                }
            }
        }
        if (currentBattle.getParentNode() != null) {
            minimizeParent(currentBattle.getParentNode());
        }
    }

    private static void minimizeParent(MinMaxBattleNode currentBattle) {
        List<MinMaxBattleNode> children = currentBattle.getChildNodes();
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).isEvaluated()) {
                if (!currentBattle.isEvaluated()) {
                    currentBattle.setEvaluation(children.get(i).getEvaluation());
                    currentBattle.setEvaluated(true);
                } else if (currentBattle.getEvaluation() >= children.get(i).getEvaluation()) {
                    currentBattle.setEvaluation(children.get(i).getEvaluation());
                }
            }
        }
        if (currentBattle.getParentNode() != null) {
            maximizeParent(currentBattle);
        }
    }
}
