package models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paolo
 */
public class MinMaxBattleNode {

    private List<Pokemon> teamA;
    private List<Pokemon> teamB;
    private List<MinMaxBattleNode> childNodes;
    private MinMaxBattleNode parentNode;
    private int chosenMove;
    private int evaluation;
    private boolean evaluated;

    public MinMaxBattleNode() {
        evaluation = 0;
        childNodes = new ArrayList<>();
    }

    /**
     * @return the teamA
     */
    public List<Pokemon> getTeamA() {
        return teamA;
    }

    /**
     * @param teamA the teamA to set
     */
    public void setTeamA(List<Pokemon> teamA) {
        this.teamA = copyList(teamA);
    }

    /**
     * @return the teamB
     */
    public List<Pokemon> getTeamB() {
        return teamB;
    }

    /**
     * @param teamB the teamB to set
     */
    public void setTeamB(List<Pokemon> teamB) {
        this.teamB = copyList(teamB);
    }

    /**
     * @return the childNodes
     */
    public List<MinMaxBattleNode> getChildNodes() {
        return childNodes;
    }

    /**
     * @param childNodes the childNodes to set
     */
    public void setChildNodes(List<MinMaxBattleNode> childNodes) {
        this.childNodes = childNodes;
        if(!childNodes.isEmpty()){
            childNodes.stream().forEach((child) -> {
                child.setParentNode(this);
            });
        }
    }

    /**
     * @return the parentNode
     */
    public MinMaxBattleNode getParentNode() {
        return parentNode;
    }

    /**
     * @param parentNode the parentNode to set
     */
    public void setParentNode(MinMaxBattleNode parentNode) {
        this.parentNode = parentNode;
    }

    private List<Pokemon> copyList(List<Pokemon> teamB) {
        List<Pokemon> copyList = new ArrayList<>();
        for (int i = 0; i < teamB.size(); i++) {
            Pokemon p = new Pokemon(teamB.get(i));
            copyList.add(p);
        }
        return copyList;
    }

    public void setChosenMove(int chosenMove) {
        this.chosenMove = chosenMove;
    }

    public int getChosenMove() {
        return chosenMove;
    }

    public void setEvaluation(int value) {
        evaluation = value;
    }

    public int getEvaluation() {
        return evaluation;
    }

    /**
     * @return the evaluated
     */
    public boolean isEvaluated() {
        return evaluated;
    }

    /**
     * @param evaluated the evaluated to set
     */
    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }
}