package com.frame;

import java.util.HashMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtract {
	public static Logger logger = Logger.getLogger("测试日志");

	/**
	 * @param str 待匹配字符串
	 * @param regex 正则表达式
	 * @param i 第i次匹配
	 * @param map 保存变量key，value
	 * @param name 变量名
	 */
	public static void regularextract(String str, String regex, int i, HashMap map, String...name) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		try {
			for (int j = 0; j <i; j++) {
				if (!matcher.find()) {
					logger.info("未找到第" + i + "组匹配数据");
				}
			}
			if (name.length != matcher.groupCount()) {
				logger.info("变量名称个数与找到的正则表达式的子表达式个数不一致,只保存部分字表达式的值");
			}
			for (int j = 0; j < name.length; j++) {
				map.put(name[j], matcher.group(j + 1));
			}
		} catch (Exception e) {
			logger.info("未找到匹配字符串");
			e.printStackTrace();
		}
	}
	public static HashMap newmap(ExcelProcess ep) {
		HashMap map = new HashMap();
		System.out.println(ep.getrowcount(0));
		for (int i = 1; i < ep.getrowcount(0); i++) {
				map.put(ep.getcellcontent(0, i, 0), ep.getcellcontent(0, i, 1));
		}
		return map;
	}
	public static String replacepara(String para, HashMap map) {
		String regex = "\\$[{][_\\w]*?[}]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(para);
		String result = null;
		String para1 = null;
		String paraname = null;
		String value = null;
		while (matcher.find()) {
			para1 = matcher.group();

			paraname = para1.substring(2, para1.length() - 1);
//			logger.info("参数化变量"+paraname);
			if(paraname.equals("systemmilisecond")){
				value=String.valueOf(System.currentTimeMillis());
			}
			else if(paraname.equals("systemsecond")){
				value=String.valueOf(System.currentTimeMillis()/1000);
			}
			else{
				value =(String) map.get(paraname);
			}
			para = para.replace(para1, value);
//			logger.info("参数化："+" 关联变量"+paraname+" 变量值"+value+" 成功");
		}
//		logger.info("参数化后的字符串"+para);
		return para;
	}
//	public static void main(String args[]) {
//		HashMap map = new HashMap();
//		String str = "123out234jklfds123out234jklfds";
//		String reg = "123(out)234(jklfds)";
//		regularextract(str, reg, 1, map, "name1", "name2");
//		System.out.println(map.get("name1"));
//		System.out.println(map.get("name2"));
//	}
}
