package main.test;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static List<Student> students;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        создание списка студентов
        students = new ArrayList<>();

//        заполнение данных о студентах
        Map<String, int[]> mark1 = new HashMap<String, int[]>();
        mark1.put("Математика", new int[]{2, 2, 2});
        mark1.put("Информатика", new int[]{2, 2, 2});
        mark1.put("Физика", new int[]{2, 2, 2});
        mark1.put("Философия", new int[]{4, 5, 5});
        mark1.put("Иностранный язык", new int[]{3, 4, 3});
        mark1.put("История", new int[]{3, 2, 5});
        Student student1 = new Student("Иван Иванов", "0033", 1, mark1);

        Map<String, int[]> mark2 = new HashMap<>();
        mark2.put("Математика", new int[]{5, 5, 5});
        mark2.put("Информатика", new int[]{5, 4, 5});
        mark2.put("Физика", new int[]{5, 5, 5});
        mark2.put("Философия", new int[]{2, 3, 5});
        mark2.put("Иностранный язык", new int[]{3, 4, 4});
        mark2.put("История", new int[]{4, 4, 4});
        Student student2 = new Student("Олег Сидоров", "3011", 2, mark2);

        Map<String, int[]> mark3 = new HashMap<>();
        mark3.put("Математика", new int[]{5, 5, 5});
        mark3.put("Информатика", new int[]{4, 5, 4});
        mark3.put("Физика", new int[]{5, 3, 5});
        mark3.put("Философия", new int[]{2, 2, 2});
        mark3.put("Иностранный язык", new int[]{2, 3, 2});
        mark3.put("История", new int[]{2, 2, 2});
        Student student3 = new Student("Глеб Глебов", "1066", 2, mark3);

        Map<String, int[]> mark4 = new HashMap<>();
        mark4.put("Математика", new int[]{4, 3, 3});
        mark4.put("Информатика", new int[]{4, 5, 3});
        mark4.put("Физика", new int[]{3, 5, 3});
        mark4.put("Философия", new int[]{3, 3, 3});
        mark4.put("Иностранный язык", new int[]{4, 4, 4});
        mark4.put("История", new int[]{4, 4, 5});
        Student student4 = new Student("Денис Денисов", "6123", 1, mark4);

//        добавление созданных студентов в список
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        System.out.println("Введите имя и фамилию студента, оценки которого вы ходите узнать");
        String name = in.nextLine();
        System.out.println(averageMark(name));
    }


    private static Map<String, Integer> averageMark(String name) {
        Map<String, Integer> avMark = new HashMap<String, Integer>();
        for (final Student st : students) {
            if (st.name.equals(name)) {
                avMark.put("Математика", IntStream.of(st.marks.get("Математика")).sum());
                avMark.put("Информатика", IntStream.of(st.marks.get("Информатика")).sum());
                avMark.put("Физика", IntStream.of(st.marks.get("Физика")).sum());
                avMark.put("Философия", IntStream.of(st.marks.get("Философия")).sum());
                avMark.put("Иностранный язык", IntStream.of(st.marks.get("Иностранный язык")).sum());
                avMark.put("История", IntStream.of(st.marks.get("История")).sum());
            }
        }
        return avMark;
    }
}
