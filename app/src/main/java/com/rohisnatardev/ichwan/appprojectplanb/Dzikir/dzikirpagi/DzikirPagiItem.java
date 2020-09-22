package com.rohisnatardev.ichwan.appprojectplanb.Dzikir.dzikirpagi;

public class DzikirPagiItem {
    private String namabacaan;
    private String jmlbaca;
    private String dzikirarab;
    private String dzikirlatin;
    private String dzikirarti;
    private boolean expand;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getNamabacaan() {
        return namabacaan;
    }

    public String getJmlbaca() {
        return jmlbaca;
    }

    public String getDzikirarab() {
        return dzikirarab;
    }

    public String getDzikirlatin() {
        return dzikirlatin;
    }

    public String getDzikirarti() {
        return dzikirarti;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public DzikirPagiItem(String namabacaan, String jmlbaca, String dzikirarab, String dzikirlatin, String dzikirarti) {
        this.namabacaan = namabacaan;
        this.jmlbaca = jmlbaca;
        this.dzikirarab = dzikirarab;
        this.dzikirlatin = dzikirlatin;
        this.dzikirarti = dzikirarti;
        this.expand = false;
    }

    @Override
    public String toString(){
        return "Nama{"+
                ", jmlbaca='"+ jmlbaca + '\'' +
                ", dzikirarab='"+ dzikirarab + '\'' +
                ", dzikirlatin='"+ dzikirlatin + '\'' +
                ", dzikirarti='"+ dzikirarti + '\'' +
                ", expanded=" + expand + '}';
    }
}
