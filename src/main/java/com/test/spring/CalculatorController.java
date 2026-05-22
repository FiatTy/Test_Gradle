package com.test.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    // 🚨 Vulnerability: Hardcoded password (Security Hotspot)
    private String dbPassword = "SuperSecretPassword123!";

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        // 🐛 Code Smell: Unused variable
        int unusedResult = 0;
        
        // 🐛 Code Smell: Using System.out instead of a proper Logger (@Slf4j)
        System.out.println("Adding " + a + " and " + b);
        
        // 🐛 Code Smell: Commented out dead code
        // return a + b + unusedResult;
        
        try {
            return a + b;
        } catch (Exception e) {
            // 🐛 Code Smell: Catching generic Exception
            e.printStackTrace();
            return 0;
        }
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        // 🐛 Code Smell: Bad variable naming and unnecessary nested if-statements (Cognitive Complexity)
        int r = a - b;
        if (r > 0) {
            if (r > 10) {
                if (r > 100) {
                    System.out.println("Result is very large!");
                }
            }
        }
        return r;
    }
}
