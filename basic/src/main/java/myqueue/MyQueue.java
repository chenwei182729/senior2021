package myqueue;

public interface MyQueue<E> {

    E take();

    void offer(E e);
}
