package Queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public abstract class QueueImpl implements Queue{
  public static void main(String[] ags){

  }
    @Override
    public int size() {
      QueueNode node=root;
      int size=0;
      while (node!=null){
          node=node.next;
          size+=1;
      }
        return size;
    }

    @Override
    public boolean isEmpty() {
      if(root!=null){return  true;}
        return false;
    }

    @Override
    public boolean contains(Object o) {
      QueueNode node=root;
      while (node!=null){
          if(node.value==o){
              return true;
          }
          node=node.next;
      }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
      if(root==null){
          return  new Object[0];
        }
      QueueNode node=root;
      Object[] array=new Object[size()];
      int itr=0;
      while (node!=null){
          array[itr]=node.value;
          itr++;
          node=node.next;
      }
        return array;
    }

    @Override
    public boolean remove(Object o) {
      QueueNode node=root;
      if(root.value==o){
          root=root.next;
      }
      while (node.next!=null){
          if(node.value==o){
              node.next=node.next.next;
          }
          node=node.next;
      }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        root=null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }





    QueueNode root=null;
    @Override
    public boolean add(Object o) {
        QueueNode node=root;
        if(root==null){
            root=new QueueNode((Integer) o);
            return true;
        }
        else{
            while (node.next!=null){
                node=node.next;
            }
        node.next=new QueueNode((Integer)o);
            return true;
        }
    }

    @Override
    public boolean offer(Object o) {
        QueueNode node=root;
        if(root==null){
            root=new QueueNode((Integer) o);
            return true;
        }
        else{
            while (node.next!=null){
                node=node.next;
            }
            node.next=new QueueNode((Integer)o);
            return true;
        }
    }

    @Override
    public Object remove() {
        QueueNode node=root;
        if(root==null){
            return  null;
        }
        root=root.next;
        return root;
    }

    @Override
    public Object poll() {
        QueueNode node=root;
        if(root==null){
            return  null;
        }
       root=root.next;
       return root;
    }

    @Override
    public Object element() {
        if(root!=null){
            return root.value;
        }
        return null;
    }

    @Override
    public Object peek() {
        if(root!=null){
            return root.value;
        }
        return null;
    }
}
