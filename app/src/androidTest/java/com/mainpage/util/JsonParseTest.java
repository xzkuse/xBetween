package com.mainpage.util;

import android.util.Log;

import com.mainpage.xzkproject01.json.JsonParse;
import com.mainpage.xzkproject01.json.JsonPut;
import com.mainpage.xzkproject01.json.TestBean;

import org.json.JSONException;
import org.junit.Test;

/**
 * Created by Administrator on 2017/8/3.
 */

public class JsonParseTest {

    private String json = "{\"aid\": 12,\"bid\": true, \"cid\": 1.333f,\"did\": 'xzx',\"eid\": 21.22,\"fid\": 21221, \"gid\": 21, \"name\": \"王aaaaa\", \"obj\": {  \"a1\": 121  },\"objList\": [  {\"a2\": 1212 },{\"a2\": 13133  } ]}";

    @Test
    public void logJsonParse() {
        JsonParse jsonParse = new JsonParse();
        try {
            TestBean jsonToBean = jsonParse.jsonToBean(TestBean.class, json);
            Log.i("tags","输出结果:"+jsonToBean);//基本完成,输出
            //拼装json字符串
            JsonPut jPut=new JsonPut();
            String jsonString = jPut.getJsonString(jsonToBean);
            Log.i("tags","输出字符串:"+jsonString);
        } catch (JSONException e) {
            Log.i("tags", "解析异常1:" + e.getMessage());
            System.out.print(e.getMessage() + "");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Log.i("tags", "解析异常2:" + e.getMessage());
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
