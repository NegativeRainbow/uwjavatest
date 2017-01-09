package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person> {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private static int numPeople;
  
  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    numPeople++;
  }
  
  public int getAge(){
   return age;
  }
  
  public void setAge(int n){
   if(n < 0){
      throw new IllegalArgumentException();
   }
   this.age = n;
  }
  
  public String getName(){
   return name;
  }
  
  public void setName(String s){
   if(s == null){
      throw new IllegalArgumentException();
   }
   this.name = s;
  }
    
  public double getSalary(){
   return salary;
  }
  
  public void setSalary(double d) {
   this.salary = d;
  }
  
  public int count(){
   return numPeople;
  }
  
  public String getSSN(){
   return ssn;
  }

  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public String tostring() {
    return "[Person name:" + name + " age:" + age + " salary:" + salary + "]";
  }
  
  public boolean equals(Person other){
   if(this.name.equals(other.name) && this.age == other.age){
      return true;
   } else {
      return false;
   }
  }
  
  public int compareTo(Person other) {
    double difference = this.salary - other.salary;
    return (int)Math.round(difference);
  }

  public static ArrayList getNewardFamily(){
   ArrayList<Person> family = new ArrayList<Person>();
   family.add(new Person("Ted", 41, 250000));
   family.add(new Person("Charlotte", 43, 150000));
   family.add(new Person("Michael", 22, 10000));
   family.add(new Person("Matthew", 15, 0));
   return family;
  }
  
  public static class AgeComparator implements Comparator<Person>{
   public int compare(Person p1, Person p2) {
      return p2.age - p1.age;
   }
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
