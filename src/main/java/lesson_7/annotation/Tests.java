package lesson_7.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Tests {

    List<Method> tests = new ArrayList<>();

    @Test(priority = 2)
    void test1() {
        System.out.println("Тест один");
    }

    @Test(priority = 3)
    void test2() {
        System.out.println("Тест два");
    }

    @Test(priority = 4)
    void test3() {
        System.out.println("Тест три");
    }

    @Test(priority = 5)
    void test4() {
        System.out.println("Тест четыре");
    }

    @Test(priority = 6)
    void test5() {
        System.out.println("Тест пять");
    }

    @Test(priority = 7)
    void test6() {
        System.out.println("Тест шесть");
    }

    void test7() {
        System.out.println("Тест семь");
    }

    void test8() {
        System.out.println("Тест восемь");
    }

    @BeforeSuite
    void metodBefore() {
        System.out.println("Самый первый метод");
    }

    @AfterSuite
    void metodAfter() {
        System.out.println("Самый последний метод");
    }
}
