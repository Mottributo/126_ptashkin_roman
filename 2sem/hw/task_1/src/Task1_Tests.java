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
    public void addElements_returnProperValue() {
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
    public void addElements_removingElements_returnsProperSize() {
        DynamicArray<Object> dyna = new DynamicArray<>(4);
        dyna.set(0, "data");
        dyna.set(1, "data1");
        dyna.set(2, "data2");
        dyna.set(3, "data3");
        Assert.assertEquals(4, dyna.getSize());
        dyna.remove(1);
        Assert.assertEquals(3, dyna.getSize());
        dyna.remove(3);
        Assert.assertEquals(2, dyna.getSize());
        dyna.remove(2);
        Assert.assertEquals(1, dyna.getSize());
        dyna.remove(0);
        Assert.assertEquals(0, dyna.getSize());
    }
    @Test
    public void addElements_resize_returnsProperSize_elementsAreLost() {
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
    public void addGetRemoveElement_withIndex0_successful() {
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
    public void addElement_withLastIndex_successful() {
        DynamicArray<Object> dyna = new DynamicArray<>(1337);
        dyna.pushBack("data");
        Assert.assertEquals("data", dyna.get(1337));

    }
    @Test
    public void RemoveElement_withLastIndex_successful() {
        DynamicArray<Object> dyna = new DynamicArray<>(1337);
        dyna.pushBack( "data");
        dyna.remove(1337);
        Assert.assertEquals(1337, dyna.getSize());
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.get(1337));

    }
    @Test
    public void insertElements_updatesSize_shiftsCorrectly() {
        DynamicArray<Object> dyna = new DynamicArray<>();
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
        DynamicArray<Object> dyna = new DynamicArray<>();
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
    public void popBack_decreasesSize_makesInaccessible() {
        DynamicArray<Object> dyna = new DynamicArray<>(2);
        dyna.set(0, "stuff");
        dyna.set(1, " is");
        dyna.popBack();
        dyna.popBack();
        Assert.assertEquals(0, dyna.getSize());
    }

    @Test
    public void creatingDynArrayWithNegativeSize_raiseException() {
        Assert.assertThrows(NegativeArraySizeException.class, () -> new DynamicArray<>(-1));
    }
    @Test
    public void popInTheEmptyArray_raisesException() {
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
        DynamicArray<Object> dyna = new DynamicArray<>();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.insert(-1, "DATA_CORRUPTED"));
    }
    @Test
    public void insertElementWithIndexHigherThanSize_raisesException() {
        DynamicArray<Object> dyna = new DynamicArray<>();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> dyna.insert(1, "DATA_CORRUPTED"));
    }
    @Test
    public void addElement_withIndexHigherThanSize_raisesException() {
        DynamicArray<Object> dyna = new DynamicArray<>(1000);
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
    // Return True on being empty, empty after losing its latest element and True in all other cases.
    // return proper size after adding some elements and removing some.
    // return proper head and proper tail, for lists with length 0, 1, 2 and more.
    // return elements with index 0, length-1 and in between.
    // insertAfter adds a new node with the data provided after the specified one, increasing size.
    // insertBefore adds a new node with the data provided, BEFORE the specified one, increasing size.
    // pushBack adds an element before the beginning - head, increasing size.
    // pushBack adds an element after the end - tail, increasing size.
    // removal unbinds the node specified from the DLL, decreasing size.
    // insertListAfter adds a new node sequence (another DLL) after the specified node,
    // increasing size by the size of the list.
    // same does insertListBefore, but well, before.

    // Node is an element of the DoubleLinkedList.
    // has data, a link to the previous element and a link to the next element.
    // ListNode an interface realized by two elements, DummyNode and Node.
    // What should Node do without issues?
    // Change its value properly to any.
    //
}
