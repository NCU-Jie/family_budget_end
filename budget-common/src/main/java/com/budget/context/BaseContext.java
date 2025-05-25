package com.budget.context;

public class BaseContext {

    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<Long> familyThreadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }


    public static void setFamilyId(Long familyId) {
        familyThreadLocal.set(familyId);
    }
    public static Long getFamilyId() {
        return familyThreadLocal.get();
    }
    public static void removeFamilyId() {
        familyThreadLocal.remove();
    }
}
