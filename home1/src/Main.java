
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Написать метод, который меняет два элемента массива местами
        // (массив может быть любого ссылочного типа);
        arrayChange(new Integer[]{1, 2, 3, 4, 5}, 2, 3);
        System.out.println("Массив - список:");

        System.out.println(arrayToList(new Integer[]{9, 2, 2, 1, 0}, 2, 3));
        Box<Orange> oranges1 = new Box<>(10);
        Box<Orange> oranges2 = new Box<>(11);
        oranges1.addFruit(new Orange(), 5);
        oranges2.addFruit(new Orange(), 7);

        System.out.println("вес 1 коробки: " + oranges1.getWeight());
        System.out.println("вес 2 коробки: " + oranges2.getWeight());
        System.out.println("вес 1 коробки равен весу 2-й: " + oranges1.compare(oranges2));
        oranges1.fillBox(oranges2);


    }

    public static <T> void arrayChange(T[] array, int i1, int i2) {
        System.out.println("Наш массив до перестановки двух элементов местами:");
        System.out.println(Arrays.toString(array));
        T element = array[i2];
        array[i2] = array[i1];
        array[i1] = element;

        System.out.println("Наш массив после перестановки элемента под номером " + i1 + " на элемент под номером " + i2);

        System.out.println(Arrays.toString(array));
            }

    //2. Написать метод, который преобразует массив в ArrayList
    public static  <T> List<T> arrayToList(T[] array, int i1, int i2) {
        return Arrays.asList(array);
    }
    //
}