package com.phong.cuahangonline.Model;

public class SanPham {
    long id;
    String tensanpham;
    long giasnpham;
    String hinhanhsanpham;
    String motasanpham;
    long idsanpham;

    public SanPham(long id, String tensanpham, long giasnpham, String hinhanhsanpham, String motasanpham, long idsanpham) {
        this.id = id;
        this.tensanpham = tensanpham;
        this.giasnpham = giasnpham;
        this.hinhanhsanpham = hinhanhsanpham;
        this.motasanpham = motasanpham;
        this.idsanpham = idsanpham;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public long getGiasnpham() {
        return giasnpham;
    }

    public void setGiasnpham(long giasnpham) {
        this.giasnpham = giasnpham;
    }

    public String getHinhanhsanpham() {
        return hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        this.hinhanhsanpham = hinhanhsanpham;
    }

    public String getMotasanpham() {
        return motasanpham;
    }

    public void setMotasanpham(String motasanpham) {
        this.motasanpham = motasanpham;
    }

    public long getIdsanpham() {
        return idsanpham;
    }

    public void setIdsanpham(long idsanpham) {
        this.idsanpham = idsanpham;
    }
}
