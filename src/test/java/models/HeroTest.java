package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
        Hero.clearAll();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void HeroIntantiatesCorrectly_true(){
        Hero h = setUpHero();
        assertTrue(h instanceof Hero);
    }

    @Test
    public void gettersReturnProperties_true(){

        Hero h = setUpHero();

        assertEquals(1, h.getId());
        assertEquals("xyz",h.getName());
        assertEquals("flying",h.getPower());
        assertEquals("swimming",h.getWeakness());
        assertEquals(10, h.getAge());
    }

    @Test
    public void settersUpdateProperties_true(){
        Hero h = setUpHero();

        String old_name =h.getName();
        String old_power = h.getPower();
        String old_weakness = h.getWeakness();
        int old_age = h.getAge();

        h.setNameAgePowerWeakness("abc",20,"swimming","flying");

        assertNotEquals(old_name, h.getName());
        assertNotEquals(old_power, h.getPower());
        assertNotEquals(old_weakness, h.getWeakness());
        assertNotEquals(old_age, h.getAge());

    }

    @Test
    public void getAllReturnsAll(){
        Hero h = setUpHero();
        Hero h2 = setUpHero();

        assertEquals(2,Hero.getInstances().size());
    }

    @Test
    public void clearAllClearsAll(){
        //the before setup clears the instances before each test. so we can just test for size 0
        assertEquals(0,Hero.getInstances().size());
    }

    private Hero setUpHero(){
        return new Hero("xyz",10,"flying","swimming");
    }
}