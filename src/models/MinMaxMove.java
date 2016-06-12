package models;

/**
 *
 * @author paolo
 */
public class MinMaxMove {
    private int basePower;
    private double accuracy;
    private String type;
    private String name;

    /**
     * @return the basePower
     */
    public int getBasePower() {
        return basePower;
    }

    /**
     * @param basePower the basePower to set
     */
    public void setBasePower(int basePower) {
        this.basePower = basePower;
    }

    /**
     * @return the accuracy
     */
    public double getAccuracy() {
        return accuracy;
    }

    /**
     * @param accuracy the accuracy to set
     */
    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}