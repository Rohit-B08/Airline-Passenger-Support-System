package classes;

public class Luggage {
    private int tokenNo;
    private int weight;
    private String name;
    private double baseFare;

    public Luggage(int tokenNo, int weight, String name, double baseFare) {
        this.tokenNo = tokenNo;
        this.weight = weight;
        this.name = name;
        this.baseFare = baseFare;
    }

    public int getTokenNo() {
        return tokenNo;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setWeight(int newWeight) {
        weight = newWeight;
    }

    public void setName(String newName) {
        name = newName;
    }
}
