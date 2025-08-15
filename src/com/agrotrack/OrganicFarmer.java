package com.agrotrack;

/**
 * Q4: Inheritance + Polymorphism.
 * An OrganicFarmer is a Farmer with a different display behavior.
 */
public class OrganicFarmer extends Farmer {
    public OrganicFarmer(int farmerId, String farmerName) {
        super(farmerId, farmerName);
    }

    @Override
    public void displayDetails() {
        // Overridden message adds an organic practice note.
        System.out.println("🌿 Organic Farmer #" + getFarmerId() + " — " + getFarmerName() + " (adopts organic practices)");
    }
}
