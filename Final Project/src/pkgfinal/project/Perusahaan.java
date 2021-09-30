package pkgfinal.project;


import java.util.ArrayList;

public class Perusahaan extends Nasabah {
    private String nib;

    public Perusahaan(String nib, int id_nasabah, String nama, String alamat, ArrayList<Rekening> rekening) {
        super(id_nasabah, nama, alamat, rekening);
        this.nib = nib;
    }
    
    public String getNib() {
        return nib;
    }
    public void setNib(String nib) {
        this.nib = nib;
    }
    
    @Override
    public void print() {
        System.out.println("Nama: "+nama);
        System.out.println("Alamat: "+alamat);
        System.out.println("NIB: "+nib);
        System.out.println("===========================================");
        System.out.println("No Rekening                     Saldo");
        System.out.println("===========================================");
        
        for(int i=0;i<rekening.size();i++){
            System.out.printf("%d  %32.2f\n", rekening.get(i).getNoRekening(),rekening.get(i).getSaldo());
        }
        
    }    
}
