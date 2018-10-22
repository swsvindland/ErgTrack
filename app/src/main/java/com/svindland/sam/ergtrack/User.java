package com.svindland.sam.ergtrack;

/**
 * Created by Sam on 5/8/2017.
 */

public class User {
    private String email;
    private String password;

    private String firstName;
    private String lastName;
    private int age;
    private int heightFeet;
    private int heightInch;
    int weight;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, int age, int heightFeet, int heightInch, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightFeet = heightFeet;
        this.heightInch = heightInch;
        this.weight = weight;
    }

    public String toString() {
        return firstName + "\t" + lastName + "\t" + age + "\t" + heightFeet + "\t" + heightInch + "\t" + weight;
    }
}
