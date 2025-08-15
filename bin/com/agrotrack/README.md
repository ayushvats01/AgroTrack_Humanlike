# AgroTrack — Humanlike Console Edition

A small Java lab project that:
- collects farm inputs (name, rainfall, fertilizer),
- computes a crop index with integer arithmetic and an explicit cast,
- classifies productivity,
- and demonstrates OOP pillars with a friendly, emoji‑based console.

This UI is deliberately **different** from the box‑drawing/colored version: it uses a calm “receipt” summary and plain text with emojis.

## Run
```bash
cd src
javac com/agrotrack/*.java
java com.agrotrack.Main
# If your terminal shows weird glyphs, set encoding to UTF‑8 or run in Eclipse.
```

## Structure
```
src/com/agrotrack/
  AgriUnit.java
  Farmer.java
  OrganicFarmer.java
  Farm.java
  Main.java
```

## Lab mapping (Q1–Q5)
- **Q1**: input vars, integer arithmetic `(fert*2)+(int)rainfall`, bitwise parity, ternary, switch (via band), constants, Unicode, comments.
- **Q2**: `Farm` fields + ctor; `calculateCropIndex()` does cast + rule; create two Farm objects.
- **Q3**: `AgriUnit` abstract; private fields + getters; `displayDetails()` in `Farm` and `Farmer`.
- **Q4**: `OrganicFarmer` overrides; `AgriUnit[]` + loop → runtime polymorphism.
- **Q5**: `totalFarms` static field + static block; ctor increments; breakpoint tip in comments.
