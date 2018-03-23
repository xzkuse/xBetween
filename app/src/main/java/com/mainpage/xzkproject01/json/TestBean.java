package com.mainpage.xzkproject01.json;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */

public class TestBean {

    private int aid;
    private boolean bid;
    private float cid;//解析异常  1.0
    private String did;//解析异常  x
    private double eid;
    private long fid;
    private int gid;
    private String name;
    private TestA obj;//包含对象
    private List<TestB> objList;//包含集合

    public static class TestA {
        private int a1;

        public int getA1() {
            return a1;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        @Override
        public String toString() {
            return "TestA{" +
                    "a1=" + a1 +
                    '}';
        }
    }

    public static class TestB {
        private int a2;

        public int getA2() {
            return a2;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }

        @Override
        public String toString() {
            return "TestB{" +
                    "a2=" + a2 +
                    '}';
        }
    }

    public List<TestB> getObjList() {
        return objList;
    }

    public void setObjList(List<TestB> objList) {
        this.objList = objList;
    }

    public TestA getObj() {
        return obj;
    }

    public void setObj(TestA obj) {
        this.obj = obj;
    }

    public boolean isBid() {
        return bid;
    }

    public void setBid(boolean bid) {
        this.bid = bid;
    }

    public float getCid() {
        return cid;
    }

    public void setCid(float cid) {
        this.cid = cid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public double getEid() {
        return eid;
    }

    public void setEid(double eid) {
        this.eid = eid;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "aid=" + aid +
                ", bid=" + bid +
                ", cid=" + cid +
                ", did=" + did +
                ", eid=" + eid +
                ", fid=" + fid +
                ", gid=" + gid +
                ", name='" + name + '\'' +
                ", obj=" + obj +
                ", objList=" + objList +
                '}';
    }
}
