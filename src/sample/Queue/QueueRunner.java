package Queue;

import java.util.Arrays;

public class QueueRunner {

    public static void main(String[] args){
        QueueImpl queue=new QueueImpl() {
            @Override
            public int size() {
                return super.size();
            }
        };


        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.poll();
        System.out.println(queue.element());
        queue.offer(6);
        Object[] array=queue.toArray();
        System.out.println(Arrays.toString(array));
    }
}
