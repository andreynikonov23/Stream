package nick.pack;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    /*
    1. Ввести с консоли имя файла
    2. Найти байт или байты с максимальным количеством повторов
    3. Вывести их на экран через пробел.
    4. Закрыть поток ввода-вывода
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert path:");
        String path = scanner.nextLine();
        ArrayList<Integer> bytes = new ArrayList<>();
        try(FileInputStream inputStream = new FileInputStream(path)){
            while (inputStream.available() > 0){
                bytes.add(inputStream.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bytes + " -- size: " + bytes.size());
        int count = 1;
        ArrayList<Integer> counts = new ArrayList<>();
        ArrayList<Integer> repeatByte = new ArrayList<>();
        for (int i = 0; i < bytes.size(); i++) {
            for (int j = 0; j < bytes.size(); j++) {
                if (bytes.get(i) == (bytes.get(j)) && i != j) {
                    count++;
                }
                if (j == bytes.size() -1 && count > 1){
                    counts.add(count);
                    repeatByte.add(bytes.get(i));
                    count = 1;
                }
            }
        }
        for (int i = 0; i < repeatByte.size(); i++) {
            for (int j = 1; j < repeatByte.size(); j++) {
                if (repeatByte.get(i) == repeatByte.get(j)){
                    repeatByte.remove(j);
                    counts.remove(j);
                }
            }
        }
        int maxValue = 0;
        int index = 0;
        for (int i = 0; i < counts.size(); i++) {
            if (counts.get(i) > maxValue){
                maxValue = counts.get(i);
                index = i;
            }
        }
        System.out.println("Byte: " + repeatByte.get(index) + ", repeating - " + maxValue);
    }
}
