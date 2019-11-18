package models;

import com.sun.source.tree.AssertTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
        Squad.clearAll();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void SquadInstantiatesCorrectly(){
        Squad s = setUpSquad();
        assertTrue(s instanceof  Squad);
    }

    @Test
    public void gettersReturnProperties_true(){
        Squad s = setUpSquad();
        Hero h = new Hero("abc",2,"wind","sunshine");
        s.setHero(h);

        assertEquals("mobi",s.getName());
        assertEquals("food",s.getCause());
        assertEquals(5000,s.getMax_size());
        assertEquals(h, s.getHero());
    }

    @Test
    public void settersReturnProperties_true(){
        Squad s = setUpSquad();

        String old_name = s.getName();
        String old_cause = s.getCause();
        int old_size = s.getMax_size();
        Hero old_hero = s.getHero();

        s.setNameCauseSizeHero("xyz","water", 1000, new Hero("aqua",5,"water","sunshine"));

        assertNotEquals(old_name, s.getName());
        assertNotEquals(old_cause, s.getCause());
        assertNotEquals(old_size,s.getMax_size());
        assertNotEquals(old_hero,s.getHero());
    }

    @Test
    public void clearsAll_true(){
        assertEquals(0, Squad.getInstances().size());
    }

    @Test
    public void findByIdReturnsCorrectSquad(){
        Squad s = setUpSquad();
        Squad s2 = setUpSquad();

        Squad found = Squad.findById(s2.getId());
        assertEquals(s2, found);
    }

    @Test
    public void getAllReturnsAllSquads(){
        Squad s = setUpSquad();
        Squad s2 =setUpSquad();

        assertEquals(2, Squad.getInstances().size());
    }

    private Squad setUpSquad(){
        return new Squad("mobi","food",5000,new Hero("foodly",1,"water","wind"));
    }
}