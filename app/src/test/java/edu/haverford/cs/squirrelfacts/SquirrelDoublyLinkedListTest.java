package edu.haverford.cs.squirrelfacts;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquirrelDoublyLinkedListTest extends SquirrelListTest {

    protected SquirrelDoublyLinkedList mEmptySquirrelList;

    public SquirrelDoublyLinkedListTest() {
        super();
        mEmptySquirrelList = new SquirrelDoublyLinkedList();
    }

    @Test
    public void Test_addToFront(){
        SquirrelDoublyLinkedList sl = mEmptySquirrelList;
        sl.addToFront(mTestSquirrel);
        sl.addToFront(mTestSquirrel2);
        sl.addToFront(mTestSquirrel3);
        assertEquals(3, sl.size());
    }

    @Test
    public void Test_getFirst(){
        SquirrelDoublyLinkedList sl = mEmptySquirrelList;
        sl.addToFront(mTestSquirrel);
        sl.addToFront(mTestSquirrel2);
        sl.addToFront(mTestSquirrel3);
        assertEquals(mTestSquirrel3, sl.getFirst());
    }

    @Test
    public void Test_remove(){
        SquirrelDoublyLinkedList sl = mEmptySquirrelList;
        sl.addToFront(mTestSquirrel);
        sl.addToFront(mTestSquirrel2);
        sl.addToFront(mTestSquirrel3);
        sl.remove(mTestSquirrel3);
        assertEquals(2, sl.size());
    }

    @Test
    public void Test_getItem(){
        SquirrelDoublyLinkedList sl = mEmptySquirrelList;
        sl.addToFront(mTestSquirrel);
        sl.addToFront(mTestSquirrel2);
        sl.addToFront(mTestSquirrel3);
        assertEquals(mTestSquirrel2, sl.getItem(1));

    }


    /**
     * This test should test a basic property: that you can go forward and back in the list and
     * get to the same element.
     */

    @Test
    public void list_forwardBack() {
        SquirrelDoublyLinkedList sl = mEmptySquirrelList;
        sl.addToFront(mTestSquirrel);
        sl.addToFront(mTestSquirrel2);
        sl.addToFront(mTestSquirrel3);
        BackIterator<Squirrel> i = sl.iterator();
        i.next();
        i.next();
        i.prev();
        i.remove();
        assertEquals(false, sl.contains(mTestSquirrel3));
    }

    @Test
    public void list_iteratorTest(){
        SquirrelDoublyLinkedList sl = mEmptySquirrelList;
        sl.addToFront(mTestSquirrel);
        sl.addToFront(mTestSquirrel2);
        sl.addToFront(mTestSquirrel3);
        BackIterator<Squirrel> i = sl.iterator();
        i.next();
        i.next();
        i.next();
        i.prev();
        i.remove();
        assertEquals(false, sl.contains(mTestSquirrel2));
    }
}
