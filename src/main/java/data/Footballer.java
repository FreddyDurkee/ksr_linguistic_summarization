package data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Footballer {

    private Integer id;
    private String name;
    private Double age; // wiek (bardzo stary, stary, średni, młody, bardzo młody)
    private Double potential; // (legendary, world class, professional, novice, amateur, beginner)
    private Double value; // wartość rynkowa (bardzo tani, tani, średni, drogi, bardzo drogi)
    private Double height; // wzrost w cm (bardzo wysoki, wysoki, średni, niski, bardzo niski)
    private Double weight; // waga w kg (ciężka, półciężka, średnia, półśrednia, lekka)
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
