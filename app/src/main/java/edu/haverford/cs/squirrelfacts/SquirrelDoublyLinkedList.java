package edu.haverford.cs.squirrelfacts;

import java.util.Iterator;



/**
 * TODO: Implement the rest of this double link structure.
 */

class SquirrelDoubleLink extends SquirrelLink {
    protected SquirrelDoubleLink mPrev;


    public SquirrelDoubleLink(Squirrel squirrel, SquirrelDoubleLink next, SquirrelDoubleLink prev) {
        super(squirrel,next);
        mPrev = prev;


    }

    public void setNext( SquirrelDoubleLink sl){
        mNext = sl;
    }


    public void setPrev (SquirrelDoubleLink sl){
        mPrev = sl;
    }

    public SquirrelDoubleLink getNext() {
        return (SquirrelDoubleLink) mNext;
    }

    public SquirrelDoubleLink getPrev (){
        return mPrev;
    }




}


/**
 * TODO: Implement the rest of this class.
 */

public class SquirrelDoublyLinkedList extends SquirrelList {

    protected SquirrelDoubleLink mTail; // adding a tail to the linked list


    SquirrelDoublyLinkedList() {
        super();
        mTail = null;
    }



    @Override
    public SquirrelDoublyLinkedList addToFront(Squirrel squirrel) {

        SquirrelDoubleLink new_first = new SquirrelDoubleLink(squirrel, null, null);

        if(mFirst ==null){
            mFirst = new_first;
            mTail = new_first;
            return this;
        }
        else{
            new_first.setNext((SquirrelDoubleLink) mFirst);
            ((SquirrelDoubleLink)mFirst).setPrev(new_first);
            mFirst = new_first;
            return this;
        }
    }

    public Squirrel getFirst(){
        if (mFirst != null) {
            return mFirst.getSquirrel();
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public int size() {
        int i = 0;
        for (SquirrelDoubleLink c = (SquirrelDoubleLink) mFirst; c != null; c = c.getNext()) {
            i++;
        }
        return i;
    }


    @Override
    public Squirrel getItem(int m) {
        BackIterator<Squirrel> i = iterator();
        Squirrel s = null;
        while (m >= 0 && i.hasNext()) {
            s = i.next();
            m--;
        }
        if (m >= 0) {
            // Ran out of list
            throw new IndexOutOfBoundsException();
        } else {
            return s;
        }
    }


    /**
     * TODO: Implement the rest of this iterator
     * Note that we extend from SquirrelIterator so that we do not duplicate the code in that class
     */

    class SquirrelDoublyLinkedListIterator extends SquirrelList.SquirrelIterator implements BackIterator<Squirrel> {


        public SquirrelDoublyLinkedListIterator(SquirrelDoubleLink firstLink) {
            super(firstLink);
        }

        @Override
        public boolean hasPrev() {
            return mPrev !=null;
        }

        @Override
        public Squirrel prev() {
            Squirrel s = mPPrev.getSquirrel();
            mCur = mPrev;
            mPrev = mPPrev;
            mPPrev = ((SquirrelDoubleLink) mPPrev).getPrev();
            return s;
        }
    }

    @Override
    public BackIterator<Squirrel> iterator() {
        return new SquirrelDoublyLinkedListIterator((SquirrelDoubleLink) mFirst);
    }

}
