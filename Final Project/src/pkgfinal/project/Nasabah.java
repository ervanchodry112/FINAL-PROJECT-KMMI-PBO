package pkgfinal.project;

import java.util.ArrayList;

public abstract class Nasabah {
    protected String nama;
    protected String alamat;
    protected ArrayList <Rekening> rekening;

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public ArrayList<Rekening> getRekening() {
        return rekening;
    }
    public void setRekening(ArrayList<Rekening> rekening) {
        this.rekening = rekening;
    }

    public Nasabah(String nama, String alamat, ArrayList<Rekening> rekening) {
        this.nama = nama;
        this.alamat = alamat;
        this.rekening = rekening;
    };

    public abstract void print();
}
