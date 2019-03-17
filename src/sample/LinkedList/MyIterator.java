package sample.LinkedList;
import java.util.Iterator;
import java.util.function.Consumer;

public class MyIterator implements Iterator<Integer> {
    private int size;
    private int[] data;
    private int currentnodeInprogres=0;
    public MyIterator(int size,int[] data){
        this.size=size;
        for (int i=0;i<size;i++) {
            this.data[i] = data[i];
        }
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
    public void remove() {
        currentnodeInprogres++;
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        while(hasNext()){
            action.accept(next());
        }
    }
}
