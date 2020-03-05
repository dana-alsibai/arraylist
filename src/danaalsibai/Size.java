/*
        Name: Dana Alsibi
        Assignment:  Assignment 3
        Program: Item List Application
        Date:  February 10th, 2020
    
        Description: an application that can be used to keep 
                    track of item cost information.
        
 */
package danaalsibai;

/**
 * @author danasebai
 */
public enum Size {
    //constant Size that can be used 
    XS("Extra Small", 0.8),
    S("Small", 0.9),
    M("Medium", 1.0),
    L("Large", 1.1),
    XL("Extra Large", 1.2);

    private String sizeName;
    private double costCoefficient;

    //private Constructor for enum class
    private Size(String sizeName, double costCoefficient) {
        this.sizeName = sizeName;
        this.costCoefficient = costCoefficient;
    }

    /**
     * @param sizeName to set a String sizeName
     */
    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    /**
     *
     * @return a String sizeName
     */
    public String getSizeName() {
        return sizeName;
    }

    /**
     * @return costCoefficient
     */
    public double getCostCoefficient() {
        return costCoefficient;
    }

    /**
     *
     * @param costCoefficient
     */
    public void setCostCoefficient(double costCoefficient) {
        this.costCoefficient = costCoefficient;
    }
}
