class TestCase {
    private String testCaseFilepath;
    private int result;

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