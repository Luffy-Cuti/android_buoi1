package com.example.sql;

public class SV {
    private String maLop;
    private String tenLop;
    private int siSo;

    public SV(String maLop, String tenLop, int siSo) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.siSo = siSo;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }
    public String toString(){
        return "Ma lop" + maLop + "Ten lop" + tenLop + "Si so" + siSo;
    }
}
