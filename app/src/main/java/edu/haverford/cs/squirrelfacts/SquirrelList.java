package edu.haverford.cs.squirrelfacts;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * A single link of a linked list
 */
class SquirrelLink {
    protected Squirrel mSquirrel;
    protected SquirrelLink mNext;

    public SquirrelLink(Squirrel squirrel, SquirrelLink next) {
        mSquirrel = squirrel;
        mNext = next;
    }

    public Squirrel getSquirrel() {
        return mSquirrel;
    }
    public SquirrelLink getNext() {
        return mNext;
    }

    public void setNext(SquirrelLink sl) { mNext = sl; }


}




//make this a sub class of the list

public class SquirrelList extends DataSetObservable implements Iterable<Squirrel>, Collection<Squirrel> {
    protected SquirrelLink mFirst;


    protected  List<DataSetObserver> mObservers = new LinkedList<>();


    public SquirrelList() {
        mFirst = null;
    }



    /**
     * TODO: Create a constructor that creates a list of squirrels from an array.
     * @param squirrels
     */
    SquirrelList(Squirrel[] squirrels) {
        for(int i=0; i<squirrels.length; i++){
            add(squirrels[i]);
        }
        return;
    }

    /**
     * Adds a squirrel to the front of the list.
     * @param squirrel The squirrel to add to the list
     * @return {this}, the updated object after adding the squirrel to the front of the list.
     */
    public SquirrelList addToFront(Squirrel squirrel) {
        mFirst = new SquirrelLink(squirrel, mFirst);
        notifyObserver();
        return this;
    }

    /**
     * Get the item at the `m`th position in the list.
     * @param m The index of the squirrel to fetch
     * @return The squirrel at that index
     * @throws IndexOutOfBoundsException if `m` > getLength()-1
     */
    public Squirrel getItem(int m) {
        Iterator<Squirrel> i = iterator();
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
     * Get the first Squirrel in the list
     * @return first squirrel when list not empty
     * @throws NullPointerException when list is empty
     */
    public Squirrel getFirst() {
        if (mFirst != null) {
            return mFirst.getSquirrel();
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Returns the size of the list.
     * @return
     */
    @Override
    public int size() {
        int i = 0;
        for (SquirrelLink c = mFirst; c != null; c = c.getNext()) {
            i++;
        }
        return i;
    }

    /**
     * TODO: Implement this
     * @return
     */
    @Override
    public boolean isEmpty() {
        if(size()==0 && mFirst == null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * TODO: Implement this
     * @param o
     * @return
     */
    @Override
    public boolean contains(Object o) {
        for (SquirrelLink c = mFirst; c != null; c =c.getNext()){
            if(c.getSquirrel().equals(o)){
                return true;
            }
        }
        return false;
    }

    class SquirrelIterator implements Iterator<Squirrel> {
        protected SquirrelLink mCur;
        protected SquirrelLink mPrev = null;
        protected SquirrelLink mHead;
        protected SquirrelLink mPPrev = null; //the link before mPrev

        public SquirrelIterator(SquirrelLink firstLink) {
            mCur = firstLink;
            mHead = firstLink;
        }

        public boolean hasNext() {
            return mCur != null;
        }

        public Squirrel next() {
            Squirrel s = mCur.getSquirrel();
            mPPrev = mPrev;
            mPrev = mCur;
            mCur = mCur.getNext();
            return s;
        }

        /**
         * Wrong :-(
         */
        public void remove() {

            if(mPrev==null) {
                throw new NullPointerException();
            }
            else if(mPrev==mHead){
                mHead = mPrev.getNext();
                mFirst = mHead;
            }
            else {
                mPPrev.setNext(mCur);
            }

        }

    }

    @NonNull
    @Override
    public Iterator<Squirrel> iterator() {
        return new SquirrelIterator(mFirst);
    }



    /**
     * TODO: Implement this method
     * @param ts
     * @param <T>
     * @return
     */
    @NonNull
    @Override
    public <T> T[] toArray(@NonNull T[] ts) {
        //ts is an empty array and you put lists in it and take it out.
        Object[] original = toArray();
        T[] result = Arrays.copyOf(ts, original.length);
        for (int i =0; i <original.length; i++){
            result[i] = (T) original[i];
        }

        return result;
    }
    //check the size of the list and then check the size of the array and then set all the spaces in the array to null.

    @NonNull
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        int j = 0;
        for (Iterator<Squirrel> i = iterator(); i.hasNext(); j++) {
            arr[j] = i.next();
        }
        return arr;
    }

    @Override
    public boolean add(Squirrel squirrel) {
        addToFront(squirrel);
        return true;
    }

    /**
     * TODO: Implement this. Be sure to make the comment more thoughtful.
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        Iterator<Squirrel> iter = iterator();
        while(iter.hasNext()){
            Object a=iter.next();
            if(a.equals(o)){
            iter.remove();
            notifyObserver();
            return true;
            }
        }

        return false;
    }

    /**
     * TODO: implement `addAll`.
     * @param collection
     * @return
     */
    @Override
    public boolean addAll(@NonNull Collection<? extends Squirrel> collection) {
        for (Squirrel squirrel : collection) {
            add(squirrel);
        }
        return true;
    }

    /**
     * TODO: Implement the `clear` method, which removes all of the elements from the array
     */
    @Override
    public void clear() {
        //use remove function
        Iterator<Squirrel> iter = iterator();
        while(iter.hasNext()){
            iter.next();
            iter.remove();
            }

    }

    public ArrayList<Squirrel> toArrayList() {
        ArrayList<Squirrel> l = new ArrayList<Squirrel>();
        l.addAll(this);
        return l;
    }

    // No need to implement the following three methods

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public void addObserver(DataSetObserver observer){
        mObservers.add(observer);
    }

    public void removeObserver(DataSetObserver dataSetObserver){
        mObservers.remove(dataSetObserver);
    }

    protected void notifyObserver(){
        for(DataSetObserver observer : mObservers){
            observer.onChanged();
            observer.onInvalidated();
        }
    }



    // No need to implement the above three methods
}
