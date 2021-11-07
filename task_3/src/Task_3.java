public class Task_3 implements Task_3_base {
    double margin = 0.000001;
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        if (n1 > n2) { n1 = n1 + n2; n2 = n1 - n2; n1 = n1 - n2; } // обмен значений.
        int count = 0;
        for (int i = n1; i <= n2; i++) {
            if ((i % a == 0) && (i % b != 0)) count++;
        }
        return count;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        // 1, 22, 333, 4444... nnn...nnn.
        String mainString = "";
        int leng = 10;
        for (int i = 0; i < leng; i++) {
            String temp = "";
            for (int j = 0; j < i; j++) {
                temp += i;
            }
            mainString += temp;
        }
        return  mainString.charAt(num - 1) - '0';
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности

        int[] list = new int[cnt];
        list[0] = num;
        int sum = 0;
        for (int i = 1; i < cnt; i++) {
            list[i] = list[i - 1] * d + 1;
        }
        for (int i = 0; i < cnt; i++) {
            sum += list[i];
        }
        return sum;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int multiply = 1;
            for (int j = 1; j <= i; j++) {
                multiply *= j;
            }
            sum += multiply;
        }
        return sum;
    }
}
