package pkgfinal.project;

import java.util.ArrayList;

public abstract class Nasabah {
    protected int id_nasabah;
    protected String nama;
    protected String alamat;
    protected ArrayList <Rekening> rekening = new ArrayList <Rekening>();

    public int getId_nasabah() {
        return id_nasabah;
    }

    public void setId_nasabah(int id_nasabah) {
        this.id_nasabah = id_nasabah;
    }

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

    public Nasabah(int id_nasabah, String nama, String alamat, ArrayList<Rekening> rekening) {
        this.id_nasabah = id_nasabah;
        this.nama = nama;
        this.alamat = alamat;
        this.rekening = rekening;
    }
    public Nasabah(int id_nasabah, String nama, String alamat, Rekening rekening) {
        try{
            this.id_nasabah = id_nasabah;
            this.nama = nama;
            this.alamat = alamat;
            this.rekening.add(rekening);
        }
        catch(NullPointerException ex){
            System.out.println(ex);
        }
    }

    public abstract void print();
}
