package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paolo
 */
public class MinMaxBattleNode {
    private List<MinMaxPokemon> teamA;
    private List<MinMaxPokemon> teamB;
    private List<MinMaxBattleNode> childNodes;
    private MinMaxBattleNode parentNode;

    public MinMaxBattleNode(){
        childNodes = new ArrayList<>();
    }
    /**
     * @return the teamA
     */
    public List<MinMaxPokemon> getTeamA() {
        return teamA;
    }

    /**
     * @param teamA the teamA to set
     */
    public void setTeamA(List<MinMaxPokemon> teamA) {
        this.teamA = copyList(teamA);
    }

    /**
     * @return the teamB
     */
    public List<MinMaxPokemon> getTeamB() {
        return teamB;
    }

    /**
     * @param teamB the teamB to set
     */
    public void setTeamB(List<MinMaxPokemon> teamB) {
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

    private List<MinMaxPokemon> copyList(List<MinMaxPokemon> teamB) {
        List<MinMaxPokemon> copyList = new ArrayList<>();
        for (int i=0; i<teamB.size(); i++){
            MinMaxPokemon p = new MinMaxPokemon(teamB.get(i));
            copyList.add(p);
        }
        return copyList;
    }
}