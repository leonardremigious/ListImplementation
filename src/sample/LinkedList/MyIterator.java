package sample.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

public class MyIterator implements ListIterator<Integer> {
    private int size;
    private int[] data;
    private int currentnodeInprogres=0;
    public MyIterator(int size,int[] data, int breakNode){
        this.size=size;
        for (int i=0;i<size;i++) {
            this.data[i] = data[i];
        }
        currentnodeInprogres=breakNode;
    }
    @Override
    public boolean hasNext() {
        if(currentnodeInprogres<size){
            return  true;
        }
        return false ;
    }

    @Override
    public Integer next() {
        int value=data[currentnodeInprogres];
        currentnodeInprogres++;
        return value ;
    }

    @Override
    public boolean hasPrevious() {
        if(currentnodeInprogres>0){
            return  true;
        }
        return false;
    }

    @Override
    public Integer previous() {
        if (hasPrevious()){
            int previousNode=currentnodeInprogres--;
            return  previousNode;
        }
        return null;
    }

    @Override
    public int nextIndex() {
        if(hasNext()){
            int nextIndex=currentnodeInprogres++;
            return  nextIndex;
        }
        return 0;
    }

    @Override
    public int previousIndex() {
        if(hasPrevious()){
            int previousIndex=currentnodeInprogres--;
            return previousIndex;
        }
        return 0;
    }

    @Override
    public void remove() {
        currentnodeInprogres++;
    }

    @Override
    public void set(Integer integer) {
        data[currentnodeInprogres]=integer;
    }

    @Override
    public void add(Integer integer) {
        size=size++;
        int[] temp= new  int[size];
        for (int i=0;i<size-1;i++){
            temp[i]=data[i];
        }
        data=new int[size];
        for (int i=0;i<size;i++){
            if(i==size-1){
                data[i]=integer;
            }
            data[i]=temp[i];
        }

    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        while(hasNext()){
            action.accept(next());
        }
    }
}
