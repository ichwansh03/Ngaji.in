package com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatJamak;

public class SifatJamakItem {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    private String title;
    private String desc;
    private boolean expanded;

    public SifatJamakItem(String title, String desc){
        this.title = title;
        this.desc = desc;
        this.expanded = false;
    }
    @Override
    public String toString(){
        return "Sifat{"+
                ", deskripsi='"+ desc + '\'' +
                ", expanded=" + expanded + '}';
    }
}
