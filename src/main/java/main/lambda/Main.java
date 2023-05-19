package main.lambda;
import main.service.DBConnection;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
                final IntBinaryOperator intBinaryOperator = (x, y) -> {
            int f1 = 1;
            for (int i = 2; i <= x; i++) {
                f1 *= i;
            }

            int f2 = 1;
            for (int i = 2; i <= y; i++) {
                f2 *= i;
            }

            return f1 / f2;
        };

        System.out.println(intBinaryOperator.applyAsInt(5, 3));

        DBConnection dbConn = new DBConnection();
        AvtorControllerL avtorController = new AvtorControllerL(dbConn);

        avtorController.searchAvtors(1900);
        System.out.println("\n");
        avtorController.searchAvtorsLambda(1900);

//        List<Integer> input = Arrays.asList(1, 2, 3);
//        System.out.println(Functions.sumSqrt(input));

//        final Controller controller = new Controller();
//        System.out.println("Sum " + controller.searchAvtorsYearSum());

        System.out.println();
        new Program();
    }
}
