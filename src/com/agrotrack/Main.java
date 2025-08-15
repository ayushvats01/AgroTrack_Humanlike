package com.agrotrack;

import java.util.Scanner;

/**
 * AgroTrack — Human‑friendly console.
 * UI is intentionally different from the "stylish" version: no frames; conversational tone,
 * checkmarks/crosses, and a clean "receipt" style summary.
 *
 * Comments are labeled per the lab tasks Q1–Q5.
 */
public class Main {

    // Q1: Constant used in integer arithmetic
    private static final int FERTILIZER_RATIO = 2;

    public static void main(String[] args) {

        // ——— Intro (human‑like, Unicode) ———
        System.out.println("—————————————————————————————————————————————————————");
        System.out.println("🌱 AgroTrack : Smart Agriculture Monitoring System");
        System.out.println("—————————————————————————————————————————————————————\n");
        System.out.println("Hello! We’ll record a few details and estimate today’s crop outlook.");

        // Q1: Input variables with appropriate types
        Scanner sc = new Scanner(System.in);
        System.out.print("Farm name 🏷️  : ");
        String farmName = sc.nextLine();

        System.out.print("Rainfall (mm) 💦 [float] : ");
        float rainfall = sc.nextFloat();

        System.out.print("Fertilizer (kg) 🧪 [int] : ");
        int fertilizer = sc.nextInt();

        // Q1: Bitwise example — check parity of fertilizer (even/odd)
        boolean fertilizerIsEven = (fertilizer & 1) == 0; // bitwise AND

        // Q1/Q2: Explicit cast + integer arithmetic using the required formula
        int rainfallInt = (int) rainfall;
        int cropIndex = (fertilizer * FERTILIZER_RATIO) + rainfallInt;

        // Q1: Conditional operator for a short weather note
        String rainNote = (rainfallInt >= 50) ? "plenty of moisture" : "watch irrigation";

        // Q1: Control flow — we’ll classify via a small switch after banding
        int band = (cropIndex < 30) ? 0 : (cropIndex <= 60 ? 1 : 2); // ternary chain to derive band 0/1/2
        String category;
        switch (band) {
            case 0 -> category = "Low Productivity";
            case 1 -> category = "Moderate";
            default -> category = "High Yield";
        }

        // ——— Human‑style summary (a "receipt") ———
        System.out.println("\n————————————————— SUMMARY —————————————————");
        System.out.println("Farm          : " + farmName);
        System.out.println("Rainfall      : " + rainfall + " mm  (int part: " + rainfallInt + ")");
        System.out.println("Fertilizer    : " + fertilizer + " kg  " + (fertilizerIsEven ? "✓ even" : "✗ odd"));
        System.out.println("Formula       : (" + fertilizer + " * " + FERTILIZER_RATIO + ") + " + rainfallInt);
        System.out.println("Crop Index    : " + cropIndex + "  →  " + category);
        System.out.println("Advice        : " + rainNote + ".");
        System.out.println("—————————————————————————————————————————————\n");

        // Q2/Q5: Create Farm objects; constructor prints running total (useful for breakpoints)
        Farm f1 = new Farm(1, farmName, rainfall, fertilizer);
        Farm f2 = new Farm(2, "Demo Orchard", 37.4f, 9);
        Farm f3 = new Farm(3, "San Frans", 32.4f, 20);
        
        // Q2: Call method that performs casting and arithmetic
        System.out.println("Quick Crop indices → " + f1.getFarmName() + ": " + f1.calculateCropIndex()
                + " | " + f2.getFarmName() + ": " + f2.calculateCropIndex()
                + " | " + f3.getFarmName() + ": " + f3.calculateCropIndex());

        // Q3/Q4: Abstraction + Encapsulation + Polymorphism
        Farmer farmer = new Farmer(101, "Ankur");
        OrganicFarmer organic = new OrganicFarmer(102, "James");
        AgriUnit[] items = { f1, f2 , f3 , farmer, organic}; 

        System.out.println("\nWho’s on our system today?");
        for (AgriUnit it : items) {
            // Q4: Runtime polymorphism — the right displayDetails() is chosen dynamically.
            System.out.print(" • ");
            it.displayDetails();
        }

        // Q5: IDE Debugging note (in comments):
        //  - Put a breakpoint on Farm(...) constructor to watch totalFarms increment.
        //  - Step over calculateCropIndex() and expand local variables.

        System.out.println("\n✅ Done. Thanks for trying AgroTrack!");
        sc.close();
    }
}
