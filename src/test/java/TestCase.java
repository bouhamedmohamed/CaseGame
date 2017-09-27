class TestCase {
    private final String testCaseFilepath;
    private final int result;

    public TestCase(String testCaseFilepath, int result) {
        this.testCaseFilepath = testCaseFilepath;
        this.result = result;
    }

    public String getTestCaseFilepath() {
        return testCaseFilepath;
    }

    public int getResult() {
        return result;
    }

}