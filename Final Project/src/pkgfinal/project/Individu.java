package pkgfinal.project;


import java.util.ArrayList;

public class Individu extends Nasabah {

    private long nik;
    private long npwp;

    public Individu(long nip, long npwp, String nama, String alamat, ArrayList<Rekening> rekening){
        super(nama, alamat, rekening);
        this.nik = nip;
        this.npwp = npwp;
    }

    public long getNpwp() {
        return npwp;
    }

    public void setNpwp(long npwp) {
        this.npwp = npwp;
    }

    public long getNik() {
        return nik;
    }

    public void setNik(long nik) {
        this.nik = nik;
    }
    
    @Override
    public void print() {
        System.out.println("Nama: "+nama);
        System.out.println("Alamat: "+alamat);
        System.out.println("NIK: "+nik);
        System.out.println("NPWP: "+npwp);
        System.out.println("===========================================");
        System.out.println("No Rekening                     Saldo");
        System.out.println("===========================================");
        
        for(int i=0;i<rekening.size();i++){
            System.out.printf("%d  %32.2f\n", rekening.get(i).getNoRekening(),rekening.get(i).getSaldo());
        }

    }
    
}
