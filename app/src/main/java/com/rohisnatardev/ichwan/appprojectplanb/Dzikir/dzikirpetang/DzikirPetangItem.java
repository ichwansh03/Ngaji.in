package com.rohisnatardev.ichwan.appprojectplanb.Dzikir.dzikirpetang;

public class DzikirPetangItem {
    private String namadpetang;
    private String jmldpetang;
    private String arabdpetang;
    private String latindpetang;
    private String artidpetang;
    private boolean expandPetang;
    private boolean checkedpt;

    public boolean isCheckedpt() {
        return checkedpt;
    }

    public void setCheckedpt(boolean checkedpt) {
        this.checkedpt = checkedpt;
    }

    public String getNamadpetang() {
        return namadpetang;
    }

    public String getJmldpetang() {
        return jmldpetang;
    }

    public String getArabdpetang() {
        return arabdpetang;
    }

    public String getLatindpetang() {
        return latindpetang;
    }

    public String getArtidpetang() {
        return artidpetang;
    }

    public boolean isExpandPetang() {
        return expandPetang;
    }

    public void setExpandPetang(boolean expandPetang) {
        this.expandPetang = expandPetang;
    }

    public DzikirPetangItem(String namadpetang, String jmldpetang, String arabdpetang, String latindpetang, String artidpetang) {
        this.namadpetang = namadpetang;
        this.jmldpetang = jmldpetang;
        this.arabdpetang = arabdpetang;
        this.latindpetang = latindpetang;
        this.artidpetang = artidpetang;
        this.expandPetang = false;
    }

    @Override
    public String toString(){
        return "Nama{"+
                ", jmlbaca='"+ jmldpetang + '\'' +
                ", dzikirarab='"+ arabdpetang + '\'' +
                ", dzikirlatin='"+ latindpetang + '\'' +
                ", dzikirarti='"+ artidpetang + '\'' +
                ", expanded=" + expandPetang + '}';
    }
}
