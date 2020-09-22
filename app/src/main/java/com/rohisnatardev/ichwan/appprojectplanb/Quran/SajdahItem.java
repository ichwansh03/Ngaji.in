package com.rohisnatardev.ichwan.appprojectplanb.Quran;

public class SajdahItem {
    private boolean expanded;
    private String surah;
    private String ayat;
    private String arti;

    public SajdahItem(String surah, String ayat, String arti) {
        this.surah = surah;
        this.ayat = ayat;
        this.arti = arti;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getSurah() {
        return surah;
    }

    public void setSurah(String surah) {
        this.surah = surah;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }

    @Override
    public String toString(){
        return "Sifat{"+
                ", ayat='"+ ayat + '\'' +
                ", arti='"+ arti + '\''+
                ", expanded=" + expanded + '}';
    }
}
