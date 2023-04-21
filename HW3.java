import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HW3{

    public static void main(String[] args) {
        mergesort(); //Реализовать алгоритм сортировки слиянием
        //deleteOddElements(); //Пусть дан произвольный список целых чисел, удалить из него чётные числа   
        //minMaxAverage();//Найти минимальное, максимальное и среднее из этого списка.
    }
    //1. Реализовать алгоритм сортировки слиянием
    public static void mergesort() {
        Random rnd = new Random();
        int [] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(1,10);
        }

        printArray(arr);
        System.out.println();
        merge_sort(arr);
        printArray(arr);

    }
    public static void printArray(int[] array) {
        boolean isValidAsc = true;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+", ");
            isValidAsc &= i == 0 || array[i] >= array[i-1];
        } 
        System.out.print("isValidAcs = " + isValidAsc);
    }
    public static void merge_sort(int[] array) {
        if (array.length == 1 || array.length == 0){
            return;
        }
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        merge_sort(left);
        merge_sort(right);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length){
            if (left[i] <= right[j]){
                 array[k] = left[i];
                 i++;
            }
            else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length){
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length){
            array[k] = right[j];
            j++;
            k++;
        }
    }
    
    //2. Пусть дан произвольный список целых чисел, удалить из него чётные числа
    public static void deleteOddElements() {
        ArrayList<Integer> list = createList(20);
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i)%2 == 0){
                list.remove(i);
            }
        }
        System.out.println(list);
    }
    public static ArrayList createList(int n) {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(rnd.nextInt(20));
        }
        System.out.println(list);
        return list;
    }
    //3.Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
    public static void minMaxAverage() {
        ArrayList<Integer> list = createList(10);
        int min = list.get(0);
        int max = list.get(0);
        int sum = list.get(0);
        for (Integer element: list) {
            sum += element;
            if (element < min){
                min = element;
            }
            if (element > max){
                max = element;
            }
        }
        double average = (double)sum/(double)list.size();
        System.out.printf("%d - минимальное значение", min);
        System.out.println();
        System.out.printf("%d - максимальное значение", max);
        System.out.println();
        System.out.printf("%.2f - среднеарифметическое значение", average);
    }
}