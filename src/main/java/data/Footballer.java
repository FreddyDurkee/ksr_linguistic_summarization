package data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Footballer {

    private double id;
    private String name;
    private double age; // wiek (very old, old, average, young, very young)
    private double potential; // (legendary, world class, professional, novice, amateur, beginner)
    private double value; // wartość rynkowa (very cheap, cheap, average, expensive, very expensive)
    private double height; // wzrost w cm (very high, high, medium, low, very low)
    private double weight; // waga w kg (heavy, semi-heavy, medium, welterweight, light)
    private double speed; // szybkość (legendary, world class, professional, novice, amateur, beginner)
    private double stamina; // wytrzymałość (legendary, world class, professional, novice, amateur, beginner)
    private double strength; // siła (legendary, world class, professional, novice, amateur, beginner)
    private double balance; // równowaga (legendary, world class, professional, novice, amateur, beginner)
    private double agility; // zwinność (legendary, world class, professional, novice, amateur, beginner)

    public Footballer(int id, String name, int age, int potential, int value, double height,
                      double weight, int speed, int stamina, int strength, int balance, int agility) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.potential = potential;
        this.value = value;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
        this.stamina = stamina;
        this.strength = strength;
        this.balance = balance;
        this.agility = agility;
    }

}