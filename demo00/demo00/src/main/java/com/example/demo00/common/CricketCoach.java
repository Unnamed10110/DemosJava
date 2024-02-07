package com.example.demo00.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy //lazy initialization, only if it is needed is created
@Component // dependency injection
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // scope del bean como dependencia
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // scope del bean equivalente a trascient en .net
//@Primary  // primary pick for dependency injection
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice jumping 15 min!!";
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff() : " + getClass().getSimpleName());
    }

    // destroy method
    @PreDestroy
    public void doMyCleanUpStuff() {
        System.out.println("In doMyCleanUpStuff() : " + getClass().getSimpleName());
    }
}
