package com.rohisnatardev.ichwan.appprojectplanb.Quran;

public class WaqafItem {
    private String title;
    private String overview;
    private boolean expand;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public WaqafItem(String title, String overview) {
        this.title = title;
        this.overview = overview;
        this.expand = false;
    }
    @Override
    public String toString(){
        return "Tanda{"+
                ", deskripsi='"+ overview + '\'' +
                ", expanded=" + expand + '}';
    }
}
