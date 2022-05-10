import org.junit.Assert;
import org.junit.Test;


public class Task3_Tests extends Assert {
    
    static class compareInt implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }
    
    // HeapSort tests
    
    @Test
    public void HS_insertEmpty_returnsSame() {
        Integer[] inserted = {};
        Integer[] assumed = {};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertUnary_returnsSame() {
        Integer[] inserted = {10};
        Integer[] assumed = {10};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertSorted_ofLength2_returnsSame() {
        Integer[] inserted = {145, 235};
        Integer[] assumed = {145, 235};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength2_returnsSorted() {
        Integer[] inserted = {23534, 145};
        Integer[] assumed = {145, 23534};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength2_withNegatives_returnsSorted() {
        Integer[] inserted = {46, -12};
        Integer[] assumed = {-12, 46};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength2_allNegatives_returnsSorted() {
        Integer[] inserted = {-1, -10};
        Integer[] assumed = {-10, -1};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertHomogenic_ofLength3_returnsSame() {
        Integer[] inserted = {100, 100, 100};
        Integer[] assumed = {100, 100, 100};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertSorted_ofLength3_returnsSame() {
        Integer[] inserted = {11, 45, 543};
        Integer[] assumed = {11, 45, 543};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength3_beginningExceptional_returnsSorted() {
        Integer[] inserted = {10, 1, 1};
        Integer[] assumed = {1, 1, 10};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertHeapified_ofLength7_returnsSorted() {
        Integer[] inserted = {-9, -9, 0, -8, 77, 3, 2};
        Integer[] assumed = {-9, -9, -8, 0, 2, 3, 77};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertHeapified_requiresOneSwap_ofLength5_returnsSorted() {
        Integer[] inserted = {2, 1, 6, 5, 7};
        Integer[] assumed = {1, 2, 5, 6, 7};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertHeapified_requiresTwoSwaps_ofLength5_returnsSorted() {
        Integer[] inserted = {2, 5, 6, 1, 7};
        Integer[] assumed = {1, 2, 5, 6, 7};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertRandom_ofLength6_returnsSorted() {
        Integer[] inserted = {5, 1, 3, 1, 1, 3};
        Integer[] assumed = {1, 1, 1, 3, 3, 5};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertRandom_ofLength8_returnsSorted() {
        Integer[] inserted = {5, 1, 2, 3, 1, 5, 5, 2};
        Integer[] assumed = {1, 1, 2, 2, 3, 5, 5, 5};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertUnheapified_ofLength6_returnsSorted() {
        Integer[] inserted = {90, 8, 7, -50, -4, 0};
        Integer[] assumed = {-50, -4, 0, 7, 8, 90};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength3_beginningNegativeExceptional_returnsSorted() {
        Integer[] inserted = {-10, -15, -15};
        Integer[] assumed = {-15, -15, -10};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength3_middleExceptional_returnsSorted() {
        Integer[] inserted = {1, 10, 1};
        Integer[] assumed = {1, 1, 10};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength3_middleNegativeExceptional_returnsSorted() {
        Integer[] inserted = {1, -10, 1};
        Integer[] assumed = {-10, 1, 1};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength3_endExceptional_returnsSorted() {
        Integer[] inserted = {10, 10, 1};
        Integer[] assumed = {1, 10, 10};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertHomogenic_ofLength2_returnsSame() {
        Integer[] inserted = {0, 0};
        Integer[] assumed = {0, 0};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength3_returnsSorted() {
        Integer[] inserted = {194, 52, 10};
        Integer[] assumed = {10, 52, 194};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertRandom_ofLength3_returnsSorted() {
        Integer[] inserted = {8000, 1, 45};
        Integer[] assumed = {1, 45, 8000};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength3_withNegatives_returnsSorted() {
        Integer[] inserted = {-1, -800, 45};
        Integer[] assumed = {-800, -1, 45};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength3_allNegatives_returnsSorted() {
        Integer[] inserted = {-5, -87, -234};
        Integer[] assumed = {-234, -87, -5};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertSorted_ofLength4_returnsSame() {
        Integer[] inserted = {123, 124, 125, 200};
        Integer[] assumed = {123, 124, 125, 200};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertReversed_ofLength4_returnsSorted() {
        Integer[] inserted = {200, 125, 124, 123};
        Integer[] assumed = {123, 124, 125, 200};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertRandom_ofLength4_returnsSorted() {
        Integer[] inserted = {123, 65, 900, 1};
        Integer[] assumed = {1, 65, 123, 900};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertRandom_ofLength4_withNegatives_returnsSorted() {
        Integer[] inserted = {-123, 65, -900, 1};
        Integer[] assumed = {-900, -123, 1, 65};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void HS_insertRandom_ofLength4_allNegatives_returnsSorted() {
        Integer[] inserted = {-24, -100, -5, -15};
        Integer[] assumed = {-100, -24, -15, -5};
        HeapSort<Integer> sorter = new HeapSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }

    // MergeSort tests

    @Test
    public void MS_insertUnary_returnsSame() {
        Integer[] inserted = {10};
        Integer[] assumed = {10};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertSorted_ofLength2_returnsSame() {
        Integer[] inserted = {145, 235};
        Integer[] assumed = {145, 235};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength2_returnsSorted() {
        Integer[] inserted = {23534, 145};
        Integer[] assumed = {145, 23534};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength2_withNegatives_returnsSorted() {
        Integer[] inserted = {46, -12};
        Integer[] assumed = {-12, 46};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength2_allNegatives_returnsSorted() {
        Integer[] inserted = {-1, -10};
        Integer[] assumed = {-10, -1};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertHomogenic_ofLength3_returnsSame() {
        Integer[] inserted = {100, 100, 100};
        Integer[] assumed = {100, 100, 100};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertSorted_ofLength3_returnsSame() {
        Integer[] inserted = {11, 45, 543};
        Integer[] assumed = {11, 45, 543};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength3_beginningExceptional_returnsSorted() {
        Integer[] inserted = {10, 1, 1};
        Integer[] assumed = {1, 1, 10};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength3_beginningNegativeExceptional_returnsSorted() {
        Integer[] inserted = {-10, -15, -15};
        Integer[] assumed = {-15, -15, -10};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength3_middleExceptional_returnsSorted() {
        Integer[] inserted = {1, 10, 1};
        Integer[] assumed = {1, 1, 10};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength3_middleNegativeExceptional_returnsSorted() {
        Integer[] inserted = {1, -10, 1};
        Integer[] assumed = {-10, 1, 1};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength3_endExceptional_returnsSorted() {
        Integer[] inserted = {10, 10, 1};
        Integer[] assumed = {1, 10, 10};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertHomogenic_ofLength2_returnsSame() {
        Integer[] inserted = {0, 0};
        Integer[] assumed = {0, 0};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength3_returnsSorted() {
        Integer[] inserted = {194, 52, 10};
        Integer[] assumed = {10, 52, 194};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertRandom_ofLength3_returnsSorted() {
        Integer[] inserted = {8000, 1, 45};
        Integer[] assumed = {1, 45, 8000};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength3_withNegatives_returnsSorted() {
        Integer[] inserted = {-1, -800, 45};
        Integer[] assumed = {-800, -1, 45};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength3_allNegatives_returnsSorted() {
        Integer[] inserted = {-5, -87, -234};
        Integer[] assumed = {-234, -87, -5};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertSorted_ofLength4_returnsSame() {
        Integer[] inserted = {123, 124, 125, 200};
        Integer[] assumed = {123, 124, 125, 200};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertReversed_ofLength4_returnsSorted() {
        Integer[] inserted = {200, 125, 124, 123};
        Integer[] assumed = {123, 124, 125, 200};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertRandom_ofLength4_returnsSorted() {
        Integer[] inserted = {123, 65, 900, 1};
        Integer[] assumed = {1, 65, 123, 900};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertRandom_ofLength4_withNegatives_returnsSorted() {
        Integer[] inserted = {-123, 65, -900, 1};
        Integer[] assumed = {-900, -123, 1, 65};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void MS_insertRandom_ofLength4_allNegatives_returnsSorted() {
        Integer[] inserted = {-24, -100, -5, -15};
        Integer[] assumed = {-100, -24, -15, -5};
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    
    // QuickSort tests

    @Test
    public void QS_insertEmpty_returnsSame() {
        Integer[] inserted = {};
        Integer[] assumed = {};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertUnary_returnsSame() {
        Integer[] inserted = {10};
        Integer[] assumed = {10};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertSorted_ofLength2_returnsSame() {
        Integer[] inserted = {145, 235};
        Integer[] assumed = {145, 235};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength2_returnsSorted() {
        Integer[] inserted = {23534, 145};
        Integer[] assumed = {145, 23534};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength2_withNegatives_returnsSorted() {
        Integer[] inserted = {46, -12};
        Integer[] assumed = {-12, 46};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength2_allNegatives_returnsSorted() {
        Integer[] inserted = {-1, -10};
        Integer[] assumed = {-10, -1};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertHomogenic_ofLength3_returnsSame() {
        Integer[] inserted = {100, 100, 100};
        Integer[] assumed = {100, 100, 100};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertSorted_ofLength3_returnsSame() {
        Integer[] inserted = {11, 45, 543};
        Integer[] assumed = {11, 45, 543};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength3_beginningExceptional_returnsSorted() {
        Integer[] inserted = {10, 1, 1};
        Integer[] assumed = {1, 1, 10};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength3_beginningNegativeExceptional_returnsSorted() {
        Integer[] inserted = {-10, -15, -15};
        Integer[] assumed = {-15, -15, -10};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength3_middleExceptional_returnsSorted() {
        Integer[] inserted = {1, 10, 1};
        Integer[] assumed = {1, 1, 10};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength3_middleNegativeExceptional_returnsSorted() {
        Integer[] inserted = {1, -10, 1};
        Integer[] assumed = {-10, 1, 1};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength3_endExceptional_returnsSorted() {
        Integer[] inserted = {10, 10, 1};
        Integer[] assumed = {1, 10, 10};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertHomogenic_ofLength2_returnsSame() {
        Integer[] inserted = {0, 0};
        Integer[] assumed = {0, 0};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength3_returnsSorted() {
        Integer[] inserted = {194, 52, 10};
        Integer[] assumed = {10, 52, 194};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertRandom_ofLength3_returnsSorted() {
        Integer[] inserted = {8000, 1, 45};
        Integer[] assumed = {1, 45, 8000};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength3_withNegatives_returnsSorted() {
        Integer[] inserted = {-1, -800, 45};
        Integer[] assumed = {-800, -1, 45};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength3_allNegatives_returnsSorted() {
        Integer[] inserted = {-5, -87, -234};
        Integer[] assumed = {-234, -87, -5};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertSorted_ofLength4_returnsSame() {
        Integer[] inserted = {123, 124, 125, 200};
        Integer[] assumed = {123, 124, 125, 200};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertReversed_ofLength4_returnsSorted() {
        Integer[] inserted = {200, 125, 124, 123};
        Integer[] assumed = {123, 124, 125, 200};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertRandom_ofLength4_returnsSorted() {
        Integer[] inserted = {123, 65, 900, 1};
        Integer[] assumed = {1, 65, 123, 900};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertRandom_ofLength4_withNegatives_returnsSorted() {
        Integer[] inserted = {-123, 65, -900, 1};
        Integer[] assumed = {-900, -123, 1, 65};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertRandom_ofLength4_allNegatives_returnsSorted() {
        Integer[] inserted = {-24, -100, -5, -15};
        Integer[] assumed = {-100, -24, -15, -5};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertRandom_ofLength6_returnsSorted() {
        Integer[] inserted = {5, 1, 3, 1, 1, 3};
        Integer[] assumed = {1, 1, 1, 3, 3, 5};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertRandom_ofLength8_returnsSorted() {
        Integer[] inserted = {5, 1, 2, 3, 1, 5, 5, 2};
        Integer[] assumed = {1, 1, 2, 2, 3, 5, 5, 5};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertHeapified_ofLength7_returnsSorted() {
        Integer[] inserted = {-9, -9, 0, -8, 77, 3, 2};
        Integer[] assumed = {-9, -9, -8, 0, 2, 3, 77};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertHeapified_requiresOneSwap_ofLength5_returnsSorted() {
        Integer[] inserted = {2, 1, 6, 5, 7};
        Integer[] assumed = {1, 2, 5, 6, 7};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
    @Test
    public void QS_insertHeapified_requiresTwoSwaps_ofLength5_returnsSorted() {
        Integer[] inserted = {2, 5, 6, 1, 7};
        Integer[] assumed = {1, 2, 5, 6, 7};
        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(inserted, new compareInt());
        assertArrayEquals(assumed, inserted);
    }
}
