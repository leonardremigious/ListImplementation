package sample.LinkedList;

import java.util.ArrayList;

public class LeoLinkedListRunner extends LeoLinkedList {
    public static void main(String args[]){
        LeoLinkedList leo=new LeoLinkedList();
        leo.add(5);
        leo.add(6);leo.add(7);
        Object o=7;
        leo.remove(o);
        System.out.println("The size is:"+leo.size());
        System.out.println("Is the List is empty,gives: "+leo.isEmpty());
        System.out.println("the index of the given element is: "+leo.indexOf(5));
        System.out.println("the integer at given index is: "+leo.get(2));
        System.out.println("It is "+leo.contains(5)+" that it contains given object");
        ArrayList<Integer> arrList = new ArrayList<>(2);
        arrList.add(5);
        System.out.println("it is "+leo.containsAll(arrList)+" it contain all collection elements:");
        System.out.println();
        System.out.println("it is "+leo.addAll(arrList)+" that all elements are added to collection elements:");
        System.out.println();
        System.out.println("it is "+leo.addAll(2,arrList)+" that all elements are added to collection elements:");
        leo.print();
        System.out.println();
        arrList.add(5);
        arrList.add(5);
        System.out.println("it is "+leo.removeAll(arrList)+" that collection elements are removed:");
        leo.print();
        System.out.println();
        System.out.println("the last index is: "+leo.lastIndexOf(leo.toArray()));
        System.out.println();
        leo.printArray(leo.toArray());
        leo.print();
        System.out.println();
        leo.set(1,9);
        leo.add(1,1);
        leo.print();
        leo.remove(2);
        leo.print();
    }
}
