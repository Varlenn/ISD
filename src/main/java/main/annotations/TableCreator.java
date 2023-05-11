package main.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TableCreator {

    private String getConstraints(Constraints con) {
        String constrains = "";
        if(!con.allowNull()) {
            constrains += " not null";
        } if (con.primaryKey()) {
            constrains += " primary key";
        } if (con.unique()) {
            constrains += " unique";
        }

        return constrains;
    }

    private void runCommandInDB(String command) {

    }

    public void temp(Newspaper newspaper) {
        String str = "Create table ";
        Class<?> clazz = newspaper.getClass();
        str += clazz.getAnnotation(DBTable.class).name() + " (";
        for (Field field : clazz.getDeclaredFields()) {
            Annotation [] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof ColumnInteger ff) {
                    str += field.getName() + " int, ";
                }
                if (annotation instanceof ColumnString ff) {
                    str += field.getName() + " text, ";
                }
            }
        }
        str = str.substring(0, str.length() - 2);
        System.out.println(str + ")");
    }
}
