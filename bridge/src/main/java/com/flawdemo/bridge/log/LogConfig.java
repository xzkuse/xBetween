package com.flawdemo.bridge.log;

/**
 * Created by pengwei on 16/3/4.
 */
public interface LogConfig {

    LogConfig configAllowLog(boolean allowLog);

    LogConfig configTagPrefix(String prefix);

    LogConfig configFormatTag(String formatTag);

    LogConfig configShowBorders(boolean showBorder);

    LogConfig configMethodOffset(int offset);

    LogConfig configLevel(@LogLevel.LogLevelType int logLevel);

    LogConfig addParserClass(Class<? extends Parser>... classes);
}
