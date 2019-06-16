package data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Footballer {

    private Integer id;
    private String name;
    private Double age; // wiek (very old, old, average, young, very young)
    private Double potential; // (legendary, world class, professional, novice, amateur, beginner)
    private Double value; // wartość rynkowa (very cheap, cheap, average, expensive, very expensive)
    private Double height; // wzrost w cm (very high, high, medium, low, very low)
    private Double weight; // waga w kg (heavy, semi-heavy, medium, welterweight, light)
    private Double speed; // szybkość (legendary, world class, professional, novice, amateur, beginner)
    private Double stamina; // wytrzymałość (legendary, world class, professional, novice, amateur, beginner)
    private Double strength; // siła (legendary, world class, professional, novice, amateur, beginner)
    private Double balance; // równowaga (legendary, world class, professional, novice, amateur, beginner)
    private Double agility; // zwinność (legendary, world class, professional, novice, amateur, beginner)

    public Footballer(Integer id, String name, Double age, Double potential, Double value, Double height,
                      Double weight, Double speed, Double stamina, Double strength, Double balance, Double agility) {
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
