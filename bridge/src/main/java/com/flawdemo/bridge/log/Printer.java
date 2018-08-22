package com.flawdemo.bridge.log;

/**
 * @author xzk
 * @data 2018/8/22
 * @email o-xiezhengkun@beyondsoft.com
 * @remark
 */
public interface Printer {

    void d(String message, Object... args);
    void d(Object object);

    void e(String message, Object... args);
    void e(Object object);

    void w(String message, Object... args);
    void w(Object object);

    void i(String message, Object... args);
    void i(Object object);

    void v(String message, Object... args);
    void v(Object object);

    void wtf(String message, Object... args);
    void wtf(Object object);

    void json(String json);
    void xml(String xml);
}
