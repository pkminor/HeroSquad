package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Squad {

    private int id;
    private String name;
    private String cause;
    private int max_size;
    private Hero hero;
    private static List<Squad> instances = new ArrayList<Squad>();

    public Squad(String name, String cause, int max_size, Hero hero) {
        this.name = name;
        this.cause = cause;
        this.max_size = max_size;
        this.hero = hero;
        instances.add(this);
        this.id = instances.size();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCause() {
        return cause;
    }
    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getMax_size() {
        return max_size;
    }
    public void setMax_size(int max_size) {
        this.max_size = max_size;
    }

    public Hero getHero() {
        return hero;
    }
    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setNameCauseSizeHero(String name, String cause, int size, Hero hero){
        this.setName(name);
        this.setCause(cause);
        this.setMax_size(size);
        this.setHero(hero);
    }

    public static List<Squad> getInstances() {
        return instances;
    }
    public static Squad findById(int id){ return instances.get(id-1); }

    public static void clearAll() {
        instances.clear();
    }

    public static List<Hero> getAllHeroes(){
        return instances.stream().map(sqd->Hero.findById(sqd.getHero().getId())).collect(Collectors.toList());
    }

    public static List<Hero> getFreeHeroes(){
        List<Hero> engaged_heroes = Squad.getAllHeroes();
        return Hero.getInstances().stream()
                .filter(hr-> engaged_heroes.contains(hr) == false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return id == squad.id &&
                max_size == squad.max_size &&
                Objects.equals(name, squad.name) &&
                Objects.equals(cause, squad.cause) &&
                Objects.equals(hero, squad.hero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cause, max_size, hero);
    }
}
