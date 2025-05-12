package com.example.physics.sam.iisib24.model;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class AtwoodMachine {
    private double height; // высота в метрах
    private double bigMass;  // масса M в кг
    private double smallMass;  // масса m в кг
    private String selectedPlanet; // выбранная планета

    // Константы ускорения свободного падения для разных планет (м/с²)
    private static final double G_MERCURY = 3.7;
    private static final double G_VENUS = 8.87;
    private static final double G_EARTH = 9.81;
    private static final double G_MOON = 1.62;
    private static final double G_MARS = 3.71;
    private static final double G_GANYMEDE = 1.428;
    private static final double G_CALLISTO = 1.235;
    private static final double G_TITAN = 1.352;
    private static final double G_PLUTO = 0.617;

    public double calculateFallTime() {
        double g = getPlanetGravity();
        double a = calculateAcceleration(g);
        return Math.sqrt((2 * height) / a);
    }

    private double calculateAcceleration(double g) {
        return (bigMass - smallMass) * g / (bigMass + smallMass);
    }

    public double getPlanetGravity() {
        return switch (selectedPlanet) {
            case "Mercury" -> G_MERCURY;
            case "Venus" -> G_VENUS;
            case "Moon" -> G_MOON;
            case "Mars" -> G_MARS;
            case "Ganymede" -> G_GANYMEDE;
            case "Callisto" -> G_CALLISTO;
            case "Titan" -> G_TITAN;
            case "Pluto" -> G_PLUTO;
            default -> G_EARTH;
        };
    }

    // Методы для совместимости с контроллером
    public void setMassM(double BigMass) {
        this.bigMass = BigMass;
    }

    public void setMassm(double SmallMass) {
        this.smallMass = SmallMass;
    }
} 