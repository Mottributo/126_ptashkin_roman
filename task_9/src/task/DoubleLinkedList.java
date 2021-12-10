package task;

public class DoubleLinkedList<T extends Comparable<T>> {
    public DoubleLinkedList() {}
    private DoubleLinkedListItem start;
    private DoubleLinkedListItem end;
    private int size = 0;

    public DoubleLinkedListItem findFirstItem(T value) {
        DoubleLinkedListItem selected = start;
        for (int i = 0; i < getSize(); i++) {
            if (selected.getData() == value) return selected;
            selected = selected.getNext();
        }
        return null;

    }
    public DoubleLinkedListItem findLastItem(T value) {
        DoubleLinkedListItem selected = end;
        for (int i = 0; i < getSize(); i++) {
            if (selected.getData() == value) return selected;
            selected = selected.getPrev();
        }
        return null;
    }
    public void insertAfter(DoubleLinkedListItem anchor, T value) {
        DoubleLinkedListItem inserted = new DoubleLinkedListItem(value);
        if (anchor == null) {
            if (end == null) {
                start = inserted;
                end = inserted;
            }
            else {
                start.setPrev(inserted);
                inserted.setNext(start);
                start = inserted;
            }
        }
        else if (anchor == end) {
            anchor.setNext(inserted);
            inserted.setPrev(anchor);
            end = inserted;
        }
        else {
            inserted.setNext(anchor.getNext());
            inserted.setPrev(anchor);
            anchor.getNext().setPrev(inserted);
            anchor.setNext(inserted);
        }
        size++;
    }
    public void insertBefore(DoubleLinkedListItem anchor, T value) {
        DoubleLinkedListItem inserted = new DoubleLinkedListItem(value);
        if (anchor == null) {
            if (start == null) {
                start = inserted;
                end = inserted;
            }
            else {
                end.setNext(inserted);
                inserted.setPrev(end);
                end = inserted;
            }
        }
        else if (anchor == start) {
            anchor.setPrev(inserted);
            inserted.setNext(anchor);
            start = inserted;
        }
        else {
            inserted.setPrev(anchor.getPrev());
            inserted.setNext(anchor);
            anchor.getPrev().setNext(inserted);
            anchor.setPrev(inserted);
        }
        size++;
    }
    public void remove(DoubleLinkedListItem deleted) {
        if (deleted != start && deleted != end) {
            deleted.getNext().setPrev(deleted.getPrev());
            deleted.getPrev().setNext(deleted.getNext());
        }
        else if (start == end) {start = null; end = null;}
        else if (deleted == start) {
            start = deleted.getNext();
            deleted.getNext().setPrev(null);
            deleted.setNext(null);

        }
        else /*deleted == end*/ {
            end = deleted.getPrev();
            deleted.getPrev().setNext(null);
            deleted.setPrev(null);
        }
        size--;
    }
    public int getSize() {
        return size;
    }
    public DoubleLinkedListItem<T> getFirst() {
        return start;
    }
    public DoubleLinkedListItem<T> getLast() {
        return end;
    }

}
