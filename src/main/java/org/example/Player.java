package org.example;

/**
 * Represents a football player with basic profile and contract details.
 * Immutable fields (id, name, age) are set at construction time and cannot change.
 * Mutable fields (position, salary, jerseyNumber) reflect contract/squad updates.
 */

public class Player {

    private final int id;
    private final String name;
    private final int age;

    // These can change if a player is transferred or renegotiates
    private String position;
    private double salary;
    private int jerseyNumber;

    public Player(int id, String name, int age, String position, double salary, int jerseyNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.jerseyNumber = jerseyNumber;
    }

    // --- Getters ---

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    // --- Setters (only for mutable fields) ---

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", jerseyNumber=" + jerseyNumber +
                '}';
    }
}