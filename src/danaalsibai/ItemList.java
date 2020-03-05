/*
        Name: Dana Alsibi
        Assignment:  Assignment 3
        Program: Item List Application
        Date:  February 10th, 2020
    
        Description: an application that can be used to keep 
                    track of item cost information.
        
 */
package danaalsibai;

import java.util.*;

/**
 * @author danasebai
 */
public class ItemList {

    /**
     * Models an ArrayList of Items.
     */

    public ArrayList<Item> itemList;

    /**
     * Constructor
     */
    public ItemList() {
        itemList = new ArrayList<>();
    }

    /**
     * @param num this is an integer index
     * @return the item object at that index.
     */
    public Item get(int num) {
        return itemList.get(num);
    }

    /**
     * @param item Item object to add to the itemList.
     */
    public void add(Item item) {

        int index = findItem(item.itemSize);

        if (index < 0) {
            itemList.add(item);

        } else {
            itemList.get(index).setBaseCost(itemList.get(index).getBaseCost()
                    + item.getBaseCost());
        }
    }

    /**
     *
     * @param sizeItem receives a specific Size Enum
     * @return the index of the Item element in the itemList that has the same
     * size
     */
    public int findItem(Size sizeItem) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).itemSize.equals(sizeItem)) {
                return i;
            }
        }
        return (-1);

    }

    /**
     * @return the size of the itemList
     */
    public int length() {
        int elementsNum = 0;
        for (Item item : itemList) {
            elementsNum = itemList.size();
        }
        return elementsNum;
    }

    // return a String representation of the item in the item list.
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < itemList.size(); i++) {

            s += itemList.get(i).toString() + "\n";
        }
        return s;
    }
}
