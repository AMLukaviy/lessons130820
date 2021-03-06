package net.anotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
    public static void
    trackUseCases(List<Integer> useCases, Class<?> c1) {
        for (Method m : c1.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() +
                " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCases) {
            System.out.println("Warning Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCase = new ArrayList<>();
        Collections.addAll(useCase, 47, 48, 49, 50);
        trackUseCases(useCase, PasswordUtils.class);
    }
}
