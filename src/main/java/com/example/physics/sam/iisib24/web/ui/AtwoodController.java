package com.example.physics.sam.iisib24.web.ui;

import com.example.physics.sam.iisib24.model.AtwoodMachine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AtwoodController {

    private final AtwoodMachine atwoodMachine;

    public AtwoodController(AtwoodMachine atwoodMachine) {
        this.atwoodMachine = atwoodMachine;
    }

    @GetMapping({"/", "/atwood"})
    public String showAtwoodPage() {
        System.out.println("Get works");
        return "atwood";
    }

    @PostMapping("/calculate")
    @ResponseBody
    public Map<String, Object> calculate(
            @RequestParam double height,
            @RequestParam double BigMass,
            @RequestParam double SmallMass,
            @RequestParam String planet) {
        
        atwoodMachine.setHeight(height);
        atwoodMachine.setMassM(BigMass);
        atwoodMachine.setMassm(SmallMass);
        atwoodMachine.setSelectedPlanet(planet);
        System.out.println("Post works");
        double fallTime = atwoodMachine.calculateFallTime();
        double gravity = atwoodMachine.getPlanetGravity();

        Map<String, Object> response = new HashMap<>();
        response.put("fallTime", atwoodMachine.calculateFallTime());
        response.put("gravity", atwoodMachine.getPlanetGravity());
        return response;
    }
} 