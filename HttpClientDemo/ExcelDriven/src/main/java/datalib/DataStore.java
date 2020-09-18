package datalib;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;

public class DataStore {
	public static CloseableHttpClient httpclient=HttpClients.createDefault();
	public static String url="http://localhost:8888";
	public static String testcasepath=System.getProperty("user.dir")+ File.separator+"data"+File.separator+"testcase"+File.separator;
	public static String testdatapath=System.getProperty("user.dir")+ File.separator+"data"+File.separator+"testdata"+File.separator;
	public static String reportadress=System.getProperty("user.dir")+ File.separator+"report"+File.separator;;
	public static long starttime;
	public static long endtime;



	public static String cloudurl="jdbc:mysql://192.168.66.133:3306/cloud?useSSL=false";
	public static String uaaurl="jdbc:mysql://192.168.66.133:3306/uaa?useSSL=false";
	public static String userName="root";
	public static String password="123456";
}
