package com.example.asn2.models;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private int weight;
    private int height;
    private String hair;
    private double gpa;

    // Default constructor
    public Student() { }

    // Constructor
    public Student(String nm, int wt, int ht, String hr, double g) {
        this.name = nm;
        this.weight = wt;
        this.height = ht;
        this.hair = hr;
        this.gpa = g;
    }

    // Getters and setters
    public int getUid() { return uid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public String getHair() { return hair; }
    public void setHair(String hair) { this.hair = hair; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    
}
