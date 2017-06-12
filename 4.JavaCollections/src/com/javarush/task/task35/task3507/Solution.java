package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals( Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath()
                +
                Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> res = new HashSet<>();

        // раскомментировать для локального тестирования
//        if (pathToAnimals.startsWith("/")) {
//            pathToAnimals = pathToAnimals.substring(1);
//        }
        Path classesPath = Paths.get(pathToAnimals).toAbsolutePath();
        //if (!Files.isDirectory(classesPath)) {
        //    classesPath = classesPath.getParent();
        //}
        //System.out.println(classesPath);

        for (File f : classesPath.toFile().listFiles()) {
            if (f.isFile() && f.toString().endsWith(".class")) {
                //System.out.println(f.toString());
                ClassLoader classLoader = new ClassLoader()
                {
                    @Override
                    protected Class<?> findClass(String className) throws ClassNotFoundException {
                        try {
                            byte[] b = Files.readAllBytes(f.toPath());
                            return defineClass(null, b, 0, b.length);
                        } catch (IOException ex) {
                            return super.findClass(className);
                        }
                    }
                };

                try {
                    String classFileName = f.toString();
                    Class clazz = classLoader.loadClass(classFileName.substring(0, classFileName.length() - ".class".length()));
                    if (Animal.class.isAssignableFrom(clazz)) {
                        Constructor constructor = clazz.getConstructor();
                        if (constructor != null && Modifier.isPublic(constructor.getModifiers()) ) {
                            Animal animal = (Animal) clazz.newInstance();
                            res.add(animal);
                            //animal.print();
                        }
                    }
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }

        return res;
    }
}
