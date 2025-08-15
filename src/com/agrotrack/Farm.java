package com.agrotrack;

/**
 * Q2/Q3/Q5: Encapsulated Farm entity with a static counter.
 *  - Private fields (encapsulation)
 *  - calculateCropIndex() performs casting and integer arithmetic
 *  - Static counter shows total farms created (handy for debugging demos)
 */
public class Farm extends AgriUnit {
    private final int farmId;
    private final String farmName;
    private final float rainfall;        // mm (float input from user)
    private final int fertilizerUsed;    // kg (kept as int for integer math)

    public static int totalFarms;

    // Q5: Static initialization — one-time setup for class state.
    static {
        totalFarms = 0;
    }

    public Farm(int farmId, String farmName, float rainfall, int fertilizerUsed) {
        this.farmId = farmId;
        this.farmName = farmName;
        this.rainfall = rainfall;
        this.fertilizerUsed = fertilizerUsed;
        // Q5: Constructor side‑effect for easy IDE debugging.
        totalFarms++;
        System.out.println("📊 Farms created so far: " + totalFarms);
    }

    /**
     * Q2: Casting & arithmetic rule
     * cropIndex = (fertilizer * 2) + (int) rainfall
     */
    public int calculateCropIndex() {
        final int FERTILIZER_RATIO = 2;           // Q1: constant as required
        int rainfallInt = (int) rainfall;         // explicit float → int cast
        return (fertilizerUsed * FERTILIZER_RATIO) + rainfallInt;
    }

    @Override
    public void displayDetails() {
        System.out.println(
            "🏡 Farm #" + farmId + " — " + farmName +
            " | rainfall: " + rainfall + "mm  | fertilizer: " + fertilizerUsed + "kg"
        );
    }

    // Minimal getters (encapsulation)
    public String getFarmName() { return farmName; }
    public float getRainfall() { return rainfall; }
    public int getFertilizerUsed() { return fertilizerUsed; }
}
