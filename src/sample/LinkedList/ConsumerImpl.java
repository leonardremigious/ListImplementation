package sample.LinkedList;

import java.util.function.Consumer;

class ConsumerImpl implements Consumer<Integer> {
    @Override
    public void accept(Integer integer) {

    }

    @Override
    public Consumer<Integer> andThen(Consumer<? super Integer> after) {
        return null;
    }


}
