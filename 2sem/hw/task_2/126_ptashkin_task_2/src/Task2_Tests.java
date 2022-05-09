import org.junit.Assert;
import org.junit.Test;

public class Task2_Tests extends Assert {

    class compareInt implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }
    @Test
    public void BS_insertEmpty_returnsSame() {
        Integer[] inserted = {};
        Integer[] assumed = {};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertUnary_returnsSame() {
        Integer[] inserted = {10};
        Integer[] assumed = {10};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertSorted_ofLength2_returnsSame() {
        Integer[] inserted = {145, 235};
        Integer[] assumed = {145, 235};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertHomogenic_ofLength3_returnsSame() {
        Integer[] inserted = {100, 100, 100};
        Integer[] assumed = {100, 100, 100};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertReversed_ofLength2_returnsSorted() {
        Integer[] inserted = {23534, 145};
        Integer[] assumed = {145, 23534};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertReversed_ofLength2_withNegatives_returnsSorted() {
        Integer[] inserted = {46, -12};
        Integer[] assumed = {-12, 46};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertReversed_ofLength2_allNegatives_returnsSorted() {
        Integer[] inserted = {-1, -10};
        Integer[] assumed = {-10, -1};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertSorted_ofLength3_returnsSame() {
        Integer[] inserted = {11, 45, 543};
        Integer[] assumed = {11, 45, 543};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertReversed_ofLength3_beginningExceptional_returnsSorted() {
        Integer[] inserted = {10, 1, 1};
        Integer[] assumed = {1, 1, 10};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertReversed_ofLength3_middleExceptional_returnsSorted() {
        Integer[] inserted = {1, 10, 1};
        Integer[] assumed = {1, 1, 10};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertReversed_ofLength3_returnsSorted() {
        Integer[] inserted = {194, 52, 10};
        Integer[] assumed = {10, 52, 194};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertRandom_ofLength3_returnsSorted() {
        Integer[] inserted = {8000, 1, 45};
        Integer[] assumed = {1, 45, 8000};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertReversed_ofLength3_withNegatives_returnsSorted() {
        Integer[] inserted = {-1, -800, 45};
        Integer[] assumed = {-800, -1, 45};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertReversed_ofLength3_allNegatives_returnsSorted() {
        Integer[] inserted = {-5, -87, -234};
        Integer[] assumed = {-234, -87, -5};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertSorted_ofLength4_returnsSame() {
        Integer[] inserted = {123, 124, 125, 200};
        Integer[] assumed = {123, 124, 125, 200};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertReversed_ofLength4_returnsSorted() {
        Integer[] inserted = {200, 125, 124, 123};
        Integer[] assumed = {123, 124, 125, 200};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertRandom_ofLength4_returnsSorted() {
        Integer[] inserted = {123, 65, 900, 1};
        Integer[] assumed = {1, 65, 123, 900};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertRandom_ofLength4_withNegatives_returnsSorted() {
        Integer[] inserted = {-123, 65, -900, 1};
        Integer[] assumed = {-900, -123, 1, 65};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void BS_insertRandom_ofLength4_allNegatives_returnsSorted() {
        Integer[] inserted = {-123, -65, -900, -1};
        Integer[] assumed = {-900, -123, -65, -1};
        BubbleSort<Integer> sorter = new BubbleSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }

    // InsertionSort tests
    @Test
    public void IS_insertEmpty_returnsSame() {
        Integer[] inserted = {};
        Integer[] assumed = {};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertUnary_returnsSame() {
        Integer[] inserted = {10};
        Integer[] assumed = {10};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertSorted_ofLength2_returnsSame() {
        Integer[] inserted = {145, 235};
        Integer[] assumed = {145, 235};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertReversed_ofLength2_returnsSorted() {
        Integer[] inserted = {23534, 145};
        Integer[] assumed = {145, 23534};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertReversed_ofLength2_withNegatives_returnsSorted() {
        Integer[] inserted = {46, -12};
        Integer[] assumed = {-12, 46};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertReversed_ofLength2_allNegatives_returnsSorted() {
        Integer[] inserted = {-1, -10};
        Integer[] assumed = {-10, -1};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertHomogenic_ofLength3_returnsSame() {
        Integer[] inserted = {100, 100, 100};
        Integer[] assumed = {100, 100, 100};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertSorted_ofLength3_returnsSame() {
        Integer[] inserted = {11, 45, 543};
        Integer[] assumed = {11, 45, 543};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertReversed_ofLength3_beginningExceptional_returnsSorted() {
        Integer[] inserted = {10, 1, 1};
        Integer[] assumed = {1, 1, 10};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertReversed_ofLength3_middleExceptional_returnsSorted() {
        Integer[] inserted = {1, 10, 1};
        Integer[] assumed = {1, 1, 10};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertReversed_ofLength3_returnsSorted() {
        Integer[] inserted = {194, 52, 10};
        Integer[] assumed = {10, 52, 194};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertRandom_ofLength3_returnsSorted() {
        Integer[] inserted = {8000, 1, 45};
        Integer[] assumed = {1, 45, 8000};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertReversed_ofLength3_withNegatives_returnsSorted() {
        Integer[] inserted = {-1, -800, 45};
        Integer[] assumed = {-800, -1, 45};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertReversed_ofLength3_allNegatives_returnsSorted() {
        Integer[] inserted = {-5, -87, -234};
        Integer[] assumed = {-234, -87, -5};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertSorted_ofLength4_returnsSame() {
        Integer[] inserted = {123, 124, 125, 200};
        Integer[] assumed = {123, 124, 125, 200};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertReversed_ofLength4_returnsSorted() {
        Integer[] inserted = {200, 125, 124, 123};
        Integer[] assumed = {123, 124, 125, 200};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertRandom_ofLength4_returnsSorted() {
        Integer[] inserted = {123, 65, 900, 1};
        Integer[] assumed = {1, 65, 123, 900};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertRandom_ofLength4_withNegatives_returnsSorted() {
        Integer[] inserted = {-123, 65, -900, 1};
        Integer[] assumed = {-900, -123, 1, 65};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void IS_insertRandom_ofLength4_allNegatives_returnsSorted() {
        Integer[] inserted = {-123, -65, -900, -1};
        Integer[] assumed = {-900, -123, -65, -1};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    
    // Selection Sort

    @Test
    public void SS_insertEmpty_returnsSame() {
        Integer[] inserted = {};
        Integer[] assumed = {};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertUnary_returnsSame() {
        Integer[] inserted = {10};
        Integer[] assumed = {10};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertSorted_ofLength2_returnsSame() {
        Integer[] inserted = {145, 235};
        Integer[] assumed = {145, 235};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength2_returnsSorted() {
        Integer[] inserted = {23534, 145};
        Integer[] assumed = {145, 23534};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength2_withNegatives_returnsSorted() {
        Integer[] inserted = {46, -12};
        Integer[] assumed = {-12, 46};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength2_allNegatives_returnsSorted() {
        Integer[] inserted = {-1, -10};
        Integer[] assumed = {-10, -1};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertHomogenic_ofLength3_returnsSame() {
        Integer[] inserted = {100, 100, 100};
        Integer[] assumed = {100, 100, 100};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertSorted_ofLength3_returnsSame() {
        Integer[] inserted = {11, 45, 543};
        Integer[] assumed = {11, 45, 543};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength3_beginningExceptional_returnsSorted() {
        Integer[] inserted = {10, 1, 1};
        Integer[] assumed = {1, 1, 10};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength3_beginningNegativeExceptional_returnsSorted() {
        Integer[] inserted = {-10, -15, -15};
        Integer[] assumed = {-15, -15, -10};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength3_middleExceptional_returnsSorted() {
        Integer[] inserted = {1, 10, 1};
        Integer[] assumed = {1, 1, 10};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength3_middleNegativeExceptional_returnsSorted() {
        Integer[] inserted = {1, -10, 1};
        Integer[] assumed = {-10, 1, 1};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength3_endExceptional_returnsSorted() {
        Integer[] inserted = {10, 10, 1};
        Integer[] assumed = {1, 10, 10};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertHomogenic_ofLength2_returnsSame() {
        Integer[] inserted = {0, 0};
        Integer[] assumed = {0, 0};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength3_returnsSorted() {
        Integer[] inserted = {194, 52, 10};
        Integer[] assumed = {10, 52, 194};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertRandom_ofLength3_returnsSorted() {
        Integer[] inserted = {8000, 1, 45};
        Integer[] assumed = {1, 45, 8000};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength3_withNegatives_returnsSorted() {
        Integer[] inserted = {-1, -800, 45};
        Integer[] assumed = {-800, -1, 45};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength3_allNegatives_returnsSorted() {
        Integer[] inserted = {-5, -87, -234};
        Integer[] assumed = {-234, -87, -5};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertSorted_ofLength4_returnsSame() {
        Integer[] inserted = {123, 124, 125, 200};
        Integer[] assumed = {123, 124, 125, 200};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertReversed_ofLength4_returnsSorted() {
        Integer[] inserted = {200, 125, 124, 123};
        Integer[] assumed = {123, 124, 125, 200};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertRandom_ofLength4_returnsSorted() {
        Integer[] inserted = {123, 65, 900, 1};
        Integer[] assumed = {1, 65, 123, 900};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertRandom_ofLength4_withNegatives_returnsSorted() {
        Integer[] inserted = {-123, 65, -900, 1};
        Integer[] assumed = {-900, -123, 1, 65};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void SS_insertRandom_ofLength4_allNegatives_returnsSorted() {
        Integer[] inserted = {-24, -100, -5, -15};
        Integer[] assumed = {-100, -24, -15, -5};
        SelectionSort<Integer> sorter = new SelectionSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
}
