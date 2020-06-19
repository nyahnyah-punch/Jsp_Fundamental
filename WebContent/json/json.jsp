<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 	
 	JSONObject obj = new JSONObject();
 	obj.put("name", "kim");
 	obj.put("age", 19);
 	obj.put("address", "서울");
 	
 	JSONArray array = new JSONArray(); //배열 3개 민들기
 	
 	JSONObject obj1 = new JSONObject();
 	obj1.put("no", "1");
 	obj1.put("storeName", "강남스토어1");
 	
 	JSONObject obj2 = new JSONObject();
 	obj2.put("no", "2");
 	obj2.put("storeName", "강남스토어2");
 	
 	JSONObject obj3 = new JSONObject();
 	obj3.put("no", "3");
 	obj3.put("storeName", "강남스토어3");
 	
 	array.add(obj1);
 	array.add(obj2);
 	array.add(obj3);
 	
 	obj.put("items", array);
 	out.print(obj.toJSONString());
	
 %>
 
 