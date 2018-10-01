package edu.haverford.cs.squirrelfacts;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

import edu.haverford.cs.squirrelfacts.Squirrel;
import edu.haverford.cs.squirrelfacts.SquirrelList;



public class SquirrelListTest {
    protected Squirrel mTestSquirrel;
    protected Squirrel mTestSquirrel2;
    protected Squirrel mTestSquirrel3;
    protected SquirrelList mEmptySquirrelList;
    protected Squirrel [] squirrels;
    protected SquirrelList mEmptySquirrelList2; // another empty SquirrelList
    protected Squirrel [] emptyArray;

    public SquirrelListTest() {
        mTestSquirrel = new Squirrel("a","b","c");
        mTestSquirrel2 = new Squirrel ("e","f","g");
        mTestSquirrel3 = new Squirrel ("i","j","k");
        Squirrel [] squirrels = {mTestSquirrel, mTestSquirrel2, mTestSquirrel3};

        mEmptySquirrelList = new SquirrelList(squirrels);
        mEmptySquirrelList2 = new SquirrelList();
    }
    

    @Test
    public void list_startsLengthZero() {
        assertEquals(3, mEmptySquirrelList.size());
    }

    @Test
    public void list_addOneLengthOne() {
        assertEquals(4, mEmptySquirrelList.addToFront(mTestSquirrel).size());
    }

    @Test
    public void list_getBackFirst() {
        assertEquals(mTestSquirrel, mEmptySquirrelList.addToFront(mTestSquirrel).getFirst());
    }

    @Test
    public void list_notIsEmpty() {
        assertEquals(false, mEmptySquirrelList.addToFront(mTestSquirrel).isEmpty());
    }

    // Test that if you insert an item in the second position, `getItem` will return it properly
    @Test
    public void list_getBackInsertedPosition() {
        SquirrelList sl = mEmptySquirrelList;
        sl.addToFront(mTestSquirrel);
        sl.addToFront(mTestSquirrel2);
        sl.addToFront(mTestSquirrel2);
        assertEquals(mTestSquirrel,sl.getItem(2));
    }

    @Test
    public void list_removeLink() {
        SquirrelList sl = mEmptySquirrelList;
        sl.addToFront(mTestSquirrel3);
        sl.addToFront(mTestSquirrel2);
        sl.addToFront(mTestSquirrel);
        Iterator<Squirrel> i = sl.iterator();
        i.next();
        i.remove();
        assertEquals(mTestSquirrel2, sl.getItem(0));
    }

    @Test
    public void list_containsSquirrel() {
        mEmptySquirrelList.add(mTestSquirrel);
        assertEquals(true, mEmptySquirrelList.contains(mTestSquirrel));
    }

    @Test
    public void list_clearIsEmpty() {
        mEmptySquirrelList.add(mTestSquirrel);
        mEmptySquirrelList.clear();
        assertEquals(true, mEmptySquirrelList.isEmpty());
    }

    @Test
    public void list_addAll(){
        SquirrelList sl = mEmptySquirrelList;
        sl.addAll(mEmptySquirrelList);
        assertEquals(6, sl.size() );
    }

    @Test
    public void list_toArray() {
        SquirrelList sl = mEmptySquirrelList2;
        sl.addToFront(mTestSquirrel);
        sl.addToFront(mTestSquirrel2);
        sl.toArray(emptyArray);
        assertEquals(2 ,emptyArray.length);
    }

    @Test
    public void list_clearfunction(){
        SquirrelList sl = mEmptySquirrelList2;
        sl.addToFront(mTestSquirrel);
        sl.addToFront(mTestSquirrel2);
        mEmptySquirrelList2.clear();
        assertEquals(0, sl.size());
    }

    @Test
    public void list_removefunction(){
        SquirrelList sl = mEmptySquirrelList2;
        sl.addToFront(mTestSquirrel);
        sl.addToFront(mTestSquirrel2);
        mEmptySquirrelList2.remove(mTestSquirrel2);
        assertEquals(1, sl.size());
    }




    /**
     * Part 2: Failing test for iteration removal here..
     * TODO: change this from {testname} to your thoughtful name!!
     */
    @Test
    public void list_removebreaks() {
        SquirrelList sl = mEmptySquirrelList2;
        sl.addToFront(mTestSquirrel);
        sl.addToFront(mTestSquirrel2);
        sl.addToFront(mTestSquirrel3);
        Iterator<Squirrel> i = sl.iterator();
        i.next(); // need the next to get to the first item.
        i.remove();
        assertEquals(mTestSquirrel2, sl.getItem(0));
    }



}
