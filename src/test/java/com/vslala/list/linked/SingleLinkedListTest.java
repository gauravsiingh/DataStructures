package com.vslala.list.linked;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {

    private SingleLinkedList<String> linkedList;

    @Before
    public void setup()
    {
        linkedList = new SingleLinkedList<>();
    }

    @Test
    public void itShouldInstantiateLinkedList() {
        linkedList = new SingleLinkedList<>();
        Assert.assertNotNull(linkedList);
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void itShouldAddElementToTheLink() {
        boolean isSuccess = linkedList.add("New Element");
        Assert.assertEquals(1, linkedList.size());
        Assert.assertTrue(isSuccess);
    }

    @Test
    public void itShouldGetElementByIndexFromTheList() {
        linkedList.add("New Element");
        String el = linkedList.get(0);
        Assert.assertEquals("New Element", el);
    }

    @Test
    public void itShouldReturnTrueWhenListIsEmpty() {
        boolean isEmpty = linkedList.isEmpty();
        Assert.assertTrue(isEmpty);
    }

    @Test
    public void itShouldReturnTrueIfTheObjectIsFoundInTheList() {
        linkedList.add("New Element");
        boolean isPresent = linkedList.contains("New Element");
        Assert.assertTrue(isPresent);
    }

    @Test
    public void itShouldConvertLinkedListToArray() {
        linkedList.add("El1");
        linkedList.add("El2");
        Object[] arr = linkedList.toArray();
        Assert.assertEquals("El1", arr[0]);
        Assert.assertEquals("El2", arr[1]);
    }

    @Test
    public void itShouldCopyThePassedArrayIntoTheLinkedListAndReturnNewArray() {
        linkedList.add("Shubham Rangdal");
        linkedList.add("Varun Shrivastava");
        linkedList.add("Abhishek Ralhan");
        linkedList.add("Gaurav Singh");
        linkedList.add("Test Size");
        String[] names = new String[4];
        String[] newArr = linkedList.toArray(names);
        Assert.assertEquals(5, newArr.length);
    }

    @Test
    public void itShouldRemoveElementFromTheList() {
        linkedList.add("Shubham Rangdal");
        linkedList.add("Varun Shrivastava");
        linkedList.add("Abhishek Ralhan");
        linkedList.add("Gaurav Singh");
        boolean isRemoved = linkedList.remove("Varun Shrivastava");
        Assert.assertTrue(isRemoved);
        Assert.assertEquals(3, linkedList.size());

        linkedList.remove("Shubham Rangdal");
        Assert.assertTrue(isRemoved);
        Assert.assertEquals(2, linkedList.size());
    }


}
