package com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatNonLawan;

public class SifatNonLawan {

    public String getTitleTv() {
        return titleTv;
    }

    public String getDescTv() {
        return descTv;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }
    private String titleTv;
    private String descTv;
    private boolean expandable;

    public SifatNonLawan(String titleTv, String descTv){
        this.titleTv = titleTv;
        this.descTv = descTv;
        this.expandable = false;
    }
    public String toString(){
        return "Sifat{"+
                ", deskripsi='"+ descTv + '\'' +
                ", expanded=" + expandable + '}';
    }
}
