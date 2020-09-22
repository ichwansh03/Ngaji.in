package com.rohisnatardev.ichwan.appprojectplanb.Hijaiyah;

public class IqraItem {
    private String huruf;
    private String exHuruf;
    private String sifat;
    private int audio;
    private boolean expanded;

    public IqraItem(String huruf, String exHuruf, String sifat, int audio) {
        this.huruf = huruf;
        this.exHuruf = exHuruf;
        this.sifat = sifat;
        this.audio = audio;
        this.expanded = false;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getHuruf() {
        return huruf;
    }

    public void setHuruf(String huruf) {
        this.huruf = huruf;
    }

    public String getExHuruf() {
        return exHuruf;
    }

    public void setExHuruf(String exHuruf) {
        this.exHuruf = exHuruf;
    }

    public String getSifat() {
        return sifat;
    }

    public void setSifat(String sifat) {
        this.sifat = sifat;
    }

    @Override
    public String toString(){
        return "Sifat{"+
                ", contoh='"+ exHuruf + '\'' +
                ", audio='"+ audio + '\'' +
                ", sifat='"+ sifat + '\'' +
                ", expanded=" + expanded + '}';
    }
}
