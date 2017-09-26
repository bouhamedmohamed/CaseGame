import solution.Solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TestCases {
    static HashMap<Integer, TestCase> testCaseHashMap = new HashMap<Integer, TestCase> ( );
    final static String testCaseFilePath = ".\\test cases\\input-case";
    public static final int IMPOSSIBLE = -1;


    static {

        testCaseHashMap.put (1, new TestCase (testCaseFilePath + 1, 3));
        testCaseHashMap.put (2, new TestCase (testCaseFilePath + 2, 3));
        testCaseHashMap.put (3, new TestCase (testCaseFilePath + 3, 7));
        testCaseHashMap.put (4, new TestCase (testCaseFilePath + 4, 10));
        testCaseHashMap.put (5, new TestCase (testCaseFilePath + 5, 69));
        testCaseHashMap.put (6, new TestCase (testCaseFilePath + 6, IMPOSSIBLE));
        testCaseHashMap.put (7, new TestCase (testCaseFilePath + 7, 2));
        testCaseHashMap.put (8, new TestCase (testCaseFilePath + 8, 1));
        testCaseHashMap.put (9, new TestCase (testCaseFilePath + 9, IMPOSSIBLE));
        testCaseHashMap.put (10, new TestCase (testCaseFilePath + 10, IMPOSSIBLE));
        testCaseHashMap.put (11, new TestCase (testCaseFilePath + 11, IMPOSSIBLE));
        testCaseHashMap.put (12, new TestCase (testCaseFilePath + 12, 3));
        testCaseHashMap.put (13, new TestCase (testCaseFilePath + 13, 2));
        testCaseHashMap.put (14, new TestCase (testCaseFilePath + 14, 518));
        testCaseHashMap.put (15, new TestCase (testCaseFilePath + 15, 31));
    }


    static boolean compareResults(int testCaseNumber) throws IOException {
        TestCase testCase = testCaseHashMap.get (testCaseNumber);
        try (BufferedReader br = new BufferedReader (new FileReader (testCase.getTestCaseFilepath ( )))) {
            int expectedResult = testCase.getResult ( );
            int result = Solution.compute (br);
            return expectedResult == result;
        }
    }

}
