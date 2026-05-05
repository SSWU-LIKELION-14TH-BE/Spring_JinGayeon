package com.likelion.session.week5;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this. calculatorService = calculatorService;
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
        return request.getNumber1() * request.getNumber2();
    }

    @PostMapping("/divide")
    public int divideTwoNumbers(@RequestBody CalculatorDivideRequest request){
        return request.getNumber1() / request.getNumber2();
    }

    @PostMapping("/subtract")
    public int divideTwoNumbers(@RequestBody CalculatorSubtractRequest request){
        return request.getNumber1() - request.getNumber2();
    }

    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request. getNumber1() + request. getNumber2();
    }
}
