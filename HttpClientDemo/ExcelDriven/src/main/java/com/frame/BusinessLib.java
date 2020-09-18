package com.frame;

import com.frame.http.request.RequestMethod;
import com.frame.http.response.Response;
//import com.report.entry.ReportEntry;
import datalib.DataStore;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class BusinessLib {
//	public ReportEntry re=new ReportEntry();
	public String testcaseDescribe =null;
	public String input=null;
	public String output=null;
	public String url=null;
//	public void newsetUp(String name){
//		re.crateLog(DataStore.reportadress+name+CommonLib.getCurrentTime()+".html");
//	}

	
	public static RequestMethod getrequetmethod(String name){
		name=name.toLowerCase();
		RequestMethod rq = null;
		switch(name){
		case "get":
			rq=RequestMethod.GET;break;
		case "post":
			rq=RequestMethod.POST;break;
		case "head":
			rq=RequestMethod.HEAD;break;
		case "options":
			rq=RequestMethod.OPTIONS;break;
		case "patch":
			rq=RequestMethod.PATCH;break;
		case "put":
			rq=RequestMethod.PUT;break;
		case "delete":
			rq=RequestMethod.DELETE;break;
		default:
			rq=RequestMethod.GET;
		}
		return rq;
		
	}
	public String VerifyEquals(String expect,String actual){
		String result;
		if(expect.equals(actual)){
			result="PASS";
		}
		else
			result="FAIL";

		return result;
	}
	public String Verifycontains(String expect,String actual){
		String result;
		if(actual.contains(expect)){
			result="PASS";
		}
		else
			result="FAIL";

		return result;
	}
	
	public String Verifymatch(String expect,String actual){
		String result;
		Pattern pattern = Pattern.compile(expect);
		Matcher matcher = pattern.matcher(actual);
		if(matcher.find()){
			result="PASS";
		}
		else
			result="FAIL";

		return result;
	}
	
	public String VerifyStatusline(Response response,String expect) throws Exception, IOException{
		String statusline=response.getstatusline();
		output=response.getstatusline();
		return Verifymatch(expect,statusline);
	}
	public String Verifyhead(Response response,String headname,String expect) throws Exception, IOException{
		String header=response.getHeader(headname);
		output=response.getAllHeaderstoString();
		return VerifyEquals(expect,header);
	}
	public String Verifyhead(Response response,String expect) throws Exception, IOException{
		String header=response.getAllHeaderstoString();
		output=response.getAllHeaderstoString();
		return Verifymatch(expect,header);
	}
	public String Verifyjsonbody(Response response,String path,String expect) throws UnsupportedOperationException, IOException{
		String content=response.getResponseText();
		String actual=JsonParse.parsejson(content, path);
		output=content;
		return Verifymatch(expect,actual);
	}
	public String Verifstringbody(Response response,String expect) throws UnsupportedOperationException, IOException{
		String actual=response.getResponseText();
		output=actual;
		return Verifymatch(expect,actual);
	}

	
}
