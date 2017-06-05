package com.javarush.task.task33.task3312;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

import static org.omg.IOP.TAG_ORB_TYPE.value;


public class Zoo {
    public List<Animal> animals = new ArrayList<>();

    @JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property = "type")  //vic's solution
    @JsonSubTypes({                                             //vic's solution
            @JsonSubTypes.Type(value=Zoo.Animal.class)          //vic's solution
    })                                                          //vic's solution
    public static class Animal {
        public Animal(String name) {
            this.name = name;
        }

        public String name;
    }

    @JsonTypeName(value="dog")                                  //vic's solution
    public static class Dog extends Animal {

        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

    @JsonTypeName(value="cat")                                  //vic's solution
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }
    }
}