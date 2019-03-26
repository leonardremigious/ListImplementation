package sample.LinkedList;

import java.util.*;


public class LeoLinkedList implements List<Integer> {
    private LinkedList1 root=null;

    @Override
    public int size() {
        LinkedList1 node=root;
        int size=0;
        while (node!=null){
            size++;
            node=node.next;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Object o) {
        Object[] obj = toArray();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj[i] == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        if(size()>0){
        MyIterator myIterator=new MyIterator(size(),intArray(),0);
        return myIterator;
        }
        return null;
    }

    @Override
    public Object[] toArray() {
        int size=size();
        LinkedList1 node=root;
        Object[] obj=new Object[size];
        int itr=0;
        while (node!=null){
            obj[itr]=node.val;
            node=node.next;
            itr++;
        }
        return obj;
    }

    @Override
    public <Integer> Integer[] toArray(Integer[] a) {
        LinkedList1 node=root;int itr=0;
        if (node!=null){
            while (node != null) {
                a[itr] = (Integer) node.val;
            }
            return a;
        }
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        LinkedList1 node=root;
        if(root==null){
            root=new LinkedList1(integer);
            node=root;
            return true;
        }
        else {
            while (node.next!=null) {
                node=node.next;
            }
            node.next=new LinkedList1(integer);
            return true;
        }
    }
    @Override
    public boolean remove(Object o) {
        LinkedList1 node = root;

        if(node==null) {
            return false;
        }

        if (node.val == (int) o) {
            root = root.next;
        }
         else {
            while (node.next != null) {
                if (node.next.val == (int) o) {
                    node.next = node.next.next;
                    return true;
                }
                node = node.next;
            }
        }

        return  false;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] d=c.toArray();
        int len=d.length;
        int itr = 0;

        for (int i=0;i<d.length;i++){
            if(contains((int)d[i])){
                itr++;
            }
        }
                if(itr==len){
                    return  true;
                }


        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        Object[]objects=c.toArray();
        int itr=0;
        for (int i=0;i<objects.length;i++){
            add((int)objects[i]);
            itr++;
        }
        if(itr==objects.length){
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        Object[]objects=c.toArray();
        int itr=0;
        for (int i=0;i<objects.length;i++){
            add(index,(int)objects[i]);
            itr++;
            index++;
        }
        if(itr==objects.length){
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[]objects=c.toArray();
        int itr=0;
        for (int i=0;i<objects.length;i++){
            remove(objects[i]);
            itr++;
        }
        if(itr==objects.length){
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        LinkedList1 node=root;
        Object[] tempArray =c.toArray();
        int itr=0;
        if(size()>0) {
            while (node != null) {
                for (int j = 0; j < tempArray.length; j++) {
                    if (node.val == tempArray[j]) {
                        itr++;
                    }
                }
                if (itr == 0) {
                    remove(node);
                }
                node = node.next;
            }
            return true;
        }

        return false;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Integer get(int index) {
        int itr=1;
        LinkedList1 node=root;
        while (node!=null){
            if(itr==index){
                return node.val;
            }
            node=node.next;
            itr++;
        }
        return null;
    }

    @Override
    public Integer set(int index, Integer element) {
        int itr=1;
        LinkedList1 node=root;

        while (node!=null){
            if(itr==index){
                node.val=element;
                return node.val ;
            }
            node=node.next;
            itr++;
        }
        return null;
    }

    @Override
    public void add(int index, Integer element) {
        LinkedList1 node=root;
        if(index>size()){
            return;
        }
        if(index==1){
            root=new LinkedList1(element);
            root.next=node;
            return;
        }
        else{
            for(int i=2;i<=index;i++){
                if(i==index){
                    LinkedList1 temp=node.next;
                    node.next=new LinkedList1(element);
                    node.next.next=temp;
                    return;
                }
                else{
                    node=node.next;
                }
            }
        }
    }

    @Override
    public Integer remove(int index) {
        LinkedList1 node=root;
        int itr=2;
        if (index==1){
            root=node.next;
            return null;
        }
        while (node.next!=null){
            if(itr==index){
                node.next=node.next.next;
                return null;
            }
            itr++;
            node=node.next;
        }
        System.out.println("enter the correct index");
        return null;
    }

    @Override
    public int indexOf(Object o) {
        LinkedList1 node=root;
        int itr=0;
        int index=1;
        while (node!=null){
            if(toArray()[itr]==o){
                return index;
            }
            itr++;
            index++;
            node=node.next;
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        LinkedList1 node=root;
        int index=1;
        while (node!=null){
            if(node.next==null){
                return index;
            }
            index++;
            node=node.next;
        }

        return 0;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        if (size()>0){
            MyIterator myIterator=new MyIterator(size(),intArray(),0);
        }
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        LinkedList1 node=root;
        if (index<size()){
            int[] listArray=new int[size()-index-1];
            for (int i=1,itr=0;i<=size();i++){
                if(i>=size()-index) {
                    listArray[itr] =node.val;
                    itr++;
                }
                node=node.next;
            }
            MyIterator myIterator=new MyIterator(size()-index,listArray,index-1);
            return myIterator;
        }
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        LinkedList subList= new LinkedList();
        LinkedList1 node=root;
        int itr=1;
        if(size()>=toIndex) {
            while (node != null) {
                if (itr >= fromIndex && itr <= toIndex) {
                    subList.add(node.val);
                }
                itr++;
                node=node.next;
            }
            return subList;
        }
        else {
            System.out.println("enter the correct limits:");
            return null;
        }
    }

    public void print() {
        LinkedList1 node=root;
        if (node == null) {
            System.out.println("there is no values to print");
        }
        else {
            while (node!= null) {
                System.out.println(node.val);
                node = node.next;
            }
        }
    }
    public void printArray(Object[] object){
        int i=0,size=size();
        System.out.println("the array is");
        while (i<size){
            System.out.println(object[i]);
            i++;
        }
        System.out.println();
    }
    public int[] intArray(){
        LinkedList1 node=root;
        int[] intArray=new int[size()];
        int itr=0;
        while (node!=null){
            intArray[itr]=node.val;
            itr++;
            node=node.next;
        }
        return intArray;
    }

}
