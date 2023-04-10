package classes;

public class Luggage {
    private int tokenNo;
    private int weight;
    private String name;
    private double luggFare;

    public Luggage(int tokenNo, int weight, String name, double luggFare) {
        this.tokenNo = tokenNo;
        this.weight = weight;
        this.name = name;
        this.luggFare = luggFare;
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

    public double getLuggFare() { return luggFare; }

    public void setWeight(int newWeight) {
        weight = newWeight;
    }

    public void setName(String newName) {
        name = newName;
    }
}
