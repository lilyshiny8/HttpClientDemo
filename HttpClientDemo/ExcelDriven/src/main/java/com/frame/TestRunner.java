package com.frame;

import com.frame.http.HttpClientUtil;
import com.frame.http.request.JsonRequest;
import com.frame.http.request.MultiPartFormRequest;
import com.frame.http.request.Request;
import com.frame.http.response.Response;
import datalib.DataStore;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;

import org.apache.http.impl.client.BasicCookieStore;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Logger;


public class TestRunner {
	public static Logger logger = Logger.getLogger(TestRunner.class.getName());


	public  static void runTest(ExcelProcess testcase, int sheetnum, ExcelProcess testdata, BusinessLib bl){
		//cookie保存
		CookieStore cookieStore = (CookieStore) new BasicCookieStore();
		HttpClientUtil.setHttpClient(cookieStore);
		HttpClientContext context = HttpClientContext.create();
		context.setCookieStore(cookieStore);

//		List cookies = cookieStore.getCookies();
//		System.out.println("cookies:"+cookies);

		int rownum;
		rownum = testcase.getrowcount(sheetnum);

		HashMap map = null;// 保存全局变量
		map = RegularExtract.newmap(testdata);//将testdata中的数据写入到map中
//		RegularExtract.logger.info("测试用例数量为：" + (rownum - 3));
		Response response = null;// 请求响应
		String pass = null;// 是否通过
		String type = null;// 类型
		String url = null;// 接口拼接后的地址
		String path = null;// 接口路径
		String httpmethod = "get";// 请求方法，默认为get

		int j = 1;// 测试结果计数器
		for (int i = 3; i < rownum; i++) {
			try{
			if (!testcase.iscellnull(0, i, 21)&&testcase.getcellcontent(0, i, 21).equals("否")) {//v列
				continue;
			} //不为空且为否时跳过
			if (!testcase.iscellnull(sheetnum, i, 22)) {
				String wait=testcase.getcellcontent(sheetnum, i, 22);
				CommonLib.sleep(Integer.parseInt(wait));
			} //设置等待时间
			type = testcase.getcellcontent(0, i, 0);
			// 如果是数据库请求，执行数据库请求
				//this line maybe meaningless
			bl.testcaseDescribe = testcase.getcellcontent(sheetnum, i, 1);
			if (type.equals("")) {
				;

			} else if (type.equals("http request")) {
				//获取路径
				path = testcase.getcellcontent(0, i, 2);
				path = RegularExtract.replacepara(path, map);
				if(path.startsWith("http")){
					bl.url=path;
				}else{
					bl.url = DataStore.url + path;
				}
				//获取请求方法
				httpmethod = testcase.getcellcontent(0, i, 3);
				//获取请求体
				   //获取请求体类型
				String entitytype = null;
				if (!testcase.iscellnull(0, i, 5) && !testcase.iscellnull(0, i, 6)) {
					entitytype = testcase.getcellcontent(0, i, 5);//实体类型列
					bl.input = testcase.getcellcontent(0, i, 6);//实例内容列
					bl.input = RegularExtract.replacepara(bl.input, map);//将实例内容列中的占位符替代为实际数据
				} else {
					bl.input = null;
					entitytype = null;
				}

				if (!(entitytype == null) && entitytype.toLowerCase().equals("string")) {
					JsonRequest request = new JsonRequest(bl.url, bl.getrequetmethod(httpmethod));
					System.out.println("request="+request);
					logger.info("first"+request.toString());
					// 如果存在header，添加header
					if (!testcase.iscellnull(0, i, 4)) {//header列
						String headers = testcase.getcellcontent(0, i, 4);
						headers = RegularExtract.replacepara(headers, map);
						request.addHeaders(headers);
					}
					//请求体传入到StringEntity中
					if (!bl.input.isEmpty() && !(bl.input == null)) {
						request.setJsonObject(bl.input);
					} else {
						logger.info("第" + i + "行请输入实体参数");
					}
					System.out.println("加入请求体后request="+request);
					logger.info("second="+request.toString());
					//执行request
					response = HttpClientUtil.doRequest(request, context);
				}
				else if (!(entitytype == null) && entitytype.toLowerCase().equals("file")) {
					MultiPartFormRequest request = new MultiPartFormRequest(bl.url, bl.getrequetmethod(httpmethod));
					if (!testcase.iscellnull(0, i, 4)) {
						String headers = testcase.getcellcontent(0, i, 4);
						headers = RegularExtract.replacepara(headers, map);
						request.addHeaders(headers);
					} // 如果存在header，添加header
					if (!bl.input.isEmpty() && !(bl.input == null)) {
						String str[] = bl.input.split(";");
						if (str.length == 3) {
							String filename = str[0].replace("name=", "");
							String filepath = str[1].replace("path=", "");
							String contenttype = str[2].replace("contenttype=", "");
							request.addPart(filename, new File(filepath), contenttype);
						} else {
							logger.info("第" + i + "行输入的参数错误，参考格式：name=file;path=c:\1.png;contenttype=image/png");
						}
					} else {
						logger.info("第" + i + "行请输入实体参数");
					}
					response = HttpClientUtil.doRequest(request, context);
				} else if (!(entitytype == null) && entitytype.toLowerCase().equals("download")) {
					Request request = new Request(bl.url, bl.getrequetmethod(httpmethod));
					if (!testcase.iscellnull(0, i, 4)) {
						String headers = testcase.getcellcontent(0, i, 4);
						headers = RegularExtract.replacepara(headers, map);
						request.addHeaders(headers);
					} // 如果存在header，添加header
					if (bl.input.isEmpty() && !(bl.input == null)) {
						logger.info("第" + i + "行请输入实体参数");
					}
					response = HttpClientUtil.dodownloadRequest(request, context,
							System.getProperty("user.dir") + File.separator + "download" + File.separator + bl.input);
				} else if (entitytype == null) {
					Request request = new Request(bl.url, bl.getrequetmethod(httpmethod));
					if (!testcase.iscellnull(0, i, 4)) {
						String headers = testcase.getcellcontent(0, i, 4);
						headers = RegularExtract.replacepara(headers, map);
						testcase.write(0, i,4, headers);//参数化后写回
						request.addHeaders(headers);
					} // 如果存在header，添加header
					response = HttpClientUtil.doRequest(request, context);
				} else {
					logger.info("第" + i + "行实体类型输入错误，请输入：string,file,download");
					continue;
				}
				//获取全部的response
				bl.output = response.getAll();
				String checkattrib = testcase.getcellcontent(0, i, 8).toLowerCase();//检查数据所属位置
				String expectvalue = testcase.getcellcontent(0, i, 10);//获取需要验证的值
				expectvalue = RegularExtract.replacepara(expectvalue, map);//替换占位符${}为实际数据
				if (checkattrib.equals("statusline")) {
					pass = bl.VerifyStatusline(response, expectvalue);
				} else if (checkattrib.equals("head")) {
					if (testcase.iscellnull(0, i, 9)) {
						pass = bl.Verifyhead(response, testcase.getcellcontent(sheetnum, i, 9), expectvalue);
					} else {
						pass = bl.Verifyhead(response, expectvalue);
					}

				} else if (checkattrib.equals("body")) {
					if (response.getCode() == 200) {
						if (!testcase.iscellnull(0, i, 9)) {//key值
							pass = bl.Verifyjsonbody(response, testcase.getcellcontent(sheetnum, i, 9), expectvalue);
						} else {
							pass = bl.Verifstringbody(response, expectvalue);
						}
					} else
						pass = bl.VerifyStatusline(response, expectvalue);
				}
				// 保存http关联               关联数据所在位置                  正则表达式                                变量名
				if (testcase.iscellnull(0, i, 11) || testcase.iscellnull(0, i, 12) || testcase.iscellnull(0, i, 14)) {
					logger.info("没有关联信息");
				} else {
					String location = testcase.getcellcontent(0, i, 11);//关联数据所在位置
					String str = null;
					if (location.toLowerCase().equals("statusline")) {
						str = response.getstatusline();
					} else if (location.toLowerCase().equals("head")) {
						str = response.getAllHeaderstoString();
					} else if (location.toLowerCase().equals("body")) {
						str = response.getResponseText();
					} else {
						logger.info("关联所在位置填写错误，请填写：statusline，head，body中的一种");
					}
					String regex = testcase.getcellcontent(0, i, 12);//正则表达式
					String n = testcase.iscellnull(0, i, 13) ? "1" : testcase.getcellcontent(0, i, 13);//第几次匹配
					String varibals = testcase.getcellcontent(0, i, 14);//变量名
					String keys[] = varibals.split(";");
					RegularExtract.regularextract(str, regex, Integer.valueOf(n), map, keys);
					String keyvalues = "";
					for (int f = 0; f < keys.length; f++) {
						keyvalues += keys[f] + "=" + map.get(keys[f]) + ";";
					}
					testcase.write(0, i, 15, keyvalues);//value
				}
				// 写入测试结果
				testcase.write(0, i, 7, bl.output);//返回数据
				testcase.write(0, i, 6, bl.input);//实例内容
				testcase.write(0, i,2, bl.url);//路径
				testcase.write(0, i,10, expectvalue);//预期value值
				testcase.write(0, i, 19, pass);//测试结果
				testcase.write(0, i, 20, String.valueOf(DataStore.endtime - DataStore.starttime));//响应时间
				
			}
			//完成用例后的延时
//			if (testcase.iscellnull(0, i, 22)) {
////				RegularExtract.logger.info("不需要延时");
//			} else {
//				Long sleepTime = Long.parseLong(testcase.getcellcontent(0, i, 22));
//				sleep(sleepTime);
//			}
			}catch (Exception e){
				logger.severe("error，用例执行失败，详细信息："+e.getStackTrace());
				e.printStackTrace();

				testcase.write(0, i, 7, "用例执行失败");
				testcase.write(0, i, 19, "NA");
				
			}
			
		}
	
	}

}
