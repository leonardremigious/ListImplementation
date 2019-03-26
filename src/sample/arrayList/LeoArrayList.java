package sample.arrayList;

import sample.LinkedList.MyIterator;

import java.util.*;

public class LeoArrayList implements List {

    int size=0;
    Integer[] rootArray=new Integer[size];

    @Override
    public int size() {
        int len=rootArray.length;
        return len;
    }

    @Override
    public boolean isEmpty() {
        if(size()<=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i=0;i<size();i++){
            if (rootArray[i]==o){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        if(size()>0){
            MyIterator myIterator=new MyIterator(size(),toIntArray(),0);
            return myIterator;
        }

        return null;
    }

    @Override
    public Object[] toArray() {
        if(size()>0){
            Integer[] newArray=new Integer[size()];
            for(int i=0;i<size();i++){
                newArray[i]=rootArray[i];
            }
            return newArray;
        }
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        int len=size();
        Integer[] newArray=new Integer[len+1];
        if (len==0){
            rootArray=new Integer[1];
            rootArray[0]=(Integer) o;
            return  true;
        }
        else {
            for (int i = 0; i < len; i++) {
                newArray[i]=rootArray[i];
            }
            newArray[len]=(Integer)o;
            rootArray=new Integer[len+1];
            for (int i=0;i<=len;i++){
                rootArray[i]=newArray[i];
            }
            return true;
        }


    }

    @Override
    public boolean remove(Object o) {
        Integer[] newArray=new Integer[size()];
        for(int i=0;i<size();i++){
            newArray[i]=rootArray[i];
        }
        for (int i=0;i<newArray.length;i++){
            int len=size();
            if(newArray[i]==o){
                rootArray=new Integer[len-1];
            }
        }
        int itr=0;
        for (int i=0;i<newArray.length;i++){
            if(newArray[i]==o){
                continue;
            }
            rootArray[itr]=newArray[i];
            itr++;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] obj=c.toArray();
        if(obj.length>0){
            for (int i = 0; i < c.size(); i++) {
                add(obj[i]);
            }
            return  true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if(c.size()>0){
            Object[] objArray=c.toArray();
            for (int i=objArray.length-1;i>=0;i--){
                add(index,objArray[i]);
            }
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        rootArray =new Integer[0];
    }

    @Override
    public Object get(int index) {
      if(index<size()){
          return rootArray[index];
      }
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        for(int i=0;i<size();i++){
            if(index==i){
                rootArray[i]=(Integer)element;
                return  rootArray;
            }
        }
        return null;
    }

    @Override
    public void add(int index, Object element) {
        Integer[] tempArray=new  Integer[size()];
        for (int i=0;i<size();i++){
            tempArray[i]=rootArray[i];
        }
        rootArray=new Integer[size()+1];
        for(int i=0;i<size();i++){
            if(i<index){
                rootArray[i]=tempArray[i];
            }
            if(i==index){
                rootArray[i]=(Integer) element;
            }
            if(i>index){
                rootArray[i]=tempArray[i-1];
            }
        }
    }

    @Override
    public Object remove(int index) {
        Integer[] tempArray=new  Integer[size()];
        if(index<size()) {
            for (int i = 0; i < size(); i++) {
                tempArray[i] = rootArray[i];
            }
            rootArray = new Integer[size() - 1];
            for (int i = 0; i < size(); i++) {
                if (i < index) {
                    rootArray[i] = tempArray[i];
                }
                if (i >= index) {
                    rootArray[i] = tempArray[i + 1];
                }
            }
            return  rootArray;
        }

              return null;
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0;i<size();i++){
            if(rootArray[i]==o){
                return i;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(size()>0) {
            for (int i = size() - 1; i >= 0; i--) {
                if (rootArray[i] == o) {
                    return i;
                }
            }
        }
        return 00000000000;
    }

    @Override
    public ListIterator listIterator() {
        if(size()>0){
            MyIterator myIterator=new MyIterator(size(),toIntArray(),0);
            return myIterator;
        }
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        if(size()>0){
            MyIterator myIterator=new MyIterator(size(),toIntArray(),index);
            return myIterator;
        }
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if(size()>0){
            ArrayList<Integer> sublist=new ArrayList<>();
            for (int i=fromIndex-1;i<toIndex;i++){
                sublist.add(rootArray[i]);
            }
            return sublist;
        }
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] tempArray=c.toArray();
        if(c.size()>0) {
            for (int i = 0; i < size(); i++) {
                int itr = 0;
                for (int j = 0; j < tempArray.length; j++) {
                    if (rootArray[i] == tempArray[j]) {
                        itr++;
                    }
                }
                if (itr == 0) {
                    remove(rootArray[i]);
                }
            }
            return  true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        Object[] tempArray=c.toArray();
        int itr=0;
        if(c.size()>0) {
            for (int i = 0; i < tempArray.length; i++) {
                for (int j = 0; j <size() ; j++) {
                    if (tempArray[i] == rootArray[j]) {
                        remove(rootArray[j]);
                    }
                }
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        Object[] tempArray=c.toArray();
        for (int i=0;i<tempArray.length;i++){
            int  check=0;
            for (int j=0;j<size();j++){
                if(tempArray[i]==rootArray[j]){
                    check++;
                }
            }
            if(check==0){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if(a.length==size()){
            for (int i=0;i<a.length;i++){
                a[i]=rootArray[i];
            }
            return a;
        }
        else if(a.length!=size()&&size()!=0) {
            Object[] objArray = new Object[size()];
            for (int i=0;i<size();i++){
                objArray[i]=rootArray[i];
            }
            return objArray;
        }
        else {
            return new Object[0];
        }
    }
    public  int[] toIntArray(){
        if(size()>0){
            int [] intArray=new int[size()];
            for (int i=0;i<size();i++){
                intArray[i]=rootArray[i];
            }
            return  intArray;
        }
        return new int[0];
    }
    public  void print(){
        for (int i=0;i<size();i++){
            System.out.println(rootArray[i]);
        }
    }
}
