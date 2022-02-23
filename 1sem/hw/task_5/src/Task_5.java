import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Task_5 implements Task_5_base {
    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int x = data.get(i);
            if ((x % k == 0) && (x % n != 0)) answer.add(x);
        }
        return answer;
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3
        ArrayList<Integer> answer = new ArrayList<>();
        // Sequence generator
        int count = 0;
        boolean f = false;
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                if (count == size) {f = true; break;}
                answer.add(i);
                count++;
            }
            if (count == size && f) break;
        }
        return answer;
    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите пересечение множеств s1 и s2
        s1.retainAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите объединение множеств s1 и s2
        s1.addAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите дополнение множества s1 до множества s2
        HashSet<Integer> united = new HashSet<>(s1);
        united.addAll(s2);
        united.removeAll(s1);
        return united;
    }

    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        HashSet<Integer> unique = new HashSet<>(s2);
        HashSet<Integer> intersection = new HashSet<>(s1);
        unique.addAll(s1);
        intersection.retainAll(s2);
        unique.removeAll(intersection);
        return unique;

    }

    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        HashMap<String,Double> answer = new HashMap<>();
        for(String i: data){
            answer.put(i, (double)Collections.frequency(data,i)*100/data.size());
        }
        return answer;
    }

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно.
        HashMap<String, Double> answers = new HashMap<>();
        answers.put("max", Collections.max(data));
        answers.put("min", Collections.min(data));
        double sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i);
        }
        answers.put("mean", sum / data.size());
        return answers;
    }
}
