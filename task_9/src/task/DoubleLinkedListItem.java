package task;

public class DoubleLinkedListItem<T extends Comparable<T>> {
    // Fields
    private T data;
    private DoubleLinkedListItem<T> previous;
    private DoubleLinkedListItem<T> next;

    // Constructor
    public DoubleLinkedListItem(T data) {
        this.data = data;
    }


    // Methods
    public DoubleLinkedListItem<T> getNext() {return next;}
    public DoubleLinkedListItem<T> getPrev() {return previous;}
    public T getData() {return data;}

    public void setNext(DoubleLinkedListItem<T> dl) {next = dl;}
    public void setPrev(DoubleLinkedListItem<T> dl) {previous = dl;}
    public void setData(T value) {data = value;}
}
