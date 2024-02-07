package com.example.demo00.common;

// no se usa @component cuando se utiliza @bean en el archivo de config
public class SwimCoach implements Coach{
    public SwimCoach() {
        System.out.println("in constructor "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 100 meters!!";
    }
}
