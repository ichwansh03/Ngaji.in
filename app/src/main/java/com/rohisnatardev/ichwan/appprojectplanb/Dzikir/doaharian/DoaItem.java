package com.rohisnatardev.ichwan.appprojectplanb.Dzikir.doaharian;

public class DoaItem {

    private String namadoa;
    private String doaarab;
    private String doalatin;
    private String doaarti;
    private boolean expandDoa;

    public String getNamadoa() {
        return namadoa;
    }

    public String getDoaarab() {
        return doaarab;
    }

    public String getDoalatin() {
        return doalatin;
    }

    public String getDoaarti() {
        return doaarti;
    }

    public boolean isExpandDoa() {
        return expandDoa;
    }

    public void setExpandDoa(boolean expandDoa) {
        this.expandDoa = expandDoa;
    }

    public DoaItem(String namadoa, String doaarab, String doalatin, String doaarti) {
        this.namadoa = namadoa;
        this.doaarab = doaarab;
        this.doalatin = doalatin;
        this.doaarti = doaarti;
        this.expandDoa = false;
    }

    @Override
    public String toString(){
        return "Nama{"+
                ", doaarab='"+ doaarab + '\'' +
                ", doaarab='"+ doalatin + '\'' +
                ", doaarti='"+ doaarti + '\'' +
                ", expandeddoa=" + expandDoa + '}';
    }
}
