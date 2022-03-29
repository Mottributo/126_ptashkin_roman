import org.junit.*;
public class Task1_Tests extends Assert {

    // DynArray is a form of array organization.
    // popBack and pushBack work with the end of the DynArray.
    //
    // What should DynArray do without issues?
    //
    // Create DynArray with default size,
    // Create DynArray with custom size,
    // set, return and remove the element,
    // set, return and remove the element with index 0,
    // set, return and remove the element with the index of the latest DynArray cell,
    // insert an element, and thus shift other elements properly, increasing size,
    // insert an element into the end, insert an element into the beginning,
    // resize the list to bigger or smaller size, losing the information if it's decreased,
    // pushBack an element onto the end, increasing size,
    // popBack an element from the end, returning it as the result,
    // get proper size after all the possible manipulations.
    //
    // Where should DynArray throw an exception?
    //
    // Create DynArray with wrong size,
    // set, return or remove an element with an index higher than size,
    // set, return or remove an element with an index lower than 0,
    // insert an element into the wrong index,
    // resize to lower than 0,
    // pop in the empty DynArray.

    @Test
    public void createEmptyDynamicArray_sizeEquals1() {
        DynamicArray<Object> dyna = new DynamicArray<>();
        Assert.assertEquals(1, dyna.getSize());
        Assert.assertNull(dyna.get(0));
    }
    @Test
    public void setElements_returnProperValue() {
        DynamicArray<Object> dyna = new DynamicArray<>(4);
        dyna.set(0, "data");
        dyna.set(1, "data1");
        dyna.set(2, "data2");
        Assert.assertEquals("data", dyna.get(0));
        Assert.assertEquals("data1", dyna.get(1));
        Assert.assertEquals("data2", dyna.get(2));
        Assert.assertEquals(null, dyna.get(3));
    }
    @Test
    public void setElements_removingElements_returnsProperSize() {
        DynamicArray<Object> dyna = new DynamicArray<>(4);
        dyna.set(0, "data");
        dyna.set(1, "data1");
        dyna.set(2, "data2");
        dyna.set(3, "data3");
        Assert.assertEquals(4, dyna.getSize());
        dyna.remove(1);
        Assert.assertEquals(3, dyna.getSize());
        dyna.remove(2);
        Assert.assertEquals(2, dyna.getSize());
        dyna.remove(1);
        Assert.assertEquals(1, dyna.getSize());
        dyna.remove(0);
        Assert.assertEquals(0, dyna.getSize());
    }
    @Test
    public void setElements_resize_returnsProperSize_elementsAreLost() {
        DynamicArray<Object> dyna = new DynamicArray<>(4);
        dyna.set(0, "data");
        dyna.set(1, "data1");
        dyna.set(2, "data2");
        dyna.set(3, "data3");
        dyna.resize(9);
        Assert.assertEquals(9, dyna.getSize());
        dyna.resize(2);
        Assert.assertEquals(2, dyna.getSize());
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.get(2));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.get(3));
    }
    @Test
    public void setGetRemoveElement_withIndex0_successful() {
        DynamicArray<Object> dyna = new DynamicArray<>();
        dyna.set(0, "data");
        Assert.assertEquals("data", dyna.get(0));
        dyna.remove(0);
    }
    @Test
    public void resizeArrayTo0_successful() {
        DynamicArray<Object> dyna = new DynamicArray<>();
        Assert.assertNull(dyna.get(0));
        dyna.resize(0);
        Assert.assertEquals(0, dyna.getSize());
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.get(0));
    }
    @Test
    public void pushBackElement_withLastIndex_successful() {
        DynamicArray<String> dyna = new DynamicArray<>(1337);
        dyna.pushBack("data");
        Assert.assertEquals("data", dyna.get(1337));

    }
    @Test
    public void pushBackRemoveElement_withLastIndex_successful() {
        DynamicArray<String> dyna = new DynamicArray<>(1337);
        dyna.pushBack( "data");
        dyna.remove(1337);
        Assert.assertEquals(1337, dyna.getSize());
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.get(1337));

    }
    @Test
    public void insertElement_updatesSize_shiftsCorrectly() {
        DynamicArray<String> dyna = new DynamicArray<>();
        dyna.insert(dyna.getSize() - 1, "data0");
        dyna.insert(dyna.getSize() - 1, "data1");
        dyna.insert(dyna.getSize() - 1, "data2");
        Assert.assertEquals(4, dyna.getSize());
        Assert.assertEquals("data0", dyna.get(0));
        Assert.assertEquals("data1", dyna.get(1));
        Assert.assertEquals("data2", dyna.get(2));
        Assert.assertEquals(null, dyna.get(3));
        dyna.insert(0, "begin");
        dyna.insert(3, "middle");
        Assert.assertEquals("begin", dyna.get(0));
        Assert.assertEquals("middle", dyna.get(3));
        Assert.assertEquals("data0", dyna.get(1));
        Assert.assertEquals(null, dyna.get(5));

    }
    @Test
    public void pushBack_changesSize_addsElementToTheEnd() {
        DynamicArray<String> dyna = new DynamicArray<>();
        dyna.pushBack("stuff");
        dyna.pushBack(" is");
        dyna.pushBack(" weird");
        dyna.pushBack(", really");
        Assert.assertEquals(null, dyna.get(0));
        Assert.assertEquals("stuff", dyna.get(1));
        Assert.assertEquals(" is", dyna.get(2));
        Assert.assertEquals(" weird", dyna.get(3));
        Assert.assertEquals(", really", dyna.get(4));
        Assert.assertEquals(5, dyna.getSize());
    }
    @Test
    public void set_popBackElement_decreasesSize_makesInaccessible() {
        DynamicArray<String> dyna = new DynamicArray<>(2);
        dyna.set(0, "stuff");
        dyna.set(1, " is");
        dyna.popBack();
        dyna.popBack();
        Assert.assertEquals(0, dyna.getSize());
    }
    @Test
    public void insertElement_intoTail_successful() {
        DynamicArray<String> dyna = new DynamicArray<>(2);
        dyna.set(0, "stuff");
        dyna.set(1, " is");
        dyna.insert(1, "middle");
    }

    @Test
    public void create_DynArrayWithNegativeSize_raiseException() {
        Assert.assertThrows(NegativeArraySizeException.class, () -> new DynamicArray<>(-1));
    }
    @Test
    public void popBackInTheEmptyArray_raisesException() {
        DynamicArray<Object> dyna = new DynamicArray<>(0);
        Assert.assertThrows(UnsupportedOperationException.class, () ->dyna.popBack());
    }
    @Test
    public void resizeToNegativeSize_raisesException() {
        DynamicArray<Object> dyna = new DynamicArray<>();
        Assert.assertThrows(NegativeArraySizeException.class, () -> dyna.resize(-1));
    }
    @Test
    public void insertElementIntoNegativeIndex_raisesException() {
        DynamicArray<String> dyna = new DynamicArray<>();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.insert(-1, "DATA_CORRUPTED"));
    }
    @Test
    public void insertElementWithIndexHigherThanSize_raisesException() {
        DynamicArray<String> dyna = new DynamicArray<>();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.insert(1, "DATA_CORRUPTED"));
    }
    @Test
    public void setElement_withIndexHigherThanSize_raisesException() {
        DynamicArray<String> dyna = new DynamicArray<>(1000);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.set(1000, "DATA_CORRUPTED"));
    }
    @Test
    public void removeElement_withNegativeIndex_raisesException() {
        DynamicArray<Object> dyna = new DynamicArray<>();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.remove(-1));
    }
    @Test
    public void removeElement_withIndexHigherThanSize_raisesException() {
        DynamicArray<Object> dyna = new DynamicArray<>();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.remove(1));
    }
    @Test
    public void getElement_WithIndexHigherThanSize_raisesException() {
        DynamicArray<Object> dyna = new DynamicArray<>();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.get(1));
    }
    @Test
    public void getElement_withNegativeIndex_raisesException() {
        DynamicArray<Object> dyna = new DynamicArray<>();

        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.get(-1));
    }

    // DoubleLinkedList is another form of array organization, not bound to memory cells.
    // Each cell has links to the next and the previous cell.
    // It has a head (beginning) and tail (end).
    //
    // What should DLL do without issues?
    // Be created, with 0 size, with 0 content. Head and tail return the same no-cell.
    // Return True on being empty, empty after losing its latest element and False in all other cases.
    // Return proper size after adding elements and removing them.
    // Return proper head and proper tail, for lists with length 0, 1, 2 and more.
    // Return elements with index 0, length-1 and in between.
    // insertAfter adds a new node with the data provided after the specified one, increasing size.
    // insertBefore adds a new node with the data provided, BEFORE the specified one, increasing size.
    // pushBack adds an element before the beginning - head, increasing size.
    // pushFront adds an element after the end - tail, increasing size.
    // removal unbinds the node specified from the DLL, decreasing size.
    // insertListAfter adds a new node sequence (another DLL) after the specified node,
    // increasing size by the size of the list.
    // same does insertListBefore, but well, before.
    //
    // Throws an exception when:
    // attempt to remove the dummy,
    // try to get a node with a negative index or index => size;
    // trying to remove the dummy node by removing head or tail of a 0-sized DLL.

    @Test
    public void createEmptyDLL_sizeEquals0() {
        DoubleLinkedList<Object> dll = new DoubleLinkedList<>();
        Assert.assertEquals(0, dll.getSize());
    }
    @Test
    public void createEmptyDLL_isEmpty() {
        DoubleLinkedList<Object> dll = new DoubleLinkedList<>();
        Assert.assertEquals(true, dll.isEmpty());
    }
    @Test
    public void createEmptyDLL_headAndTailAreTheSame() {
        DoubleLinkedList<Object> dll = new DoubleLinkedList<>();
        Assert.assertEquals(dll.getHead(), dll.getTail());
    }
    @Test
    public void createDLL_removeElement_isEmpty() {
        DoubleLinkedList<String> dll = new DoubleLinkedList<>();
        dll.pushBack("some element");
        dll.remove(dll.getHead());
        Assert.assertEquals(true, dll.isEmpty());
    }
    @Test
    public void createDLL_addElement_isNotEmpty() {
        DoubleLinkedList<String> dll = new DoubleLinkedList<>();
        dll.pushBack("some element");
        Assert.assertEquals(false, dll.isEmpty());
    }
    @Test
    public void DLL_pushBack_sizeIsCorrect_CorrectPosition() {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.pushBack(333);
        dll.pushBack(222);
        dll.pushBack(111);
        Assert.assertEquals(3, dll.getSize());
        Assert.assertEquals(111, dll.get(0));
        Assert.assertEquals(222, dll.get(1));
        Assert.assertEquals(333, dll.get(2));
    }
    @Test
    public void DLL_removeElement_sizeIsCorrect_correctPositioning() {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.pushBack(333);
        dll.pushBack(222);
        dll.pushBack(111);

        dll.remove(dll.get(1));
        Assert.assertEquals(333, dll.get(0));
        Assert.assertEquals(111, dll.get(1));
        Assert.assertEquals(2, dll.getSize());

        dll.remove(dll.get(1));
        Assert.assertEquals(333, dll.get(0));
        Assert.assertEquals(1, dll.getSize());

        dll.remove(dll.get(0));
        Assert.assertEquals(true, dll.isEmpty());
    }

    @Test
    public void DLL_addElement_headAndTailAreTheSame() {
        DoubleLinkedList<Object> dll = new DoubleLinkedList<>();
        dll.pushBack(1337);
        Assert.assertEquals(dll.getTail(), dll.getHead());
    }
    @Test
    public void DLL_returnElement_withIndex0() {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.pushBack(111);
        dll.pushBack(222);
        dll.pushBack(333);
        Assert.assertEquals(111, dll.get(0));
    }
    @Test
    public void DLL_returnElement_withTheLastIndex() {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.pushBack(111);
        dll.pushBack(222);
        dll.pushBack(333);
        Assert.assertEquals(333, dll.get(2));
    }
    @Test
    public void DLL_pushFront_increasesSize_correctPositioning() {
        DoubleLinkedList<String> dll = new DoubleLinkedList<>();
        dll.pushFront("111");
        dll.pushFront("222");
        dll.pushFront("333");
        Assert.assertEquals("111", dll.get(0));
        Assert.assertEquals("222", dll.get(1));
        Assert.assertEquals("333",dll.get(2));
        Assert.assertEquals(3, dll.getSize());

    }
    @Test
    public void DLL_insertListAfterHead_correctOrder_correctSize() {
        DoubleLinkedList<String> dll0 = new DoubleLinkedList<>();
        dll0.pushFront("111");
        dll0.pushFront("222");
        dll0.pushFront("333");

        DoubleLinkedList<String> dll1 = new DoubleLinkedList<>();
        dll1.pushFront("aaa");
        dll1.pushFront("bbb");
        dll1.pushFront("ccc");

        dll0.insertListAfter(dll0.getHead(), dll1);
        Assert.assertEquals(6, dll0.getSize());
        Assert.assertEquals("111", dll0.get(0));
        Assert.assertEquals("aaa", dll0.get(1));
        Assert.assertEquals("bbb", dll0.get(2));
        Assert.assertEquals("ccc", dll0.get(3));
        Assert.assertEquals("222", dll0.get(4));
        Assert.assertEquals("333", dll0.get(5));
    }
    @Test
    public void DLL_insertListBeforeTail_correctOrder_correctSize() {
        DoubleLinkedList<String> dll0 = new DoubleLinkedList<>();
        dll0.pushFront("111");
        dll0.pushFront("222");
        dll0.pushFront("333");

        DoubleLinkedList<String> dll1 = new DoubleLinkedList<>();
        dll1.pushFront("aaa");
        dll1.pushFront("bbb");
        dll1.pushFront("ccc");

        dll0.insertListBefore(dll0.getTail(), dll1);
        Assert.assertEquals(6, dll0.getSize());
        Assert.assertEquals("111", dll0.get(0));
        Assert.assertEquals("222", dll0.get(1));
        Assert.assertEquals("aaa", dll0.get(2));
        Assert.assertEquals("bbb", dll0.get(3));
        Assert.assertEquals("ccc", dll0.get(4));
        Assert.assertEquals("333", dll0.get(5));
    }
    @Test
    public void DLL_getElement_withNegativeIndex_raisesException() {
        DoubleLinkedList<String> dll = new DoubleLinkedList<>();
        dll.pushBack("data");
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dll.get(-1));
    }
    @Test
    public void DLL_getElement_withIndexHigherThanSize_raisesException() {
        DoubleLinkedList<String> dll = new DoubleLinkedList<>();
        dll.pushBack("data");
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dll.get(2));
    }
    @Test
    public void DLL_getElement_withIndexEqualToSize_raisesException() {
        DoubleLinkedList<String> dll = new DoubleLinkedList<>();
        dll.pushBack("data");
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dll.get(1));
    }

}
