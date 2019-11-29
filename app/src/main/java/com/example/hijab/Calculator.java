package com.example.hijab;

import javax.inject.Inject;

public class Calculator {

    private  String name;

    @Inject
    public Calculator() {
        name = "Shaibbu Zach";

    }

    public String getName() {
        return name;
    }
}

