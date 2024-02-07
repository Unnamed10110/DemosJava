package com.example.demo00.common;

import com.fasterxml.jackson.databind.util.ClassUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Lazy
@Component // dependency injection
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // scope del bean como dependencia
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // scope del bean equivalente a trascient en .net
//@Primary  // primary pick for dependency injection
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("in constructor: " + getClass().getSimpleName());// to test lazy initialization
    }

    public String getDailyWorkout() {
        return "30 min batting practice!!";
    }

    //init method
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