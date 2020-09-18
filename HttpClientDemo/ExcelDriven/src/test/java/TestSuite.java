import com.frame.BusinessLib;
import com.frame.CommonLib;
import com.frame.ExcelProcess;
import com.frame.TestRunner;
import datalib.DataStore;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuite {
    BusinessLib bl = new BusinessLib();
    ExcelProcess testcase = null;
    ExcelProcess testdata = null;

    String projectname = "testSuite";
    String testcasepath = DataStore.testcasepath + "case1.xlsx";
    String testdatapath = DataStore.testdatapath + "data1.xlsx";
    String testreportpath = DataStore.reportadress + projectname + CommonLib.getCurrentTime() + ".xlsx";

    @BeforeMethod
    public void setUp() throws Exception {
//        bl.newsetUp(projectname);
        testcase = new ExcelProcess(testcasepath);//
        testdata = new ExcelProcess(testdatapath);//
        testcase.setup();
        testdata.setup();
    }
    @AfterMethod
    public void tearDown() throws Exception {
        DataStore.httpclient.close();
        testcase.save(testreportpath);
        testcase.close();
        testdata.close();
    }
    @Test
    public void test() throws Exception {
        TestRunner.runTest(testcase,0,testdata,bl);
    }

}
