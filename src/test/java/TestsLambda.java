import main.lambda.AvtorControllerL;
import main.lambda.Functions;
import main.service.DBConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestsLambda {

    @Test
    public void UpCase() {
        List<String> input = Arrays.asList("a", "b", "hello");
        Assertions.assertEquals(Arrays.asList("A", "B", "HELLO"), Functions.upCase(input));
    }

    @Test
    public void Test() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Assertions.assertEquals(14, Functions.sumSqrt(input));
    }

    @Test
    public void TestAgeSum() {
        DBConnection dbConn = new DBConnection();
        AvtorControllerL avtorController = new AvtorControllerL(dbConn);
        Assertions.assertEquals(16663, avtorController.searchAvtorsYearSum());
    }
}
