package lesson_7.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Start {

    private static Object object;


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        starter(Tests.class);
    }

    private static void starter(Class o) throws InvocationTargetException, IllegalAccessException {
        o.toString();
        try {
            object = o.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Method[] objMethods = o.getDeclaredMethods();
        List<Method> testMethods = Arrays.stream(objMethods)
                .filter(n -> n.getAnnotation(Test.class) != null)
                .sorted(Comparator.comparingInt(n -> n.getAnnotation(Test.class).priority()))
                .collect(Collectors.toList());

        List<Method> beforeMetod = Arrays.stream(objMethods)
                .filter(n -> n.getAnnotation(BeforeSuite.class) != null)
                .collect(Collectors.toList());
        var countBeforMetod = (long) beforeMetod.size();

        List<Method> afterMetod = Arrays.stream(objMethods)
                .filter(n -> n.getAnnotation(AfterSuite.class) != null)
                .collect(Collectors.toList());
        var countAfterMetod = (long) afterMetod.size();

        if (beforeMetod.size() != 1) {
            throw new RuntimeException("Количество методов не соответствуют заданию");
        } else if (beforeMetod != null) {
            testMethods.addAll(0, beforeMetod);
        }

        if (afterMetod.size() != 1) {
            throw new RuntimeException("Количество методов не соответствуют заданию");
        } else if (afterMetod != null) {
            testMethods.addAll(afterMetod);
        }

        for (Method testMethod : testMethods) {
            testMethod.setAccessible(true);
            testMethod.invoke(object);
        }
    }
}

