package com.mainpage.xzkproject01.json;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;

/**
 * 拼接json字符串
 */
public class JsonPut {

    public <T> String getJsonString(T t) throws IllegalAccessException, JSONException {
        JSONObject jsObj=new JSONObject();
        Class<?> tClass = t.getClass();
        Field[] fields = tClass.getDeclaredFields();
        for(Field field:fields){
            Class<?> type = field.getType();
            String strType = type.toString();
            if(type==java.util.List.class){
//                field.get//集合暂时先放着
                JSONArray array = jsObj.optJSONArray(field.getName());

//                Object o = field.get(field.getName());
//                jsObj.put(field.getName(),o);
            }else if(type==java.lang.String.class){
                Object o = field.get(field.getName());
                jsObj.put(field.getName(),o);
            }else if(strType.equals("double")){
                double aDouble = field.getDouble(field.getName());
                jsObj.put(field.getName(),aDouble);
            }else if(strType.equals("long")){
                long aLong = field.getLong(field.getName());
                jsObj.put(field.getName(),aLong);
            }else if(strType.equals("int")){
                int anInt = field.getInt(field.getName());
                jsObj.put(field.getName(),anInt);
            }else if(strType.equals("float")){
                float aFloat = field.getFloat(field.getName());
                jsObj.put(field.getName(),aFloat);
            }else if(strType.equals("boolean")){
                boolean aBoolean = field.getBoolean(field.getName());
                jsObj.put(field.getName(),aBoolean);
            }else{//内部对象

            }
            Log.i("tags","解析属性:"+type);
            //interface java.util.List
            //class com.mainpage.xzkproject01.json.TestBean$TestA
            //class java.lang.String
            //class java.lang.String
            //double
            //long
            //int
            //float
            //boolean
            //int
        }
//        jsObj.put()
        return null;
    }

}
