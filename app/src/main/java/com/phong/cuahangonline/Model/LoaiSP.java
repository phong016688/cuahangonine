package com.phong.cuahangonline.Model;

public class LoaiSP {
    private int id;
    private String tenloaisp;
    private String hinhanhloaisp;

    public LoaiSP(int id, String tenloaisp, String hinhanhloaisp) {
        this.id = id;
        this.tenloaisp = tenloaisp;
        this.hinhanhloaisp = hinhanhloaisp;
    }

    @Override
    public String toString() {
        return "LoaiSP{" +
                "id=" + id +
                ", tenloaisp='" + tenloaisp + '\'' +
                ", hinhanhloaisp='" + hinhanhloaisp + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenloaisp(String tenloaisp) {
        this.tenloaisp = tenloaisp;
    }

    public void setHinhanhloaisp(String hinhanhloaisp) {
        this.hinhanhloaisp = hinhanhloaisp;
    }

    public int getId() {
        return id;
    }

    public String getTenloaisp() {
        return tenloaisp;
    }

    public String getHinhanhloaisp() {
        return hinhanhloaisp;
    }
}
