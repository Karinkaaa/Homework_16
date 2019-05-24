import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListStreamDemo {
    public static void main(String[] args) {

        // сгенерировать 100 000 случайных чисел, сохранить в list, посчитать максимум, количество уникальных значений:

        int length = 100000;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            list.add(getRandomValue(100, 500));
        }

        System.out.println("LIST:\n");
        list.forEach(value -> System.out.print(value + "  "));

        System.out.println("\n\nMax value of list = " + list.stream().max(Integer::compareTo).get());
        System.out.println("Number the unique values = " + list.stream().distinct().count());

    }

    private static int getRandomValue(int minBound, int maxBound) {
        return new Random().nextInt(maxBound) - minBound;
    }
}
