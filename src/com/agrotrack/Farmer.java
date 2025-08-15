package com.agrotrack;

/**
 * Q3: Encapsulation — fields are private; only getters are exposed.
 * Represents a farmer in our tiny domain model.
 */
public class Farmer extends AgriUnit {
    private final int farmerId;
    private final String farmerName;

    public Farmer(int farmerId, String farmerName) {
        this.farmerId = farmerId;
        this.farmerName = farmerName;
    }

    public int getFarmerId() { return farmerId; }
    public String getFarmerName() { return farmerName; }

    @Override
    public void displayDetails() {
        System.out.println("👨‍🌾 Farmer #" + farmerId + " — " + farmerName);
    }
}
