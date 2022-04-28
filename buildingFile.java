package nick.pack;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    Собираем файл из кусочков
    Считывать с консоли имена файлов
    Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
    Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
    В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
    В него переписать все байты из файлов-частей используя буфер.
    Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
    Закрыть потоки. Не использовать try-with-resources
     */
    public static void main(String[] args) throws IOException {
        String build = "C://test/task10/lion.txt";
        ArrayList<Byte[]> arrayList = new ArrayList<>();
        FileInputStream inputStream = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
        while (true) {
            String file = scanner.nextLine();
            if (file.equalsIgnoreCase("exit")) {
                break;
            }
            String path = "C://test/task10/" + file + ".txt";
            System.out.println(file.substring(file.length() - 1));
        }
    }
}