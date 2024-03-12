package tp;

import java.lang.annotation.Annotation;
import java.util.*;

public class Utils {
    /**
     * Finds all classes within a package which are annotated with certain
     * annotation.
     *
     * @param annotation  Annotation which we are looking for
     * @param packageName Package in which to search
     * @return The list of annotated classes
     */
    public static Set<Class<?>> findAnnotatedClasses(Class<? extends Annotation> annotation, String packageName) {
        // Get all classes in the specified package
        Package pkg = Package.getPackage(packageName);
        String packagePath = pkg.getName().replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Set<Class<?>> classSet = new HashSet<>();
        try {
            for (java.net.URL resource : java.util.Collections.list(classLoader.getResources(packagePath))) {
                String filePath = resource.getFile();
                if (resource.getProtocol().equals("file")) {
                    if (filePath.contains(".jar!")) {
                        // Handle jar files
                        // You might want to implement this part based on your requirements
                    } else {
                        // Handle classes in the file system
                        java.io.File folder = new java.io.File(resource.getFile());
                        for (java.io.File file : folder.listFiles()) {
                            if (file.isFile() && file.getName().endsWith(".class")) {
                                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                                Class<?> clazz = Class.forName(className);
                                if (clazz.isAnnotationPresent(annotation)) {
                                    System.out.println("Class found with annotation " + annotation.getSimpleName() + ": " + className);
                                    classSet.add(clazz);
                                }
                            }
                        }
                    }
                } else {
                    // Handle classes in other types of resources (e.g., in a JAR)
                    // You might want to implement this part based on your requirements
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classSet;







    }
}
