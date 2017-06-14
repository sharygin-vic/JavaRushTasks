package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        //vic:

        //for local testing:
//        if (packageName.startsWith("/")) {
//            packageName = packageName.substring(1);
//        }

        Path path = Paths.get(packageName);

        for (File file : path.toFile().listFiles()) {
            if (file.isFile() && file.toString().endsWith(".class")) {
                ClassLoader cl = new ClassLoader() {
                    @Override
                    protected Class<?> findClass(String name) throws ClassNotFoundException {
                        try {
                            byte[] buff = Files.readAllBytes(file.toPath());
                            return this.defineClass(null, buff, 0, buff.length);
                        } catch (IOException e) {
                            return super.findClass(name);
                        }
                    }
                };
                Class clazz = cl.loadClass(file.toString());
                if (HiddenClass.class.isAssignableFrom(clazz)) {    // проверка на реализацию интерфейса
                    hiddenClasses.add(clazz);
                }
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        //vic:

        HiddenClass res = null;
        key = key.toLowerCase();
        objectCreated:
        for (Class clazz : hiddenClasses) {
            if (clazz.getSimpleName().toLowerCase().startsWith(key)) {
                try {
                    for (Constructor clazzConstructor : clazz.getDeclaredConstructors()) {
                        if (clazzConstructor.getParameterCount() == 0) {
                            clazzConstructor.setAccessible(true);
                            //return (HiddenClass) clazz.newInstance();    // не работает
                            res = (HiddenClass) clazzConstructor.newInstance();
                            break objectCreated;
                        }
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return res;
    }
}

