public class Task_2 implements Task_2_base {
    @Override
    public int subtask_1_while(int num) {
        // Найти максимальное число, являющееся полным квадратом,
        // не превосходящее заданное натуральное num
        int minPower = 0;
        while (minPower * minPower <= num) {
            int nextPower = minPower + 1;
            if ((nextPower * nextPower) > num) return minPower * minPower;
            minPower++;
        }
        return 0;
    }

    @Override
    public int subtask_2_while(int num) {
        // Последовательность целых чисел p(n) определяется следующим образом:
        // p(0) = 1
        // p(k) = 2 * p(k - 1) + 6, k > 0
        //Найти элемент последовательности с номером num.
        int i = 0; int p = 1;

        while (i < num) {
            p = 2 * p + 6;
            i++;
        }
        return p;
    }

    @Override
    public boolean subtask_3_while(int num, int base) {
        // Проверить, является ли число num натуральной степенью числа base. So, is num = base ^ prime?
        int prime = 1;
        while (Math.pow(base, prime) <= num) {
            if (Math.pow(base, prime) == num) return true;
            prime++;
        }
        return false;
    }

    @Override
    public int subtask_4_while(int start, int end) {
        // Вычислить, за какое минимальное число операций
        // вычесть 1 ( -1 )
        // поделить на 2 ( /2 )
        // число start можно превратить в end. Гарантируется, что start >= end >= 1.
        double margin = 0.00001;
        int count = 0;
        while (start > end) {
            if ((start % 2 <= margin) && (start / 2 >= end)) start /= 2;
            else start--;
            count++;
        }
        return count;
    }
}
