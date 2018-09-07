package com.flawdemo.bridge.bean;

/**
 * @author xzk
 * @data 2018/9/7
 * @email o-xiezhengkun@beyondsoft.com
 * @remark
 */
public class AppInfo {

    /**
     * 设备cpu  arm:4核
     */
    private String deviceCpuInfo;

    private DeviceDiskInfo deviceDiskInfo;
    /**
     * 设备内存总量
     */
    private String deviceMemoryInfo;
    /**
     * 设备唯一id
     */
    private String deviceId;
    /**
     * 设备当前ip
     */
    private String deviceNetworkInfo;
    /**
     * 设备的cash文件大小
     */
    private String appLogSize;
    /**
     * 设备类型  xiaomi 1
     */
    private String deviceType;
    /**
     * 设备版本  android 9.0
     */
    private String deviceSystemVersion;
    /**
     * 设备产品公司  xiaomi
     */
    private String deviceCompanyInfo;
    /**
     * app名称 xBetween
     */
    private String appName;

    /**
     * app版本 1.0.1-build
     */
    private String appVersion;

    public String getDeviceCpuInfo() {
        return deviceCpuInfo;
    }

    public void setDeviceCpuInfo(String deviceCpuInfo) {
        this.deviceCpuInfo = deviceCpuInfo;
    }

    public DeviceDiskInfo getDeviceDiskInfo() {
        return deviceDiskInfo;
    }

    public void setDeviceDiskInfo(DeviceDiskInfo deviceDiskInfo) {
        this.deviceDiskInfo = deviceDiskInfo;
    }

    public String getDeviceMemoryInfo() {
        return deviceMemoryInfo;
    }

    public void setDeviceMemoryInfo(String deviceMemoryInfo) {
        this.deviceMemoryInfo = deviceMemoryInfo;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceNetworkInfo() {
        return deviceNetworkInfo;
    }

    public void setDeviceNetworkInfo(String deviceNetworkInfo) {
        this.deviceNetworkInfo = deviceNetworkInfo;
    }

    public String getAppLogSize() {
        return appLogSize;
    }

    public void setAppLogSize(String appLogSize) {
        this.appLogSize = appLogSize;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceSystemVersion() {
        return deviceSystemVersion;
    }

    public void setDeviceSystemVersion(String deviceSystemVersion) {
        this.deviceSystemVersion = deviceSystemVersion;
    }

    public String getDeviceCompanyInfo() {
        return deviceCompanyInfo;
    }

    public void setDeviceCompanyInfo(String deviceCompanyInfo) {
        this.deviceCompanyInfo = deviceCompanyInfo;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    /**
     * 硬盘的使用情况
     */
    public static class DeviceDiskInfo{

        private String total;
        private String used;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getUsed() {
            return used;
        }

        public void setUsed(String used) {
            this.used = used;
        }
    }

}
