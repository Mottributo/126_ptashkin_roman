import org.junit.Test;
import org.junit.Assert;

public class Task1_Tests extends Assert {

    // DynamicArray tests
    @Test
    public void DA_create_sizeEquals0() {
        DynamicArray<Integer> array = new DynamicArray<>();
        assertEquals(0, array.getSize());
    }
    @Test
    public void DA_getData_FromEmpty_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>();
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));
        assertEquals("Index out of bounds", ex.getMessage());
    }
    @Test
    public void DA_create_WithSetSize_sizeEqualsSetSize() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        assertEquals(10, array.getSize());
    }
    @Test
    public void DA_getData_createWithSetSize_EachCellReturnsNull() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        for (int i = 0; i < 10; i++) {
            assertNull(array.get(i));
        }
    }
    @Test
    public void DA_getData_FromLessThanZeroIndex_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>();
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
        assertEquals("Index out of bounds", ex.getMessage());
    }
    @Test
    public void DA_getData_FromEqualToSizeIndex_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> array.get(10));
        assertEquals("Index out of bounds", ex.getMessage());
    }
    @Test
    public void DA_getData_FromMoreThanSizeIndex_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> array.get(11));
        assertEquals("Index out of bounds", ex.getMessage());
    }
    @Test
    public void DA_setData_FromLessThanZeroIndex_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> array.set(-1, 0));
        assertEquals("Index out of bounds", ex.getMessage());
    }

    @Test
    public void DA_setData_FromEqualToSizeIndex_raisesCorrectException() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        try {
            array.set(10, 0);
            fail();
        }
        catch (Exception ex) {
            assertEquals("Index out of bounds", ex.getMessage());
        }
    }
    @Test
    public void DA_setData_FromMoreThanSizeIndex_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> array.set(11, 0));
        assertEquals("Index out of bounds", ex.getMessage());
    }
    @Test
    public void DA_getData_afterSetDataForEachCell_successful() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        for (int i = 0; i < array.getSize(); i++) {
            array.set(i, i);
        }
        for (int i = 0; i < array.getSize(); i++) {
            assertEquals((Integer) i, array.get(i));
        }
    }
    @Test
    public void DA_resize_toSame_sizeNotChanged() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.resize(10);
        assertEquals(10, array.getSize());
    }
    @Test
    public void DA_resize_toHigher_sizeChanged() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.resize(121);
        assertEquals(121, array.getSize());

    }
    @Test
    public void DA_resize_toZero_successful() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.resize(0);
        assertEquals(0, array.getSize());
    }
    @Test
    public void DA_resize_toLowerThanZero_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>();
        assertThrows(NegativeArraySizeException.class, () -> array.resize(-1));
    }
    @Test
    public void DA_resize_toLower_sizeChanged() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.resize(9);
        assertEquals(9, array.getSize());
    }
    @Test
    public void DA_insert_toLowerThanZeroIndex_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        assertThrows(IndexOutOfBoundsException.class, () -> array.insert(-1, 1));
    }
    @Test
    public void DA_insert_toHigherThanSizeIndex_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        assertThrows(IndexOutOfBoundsException.class, () -> array.insert(11, 1));
    }
    @Test
    public void DA_insert_toEqualToSizeIndex_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        assertThrows(IndexOutOfBoundsException.class, () -> array.insert(10, 1));
    }
    @Test
    public void DA_insert_toLastIndex_increasesSize() {
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.insert(1, 420);
        assertEquals(3, array.getSize());
    }
    @Test
    public void DA_insert_toLastIndex_addsData() {
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.insert(1, 420);
        assertEquals((Integer) 420, array.get(1));
    }
    @Test
    public void DA_pushBack_toZeroSizeArray_increasesSize() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.pushBack(420);
        assertEquals(1, array.getSize());
    }
    @Test
    public void DA_pushBack_toZeroSizeArray_addsData() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.pushBack(420);
        assertEquals((Integer) 420, array.get(0));
    }
    @Test
    public void DA_pushBack_addsData_intoEnd() {
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.pushBack(420);
        assertEquals((Integer) 420, array.get(2));
    }
    @Test
    public void DA_popBack_toZeroSizeArray_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>();
        assertThrows(UnsupportedOperationException.class, () -> array.popBack());

    }
    @Test
    public void DA_popBack_decreasesSize() {
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.set(0, 420);
        array.set(1, 666);
        array.popBack();
        assertEquals(1, array.getSize());
    }
    @Test
    public void DA_popBack_removesDataInEnd() {
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.set(0, 420);
        array.set(1, 666);
        array.popBack();
        assertEquals((Integer) 420, array.get(0));
    }
    @Test
    public void DA_remove_fromIndexEqualToSize_raisesException() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        assertThrows(IndexOutOfBoundsException.class, () -> array.remove(10));
    }
    @Test
    public void DA_remove_decreasesSize() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.remove(0);
        assertEquals(9, array.getSize());
    }
    @Test
    public void DA_remove_removesChosenElement() {
        DynamicArray<Integer> array = new DynamicArray<>(4);
        array.set(0, 10); array.set(1, 20); array.set(2, 30); array.set(3, 40);
        array.remove(1);
        assertEquals((Integer) 30, array.get(1));
    }

    //
    // Node tests
    //

    @Test
    public void node_createWithNeighbors_ThisPrevPointsToRealPrev() {
        Node<Integer> previousNode = new Node<>(111);
        Node<Integer> nextNode = new Node<>(999);
        Node<Integer> central = new Node<>(555, nextNode, previousNode);
        assertEquals(previousNode, central.getPrev());
    }
    @Test
    public void node_createWithNeighbors_ThisNextPointsToRealNext() {
        Node<Integer> previousNode = new Node<>(111);
        Node<Integer> nextNode = new Node<>(999);
        Node<Integer> central = new Node<>(555, nextNode, previousNode);
        assertEquals(nextNode, central.getNext());
    }
    @Test
    public void node_createWithNeighbors_RealNextPointsToThis() {
        Node<Integer> previousNode = new Node<>(111);
        Node<Integer> nextNode = new Node<>(999);
        Node<Integer> central = new Node<>(555, nextNode, previousNode);
        assertEquals(central, central.getNext().getPrev());
    }
    @Test
    public void node_createWithNeighbors_RealPrevPointsToThis() {
        Node<Integer> previousNode = new Node<>(111);
        Node<Integer> nextNode = new Node<>(999);
        Node<Integer> central = new Node<>(555, nextNode, previousNode);
        assertEquals(central, central.getPrev().getNext());
    }
    @Test
    public void node_setData_getsSetData() {
        Node<String> node = new Node<>("");
        node.setData("new data");
        assertEquals("new data", node.getData());
    }
    @Test
    public void node_create_getData() {
        Node<String> node = new Node<>("data");
        assertEquals("data", node.getData());
    }

    //
    // Dummy Node tests
    //
    @Test
    public void dummyNode_create_prevPointsToThis() {
        DummyNode<Integer> node = new DummyNode<>();
        assertEquals(node, node.getPrev());
    }
    @Test
    public void dummyNode_create_nextPointsToThis() {
        DummyNode<Integer> node = new DummyNode<>();
        assertEquals(node, node.getNext());
    }

    //
    // DoubleLinkedList tests
    //

    @Test
    public void DLL_create_sizeEqualsZero() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(0, list.getSize());

    }
    @Test
    public void DLL_isEmpty_createdEmpty_equalsTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertTrue(list.isEmpty());
    }
    @Test
    public void DLL_isEmpty_addedNode_equalsFalse() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        assertFalse(list.isEmpty());
    }
    @Test
    public void DLL_pushBack_increasesSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        assertEquals(1, list.getSize());
    }
    @Test
    public void DLL_getHead_afterInsertingTwoElements_headIsCorrect() {
        //pushfront adds elements to the beginning (head), pushback - to the end (tail).
        // so, it should create a [10 - 30] list.
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(30);
        Node<Integer> head = (Node<Integer>) list.getHead();
        assertEquals((Integer) 10, head.getData());

    }
    @Test
    public void DLL_getTail_afterInsertingTwoElements_tailIsCorrect() {
        //pushfront adds elements to the beginning (head), pushback - to the end (tail).
        // so, it should create a [10 - 30] list.
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(30);
        Node<Integer> tail = (Node<Integer>) list.getTail();
        assertEquals((Integer) 30, tail.getData());

    }
    @Test
    public void DLL_pushBack_addsElementsInCorrectOrder() {
        //pushfront adds elements to the beginning (head), pushback - to the end (tail).
        // so, it should create a [10 - 20 - 30] list.
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        Node<Integer> head = (Node<Integer>) list.getHead();
        Node<Integer> tail = (Node<Integer>) list.getTail();
        assertEquals((Integer) 10, head.getData());
        assertEquals((Integer) 30, tail.getData());
    }
    @Test
    public void DLL_pushFront_increasesSize() {
        //pushfront adds elements to the beginning (head), pushback - to the end (tail).
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        assertEquals(1, list.getSize());
    }
    @Test
    public void DLL_pushFront_addsElementsInCorrectOrder() {
        //pushfront adds elements to the beginning (head), pushback - to the end (tail).
        // creates a [30 - 20 - 10] list, by idea.
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        list.pushFront(20);
        list.pushFront(30);
        Node<Integer> head = (Node<Integer>) list.getHead();
        Node<Integer> tail = (Node<Integer>) list.getTail();
        assertEquals((Integer) 10, tail.getData());
        assertEquals((Integer) 30, head.getData());
    }
    @Test
    public void DLL_insertAfter_increasesSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertAfter(list.getHead(), 999);
        assertEquals(1, list.getSize());
    }
    @Test
    public void DLL_insertAfter_addsData() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertAfter(list.getHead(), 999);
        Node<Integer> last = (Node<Integer>) list.getTail();
        assertEquals( (Integer) 999, last.getData());
    }
    @Test
    public void DLL_insertAfter_insertsAfterSpecified() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertAfter(list.getHead(), 999);
        list.insertAfter(list.getHead(), 111);
        Node<Integer> last = (Node<Integer>) list.getTail();
        assertEquals((Integer) 111, last.getData());
    }
    @Test
    public void DLL_insertBefore_increasesSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertBefore(list.getHead(), 999);
        assertEquals(1, list.getSize());
    }
    @Test
    public void DLL_insertBefore_addsData() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertBefore(list.getHead(), 999);
        Node<Integer> last = (Node<Integer>) list.getTail();
        assertEquals( (Integer) 999, last.getData());
    }
    @Test
    public void DLL_insertBefore_insertsBeforeSpecified() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insertBefore(list.getHead(), 999);
        list.insertBefore(list.getHead(), 111);
        Node<Integer> first = (Node<Integer>) list.getHead();
        assertEquals((Integer) 111, first.getData());
    }
    @Test
    public void DLL_remove_head_setsNextElementAsHead() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        list.remove(list.getHead());
        Node<Integer> head = (Node<Integer>) list.getHead();
        assertEquals((Integer) 20, head.getData());
    }
    @Test
    public void DLL_remove_tail_setsNextElementAsTail() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        list.remove(list.getTail());
        Node<Integer> tail = (Node<Integer>) list.getTail();
        assertEquals((Integer) 20, tail.getData());
    }
    @Test
    public void DLL_remove_decreasesSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        list.remove(list.getHead());
        assertEquals(0, list.getSize());
    }
    @Test
    public void DLL_remove_middle_setsNextElementInPlace() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        list.remove(list.getHead().getNext());
        Node<Integer> middle = (Node<Integer>) list.getTail();
        assertEquals((Integer) 30, middle.getData());
    }
    @Test
    public void DLL_get_returnsElementsInCorrectOrder() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        list.pushBack(40);
        for (int i = 0; i < list.getSize(); i++) {
            Node<Integer> current = (Node<Integer>) list.get(i);
            assertEquals((Integer) (10 * (i + 1)), current.getData());
        }

    }
    @Test
    public void DLL_get_fromEmpty_raisesException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertEquals("index out of bounds", ex.getMessage());
    }
    @Test
    public void DLL_get_FromIndexEqualToSize_raisesException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }
    @Test
    public void DLL_get_fromOneSize_successful() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        Node<Integer> element = (Node<Integer>) list.get(0);
        assertEquals((Integer) 10, element.getData());
    }
