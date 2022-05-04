package lesson_test;

import java.util.Arrays;

public class TestLesson {

    int[] arr;

    public TestLesson(int[] arr) {
        this.arr = arr;
    }

    public TestLesson(){

    }

    boolean arrBalance(int...arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum = sum + arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                sum = sum - arr[j];
            }
            if (sum == 0)
                return true;
        }
        return false;
    }

    int[] movingArray(int...arr) {

        int buf = arr[0];

            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = buf;
        System.out.println(Arrays.toString(arr));

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 10, 25, 45};
        TestLesson test = new TestLesson(arr);
        test.movingArray(1,2,3);
        System.out.println(test.arrBalance());
    }


}





