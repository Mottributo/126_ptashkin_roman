package task;

public class DoubleLinkedListSorter {

    public static <T extends Comparable<T>> void sort(DoubleLinkedList<T> list) {
        bubbleSort(list);
    }

    private static <T extends Comparable<T>> void bubbleSort(DoubleLinkedList<T> list) {
        // Kinda bubble sort. Find the minimal, throw to the end, shrink the sorting range by 1,
        // repeat until the sorting range is of length 1.
        for(int i = 0; i < list.getSize(); i++) {

            DoubleLinkedListItem minimal =  list.getFirst();
            DoubleLinkedListItem current = list.getFirst();

            for(int k = 0; k < list.getSize()-i; k++) {
                if (current.getData().compareTo(minimal.getData()) < 0)
                {
                    minimal = current;
                }
                current = current.getNext();
            }
            list.remove(minimal);
            list.insertAfter(list.getLast(), (T) minimal.getData());
        }
    }
    /*
    private static <T extends Comparable<T>> void subSort(DoubleLinkedList<T> list, int start, int end) {
        // Kinda like cocktail shaker sort. Find the minimal and maximal entries,
        // put them to the beginning and end respectively, repeat but with sorting range shrunk
        // by 1 from every side.

        if (start == end) {}
        else if (start == end - 1) {}
        else if (end - start == 3) {
            DoubleLinkedListItem<T> current = getItemByIndex(list, start);
            DoubleLinkedListItem<T> max = current;
            DoubleLinkedListItem<T> min = current;
            for (int i = start; i < end - 1; i++) {
                current = current.getNext();
                int maxCompare = current.getData().compareTo(max.getData());
                int minCompare = current.getData().compareTo(min.getData());
                if (maxCompare == 1) max = current;
                if (minCompare == -1) min = current;
            }
            list.remove(min);
            list.insertBefore(list.getFirst(), min.getData());
            list.remove(max);
            list.insertAfter(list.getLast(), max.getData());
        }
        else {
            DoubleLinkedListItem<T> current = getItemByIndex(list, start);
            DoubleLinkedListItem<T> max = current;
            DoubleLinkedListItem<T> min = current;

            for (int i = start; i < end - 1; i++) {
                current = current.getNext();
                int maxCompare = current.getData().compareTo(max.getData());
                int minCompare = current.getData().compareTo(min.getData());
                if (maxCompare == 1) max = current;
                if (minCompare == -1) min = current;
            }

            list.remove(min);
            list.insertBefore(list.getFirst(), min.getData());
            list.remove(max);
            list.insertAfter(list.getLast(), max.getData());

            start++;
            end--;
            subSort(list, start, end);
        }
    }
    */
}