/*    @Test
    public void DLL_insertListAfter_increasesSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        list.pushFront(20);
        list.pushFront(30);
        DoubleLinkedList<Integer> additional = new DoubleLinkedList<>();
        additional.pushFront(40);
        additional.pushFront(50);
        additional.pushFront(60);
        list.insertListAfter(list.getTail(), additional);
        assertEquals(6, list.getSize());
    }*/
    @Test
    public void DLL_insertListAfter_tail_goingToTail_correctOrder() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        DoubleLinkedList<Integer> additional = new DoubleLinkedList<>();
        additional.pushBack(40);
        additional.pushBack(50);
        additional.pushBack(60);
        list.insertListAfter(list.getTail(), additional);
        for (int i = 0; i < list.getSize(); i++) {
            Node<Integer> current = (Node<Integer>) list.get(i);
            assertEquals((Integer) (10 * (i + 1)), current.getData());
        }
    }
    @Test
    public void DLL_insertListAfter_tail_goingToHead_correctOrder() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        DoubleLinkedList<Integer> additional = new DoubleLinkedList<>();
        additional.pushBack(40);
        additional.pushBack(50);
        additional.pushBack(60);
        list.insertListAfter(list.getTail(), additional);
        Node<Integer> current = (Node<Integer>) list.getTail();
        assertEquals((Integer) 60, current.getData());
        for (int i = 5; i >= 1; i--) {
            current = (Node<Integer>) current.getPrev();
            assertEquals((Integer) (10 * i), current.getData());
        }
    }
    @Test
    public void DLL_insertListAfter_head_goingToTail_correctOrder() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(50);
        list.pushBack(60);
        DoubleLinkedList<Integer> additional = new DoubleLinkedList<>();
        additional.pushBack(20);
        additional.pushBack(30);
        additional.pushBack(40);
        list.insertListAfter(list.getHead(), additional);
        for (int i = 0; i < list.getSize(); i++) {
            Node<Integer> current = (Node<Integer>) list.get(i);
            assertEquals((Integer) (10 * (i + 1)), current.getData());
        }
    }
    @Test
    public void DLL_insertListAfter_head_goingToHead_correctOrder() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(50);
        list.pushBack(60);
        DoubleLinkedList<Integer> additional = new DoubleLinkedList<>();
        additional.pushBack(20);
        additional.pushBack(30);
        additional.pushBack(40);
        list.insertListAfter(list.getHead(), additional);
        Node<Integer> current = (Node<Integer>) list.getTail();
        assertEquals((Integer) 60, current.getData());
        for (int i = 5; i >= 1; i--) {
            current = (Node<Integer>) current.getPrev();
            assertEquals((Integer) (10 * i), current.getData());
        }
    }
    @Test
    public void DLL_insertListBefore_head_goingToTail_correctOrder() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(40);
        list.pushBack(50);
        list.pushBack(60);
        DoubleLinkedList<Integer> additional = new DoubleLinkedList<>();
        additional.pushBack(10);
        additional.pushBack(20);
        additional.pushBack(30);
        list.insertListBefore(list.getHead(), additional);
        for (int i = 0; i < list.getSize(); i++) {
            Node<Integer> current = (Node<Integer>) list.get(i);
            assertEquals((Integer) (10 * (i + 1)), current.getData());
        }
    }
    @Test
    public void DLL_insertListBefore_head_goingToHead_correctOrder() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(40);
        list.pushBack(50);
        list.pushBack(60);
        DoubleLinkedList<Integer> additional = new DoubleLinkedList<>();
        additional.pushBack(10);
        additional.pushBack(20);
        additional.pushBack(30);
        list.insertListBefore(list.getHead(), additional);
        Node<Integer> current = (Node<Integer>) list.getTail();
        assertEquals((Integer) 60, current.getData());
        for (int i = 5; i >= 1; i--) {
            current = (Node<Integer>) current.getPrev();
            assertEquals((Integer) (10 * i), current.getData());
        }
    }
    @Test
    public void DLL_insertListBefore_increasesSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        list.pushFront(20);
        list.pushFront(30);
        DoubleLinkedList<Integer> additional = new DoubleLinkedList<>();
        additional.pushFront(40);
        additional.pushFront(50);
        additional.pushFront(60);
        list.insertListBefore(list.getTail(), additional);
        assertEquals(6, list.getSize());
    }
    @Test
    public void DLL_insertListAfter_increasesSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        list.pushFront(20);
        list.pushFront(30);
        DoubleLinkedList<Integer> additional = new DoubleLinkedList<>();
        additional.pushFront(40);
        additional.pushFront(50);
        additional.pushFront(60);
        list.insertListAfter(list.getTail(), additional);
        assertEquals(6, list.getSize());
    }
    @Test
    public void DLL_insertListBefore_tail_goingToTail_correctOrder() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(60);
        DoubleLinkedList<Integer> additional = new DoubleLinkedList<>();
        additional.pushBack(30);
        additional.pushBack(40);
        additional.pushBack(50);
        list.insertListBefore(list.getTail(), additional);
        for (int i = 0; i < list.getSize(); i++) {
            Node<Integer> current = (Node<Integer>) list.get(i);
            assertEquals((Integer) (10 * (i + 1)), current.getData());
        }
    }
    @Test
    public void DLL_insertListBefore_tail_goingToHead_correctOrder() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(60);
        DoubleLinkedList<Integer> additional = new DoubleLinkedList<>();
        additional.pushBack(30);
        additional.pushBack(40);
        additional.pushBack(50);
        list.insertListBefore(list.getTail(), additional);
        Node<Integer> current = (Node<Integer>) list.getTail();
        assertEquals((Integer) 60, current.getData());
        for (int i = 5; i >= 1; i--) {
            current = (Node<Integer>) current.getPrev();
            assertEquals((Integer) (10 * i), current.getData());
        }
    }
}
