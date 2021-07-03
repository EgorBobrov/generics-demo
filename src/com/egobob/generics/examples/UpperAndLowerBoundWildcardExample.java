package com.egobob.generics.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpperAndLowerBoundWildcardExample {

    public static List<Person> allContacts = new ArrayList<>();

    public static List<Customer> customers = new ArrayList<>();

    public static abstract class Person {
        public String emailAddress;
        public String name;
    }

    public static class Customer extends Person {
        public boolean vipStatus;
        public Map<String, Integer> orders;
    }

    public static class Supplier extends Person {
        public Map<String, Double> productPrices;
    }

    public static void sendEmails(List<? extends Person> list, String update) {
        for (Person person : list) {
            // imagine that email sending logic is here
            System.out.printf("Sent company update [%s] to: %s using email: %s",
                    update, person.name, person.emailAddress);
        }
    }

    public static void addCustomerToList(Customer customer, List<? super Customer> list) {
        list.add(customer);
        System.out.printf("Added customer: %s to the list", customer.name);
    }


    public static void main(String[] args) {
    }
}
