package com.flawdemo.bridge.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.flawdemo.bridge.log.LogUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;

/**
 * @author xzk
 * @data 2018/9/7
 * @remark 设备信息
 */
public class DeviceInfoUtil {

    /**
     * 获取设备ip地址
     *
     * @return
     */
    public static String getLocalIpAddress(Context mContext) {
        try {
            NetworkInfo info = ((ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en
                        .hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr
                            .hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } else if (info.getType() == ConnectivityManager.TYPE_ETHERNET) {
                    return getEthernetIp();
                } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                    WifiManager wifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
                    WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                    return intToIp(wifiInfo.getIpAddress());
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
        return null;
    }

    /**
     * 拼接 ip地址
     *
     * @param ipInt
     * @return
     */
    public static String intToIp(int ipInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipInt & 0xFF).append(".");
        sb.append((ipInt >> 8) & 0xFF).append(".");
        sb.append((ipInt >> 16) & 0xFF).append(".");
        sb.append((ipInt >> 24) & 0xFF);
        return sb.toString();
    }

    /**
     * 获取以太网 ip
     */
    private static String getEthernetIp() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        if (!inetAddress.getHostAddress().contains("::")) {
                            return inetAddress.getHostAddress();
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Exception ex) {
            LogUtils.e(ex);
        }
        return null;
    }

    /**
     * 获取目标cpu情况
     *
     * @return
     */
    public static String getCpuInfo() {
        StringBuilder sbr = new StringBuilder();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String[] supportedAbis = Build.SUPPORTED_ABIS;
            if (supportedAbis != null && supportedAbis.length > 1) {
                sbr.append(supportedAbis[0] + ":" + Runtime.getRuntime().availableProcessors() + "核");
            }
        } else {
            sbr.append(Build.CPU_ABI + ":" + Runtime.getRuntime().availableProcessors() + "核");
        }
        return sbr.toString();
    }

    /**
     * 获取CPU型号
     *
     * @return
     */
    public static String getCpuName() {
        String str1 = "/proc/cpuinfo";
        String str2 = "";
        try {
            FileReader fr = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(fr);
            while ((str2 = localBufferedReader.readLine()) != null) {
                if (str2.contains("Hardware")) {
                    return str2.split(":")[1];
                }
            }
            localBufferedReader.close();
        } catch (IOException e) {
        }
        return null;
    }

    /**
     * The IMEI: 仅仅只对Android手机有效
     * 采用此种方法，需要在AndroidManifest.xml中加入一个许可：android.permission.READ_PHONE_STATE，并且用
     * 户应当允许安装此应用。作为手机来讲，IMEI是唯一的，它应该类似于 359881030314356（除非你有一个没有量产的手
     * 机（水货）它可能有无效的IMEI，如：0000000000000）。
     *
     * @return imei
     */
    public static String getIMEI(Context mContext) {
        TelephonyManager TelephonyMgr = (TelephonyManager) mContext.getApplicationContext().getSystemService(
            Context.TELEPHONY_SERVICE);
        String szImei = TelephonyMgr.getDeviceId();
        return szImei;
    }

    /*
     * @return PesudoUniqueID
     */
    public static String getPesudoUniqueID() {
        //we make this look like a valid IMEI //13 digits
        String m_szDevIDShort =
            "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 +
            Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +
            Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 +
            Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +
            Build.USER.length() % 10;
        return m_szDevIDShort;
    }

    /**
     * 得到本机Mac地址
     *
     * @param mContext
     * @return
     */
    public static String getWLANMACAddress(Context mContext) {
        WifiManager wm = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        String m_szWLANMAC = wm.getConnectionInfo().getMacAddress();
        return m_szWLANMAC;
    }

    /*
     * @return
     */
    public static String getUniqueID(Context mContext) {
        String m_szLongID = getPesudoUniqueID() + getWLANMACAddress(mContext);
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.update(m_szLongID.getBytes(), 0, m_szLongID.length());
        byte p_md5Data[] = m.digest();
        String m_szUniqueID = new String();
        for (int i = 0; i < p_md5Data.length; i++) {
            int b = (0xFF & p_md5Data[i]);
            if (b <= 0xF) {
                m_szUniqueID += "0";
            }
            m_szUniqueID += Integer.toHexString(b);
        }
        m_szUniqueID = m_szUniqueID.toUpperCase();
        return m_szUniqueID;
    }

}
