import com.frame.ExcelProcess;
import com.frame.RegularExtract;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test1 {
    public static void main(String[] args) throws Exception {
        String casePath = System.getProperty("user.dir")+File.separator+"ExcelDriven"+ File.separator+"data"+File.separator+"testcase"+File.separator+"case1.xlsx";
        ExcelProcess testcase = new ExcelProcess(casePath);
        testcase.setup();
        String dataPath = System.getProperty("user.dir")+File.separator+"ExcelDriven"+ File.separator+"data"+File.separator+"testdata"+File.separator+"data1.xlsx";
        ExcelProcess testdata = new ExcelProcess(dataPath);
        testdata.setup();
        System.out.println(dataPath);

        HashMap map = RegularExtract.newmap(testdata);
        System.out.println(map);


        int rowNum = testcase.getrowcount(0);
        for (int i = 2; i <3; i++){
            String path = testcase.getcellcontent(0,i,2);
            System.out.println("first printing---"+path);
            path = RegularExtract.replacepara(path, map);
            System.out.println("second printing--"+path);
        }
        String str = "\"access_token\":\"12345\"";
        String regex = "\"access_token\":\"(.*?)\"";
        String name = "name1";
        String keys[] = new String []{"a"};
        RegularExtract.regularextract(str,regex,1,map,keys);
        System.out.println(map);








    }
}
