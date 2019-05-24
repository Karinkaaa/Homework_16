import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadingJSONFiles {
    public static void main(String[] args) throws IOException {

        // считать файл в Map c помощью Jackson:

        Map<String, Number> map = new ObjectMapper().readValue(ReadingJSONFiles.class.getResourceAsStream(
                "text.json"), HashMap.class);

        System.out.println("MAP:\n");
        map.entrySet().forEach(System.out::println);


        // посчитать сумму значений из map:

        double sum = map.entrySet().stream().mapToDouble(element -> element.getValue().doubleValue()).sum();
        System.out.println("\nSum of values = " + sum);


        // с помощью collections stream преобразовать в новую Map, где все значения умножены на sum:

        Map<String, Number> newMap = map.entrySet().stream().collect(Collectors.toMap(
                entry -> entry.getKey(), entry -> entry.getValue().doubleValue() * sum));

        System.out.println("\n\nNEW MAP:\n");
        newMap.entrySet().forEach(System.out::println);


        // с помощью collections stream посчитать количество уникальных значений в мапе:

        newMap.put("property1", 1998.0);
        System.out.println("\nNumber of unique values = " + newMap.entrySet().stream().distinct().count());



        // создать текстовый JSON файл, считать его и вывести каждое свойство = значение:

        Map<String, Object> mapObjects = new ObjectMapper().readValue(ReadingJSONFiles.class.getResourceAsStream(
                "textObject.json"), HashMap.class);

        System.out.println("\n\nMAP OBJECTS:\n");
        mapObjects.entrySet().forEach(entry -> {
            System.out.println("Key: " + entry.getKey() + "\nValue: " + entry.getValue() + "\n");
        });
    }
}
