package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hero {
    private int id;
    private String name;
    private int age;
    private String power;
    private String weakness;
    private static List<Hero> instances = new ArrayList<>();

    public Hero(String name, int age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        instances.add(this);
        this.id = instances.size();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }

    public String getWeakness() {
        return weakness;
    }
    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public void setNameAgePowerWeakness(String name, int age, String power, String weakness){
        this.setName(name);
        this.setAge(age);
        this.setPower(power);
        this.setWeakness(weakness);
    }

    public static Hero findById(int id){
        return instances.get(id-1);
    }

    public static List<Hero> getInstances() {
        return instances;
    }
    public static void clearAll(){
        instances.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return id == hero.id &&
                age == hero.age &&
                Objects.equals(name, hero.name) &&
                Objects.equals(power, hero.power) &&
                Objects.equals(weakness, hero.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, power, weakness);
    }
}
