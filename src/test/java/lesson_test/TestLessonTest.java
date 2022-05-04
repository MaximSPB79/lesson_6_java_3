package lesson_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestLessonTest {

    @Test
    @DisplayName("Тест баланс массива")
    void arrBalanceTest() {
        TestLesson testLesson = new TestLesson();
        Assertions.assertTrue(testLesson.arrBalance(1, 2, 3, 5, 1));
    }

    @Test
    @DisplayName("Тест на сдвиг массива")
    void movingArray() {
        TestLesson testLesson = new TestLesson();
        int[] intsResult = testLesson.movingArray(1, 2, 3, 4, 5);
        int[] ints = new int[]{2, 3, 4, 5, 1};
        Assertions.assertArrayEquals(intsResult, ints);
    }
}