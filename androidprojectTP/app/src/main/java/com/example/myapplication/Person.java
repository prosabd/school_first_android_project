package com.example.myapplication;

public class Person {

        private String name;
        private String firstname;
        private int age;

        public Person(String name, String firstname, int age) {
            this.name = name;
            this.firstname = firstname;
            this.age = age;
        }

        // getters and setters

        @Override
        public String toString() {
            return name + " " + firstname + ", " + age;
        }
}
