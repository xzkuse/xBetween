package com.mainpage.xzkproject01.json;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建需要的对象
 */
public class JsonParse {

    //没有一个有效的类型判定方式....万金油一些的
    public <T> T  jsonToBean(Class<T> t, String jsonObj) throws JSONException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {//传入Class<T> 避免直接进入class了--内部包含serialVersionUID，和String name
        Field[] fields = t.getDeclaredFields();
        Log.i("tags", fields.length + "+++111111");
        JSONObject jsonObject = new JSONObject(jsonObj);
        T t1 = t.newInstance();
        for (Field field : fields) {
            String name = field.getType().getSimpleName();
            if (name.equals("int")) {
                if (jsonObject.has(field.getName())){
                    int anInt = jsonObject.getInt(field.getName());
                    Log.i("tags", "输出int:" + anInt);
                    setFieldValue(field,t1,anInt);
                } else
                    Log.i("tags", "没有这个值int;");
            } else if (name.equals("short")) {
                if (jsonObject.has(field.getName())){
                    int lon = jsonObject.getInt(field.getName());
                    Log.i("tags", (t1==null)+"输出short:" + lon);
                    setFieldValue(field,t1,lon);
                }
                else
                    Log.i("tags", "没有这个值short;");
            } else if (name.equals("float")) {
                if (jsonObject.has(field.getName())) {
                    String aStr = jsonObject.getString(field.getName());
                    float aFloat = Float.parseFloat(aStr);
                    setFieldValue(field, t1, aFloat);
                    Log.i("tags", "输出float:" + aFloat);
                }else
                    Log.i("tags", "没有这个值float;");
            } else if (name.equals("char")) {
                if (jsonObject.has(field.getName())) {
                    String str = jsonObject.getString(field.getName());
                    Log.i("tags", "输出char:" + str);
//                    char[] chars = str.toCharArray();
                    setFieldValue(field, t1, str);
                }else
                    Log.i("tags", "没有这个值char;");
            } else if (name.equals("double")) {
                if (jsonObject.has(field.getName())){
                    double aDouble = jsonObject.getDouble(field.getName());
                    setFieldValue(field, t1, aDouble);
                    Log.i("tags", "输出double:" + aDouble);
                }
                else
                    Log.i("tags", "没有这个值double;");
            } else if (name.equals("long")) {
                if (jsonObject.has(field.getName())){
                    long aLong = jsonObject.getLong(field.getName());
                    setFieldValue(field, t1, aLong);
                    Log.i("tags", "输出long:" + aLong);
                } else
                    Log.i("tags", "没有这个值long;");
            } else if (name.equals("boolean")) {
                if (jsonObject.has(field.getName())) {
                    boolean aBoolean = jsonObject.getBoolean(field.getName());
                    setFieldValue(field, t1, aBoolean);
                    Log.i("tags", "输出boolean:" + aBoolean);
                }else
                    Log.i("tags", "没有这个值boolean;");
            } else if (name.equals("String")) {
                if (jsonObject.has(field.getName())) {
                    String aStr = jsonObject.getString(field.getName());
                    setFieldValue(field, t1, aStr);
                    Log.i("tags", "输出String:" + aStr);
                }else
                    Log.i("tags", "没有这个值String;");
            } else if (name.equals("List")) {//集合如何处理---通过反射获得集合的泛型
                if (jsonObject.has(field.getName())) {
                    Class<?> aClass = getArrayList(field);
                    JSONArray jsonArray = jsonObject.getJSONArray(field.getName());
                    Log.i("tags", "------开始处理集合------");
                    List<?> array = getArray(aClass, jsonArray);
                    setFieldValue(field,t1,array);//讲集合对象放入外部对象即可
                    Log.i("tags", "------集合处理结束------");
                } else
                    Log.i("tags", "没有这个值List;");
            } else {//其他如何处理,作为对象处理
                if (jsonObject.has(field.getName())){
                    Log.i("tags", "------开始处理对象------");
                    Object o = jsonToBean(Class.forName(field.getType().getName()), jsonObject.getJSONObject(field.getName()).toString());
                    setFieldValue(field,t1,o);
                    Log.i("tags", "------对象处理结束------");
                } else
                    Log.i("tags", "没有这个值Object;");
            }
            Log.i("tags", Modifier.toString(field.getModifiers()) + ",," + field.getName() + ":类型名称:" + name);
            Log.i("tags", fields.length + "+++aa");
        }
        return t1;
    }
    private <T> void setFieldValue(Field field,T t,List value){//集合的
        field.setAccessible(true);
        try {
            field.set(t,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    private <T> void setFieldValue(Field field,T t,Object value){//最外层的
        field.setAccessible(true);
        try {
            field.set(t,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    private <T> void setFieldValue(Field field,T t,short value,short a){//short,,传值失败....
        field.setAccessible(true);
        try {
            field.setShort(t,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    private <T> void setFieldValue(Field field,T t,char value,char a){//char
        field.setAccessible(true);
        try {
            field.setChar(t,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //        field.getName().equals()
//        Field declaredField = t.getDeclaredField(field.getName());
    private Class<?> getArrayList(Field f) {
        f.setAccessible(true);//将访问权限设置为true
        if (f.getType() == java.util.List.class) {
            // 如果是List类型，得到其Generic的类型
            Type genericType = f.getGenericType();
            if (genericType == null) return null;
            // 如果是泛型参数的类型
            if (genericType instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType) genericType;
                //得到泛型里的class类型对象
                Class<?> genericClazz = (Class<?>) pt.getActualTypeArguments()[0];
                return genericClazz;
            }
        }
        return null;
    }

    private <T> List<T> getArray(Class<T> aClass, JSONArray array) throws JSONException {
        List<T> list=new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            try {
                String string = array.get(i).toString();
                T t = jsonToBean(aClass, string);
                list.add(t);
                Log.i("tags", "集合数据L" + string);
            } catch (Exception e) {
                Log.i("tags", "集合获取失败:" + e.getMessage());
                e.printStackTrace();
            }
        }
        return list;
    }

//    private int getInt() {
//
//    }
}
