# FINAL PROJECT KMMI PBO

Anggota Kelompok :
1. Ervan Chodry            2017051001  (NasabahFormController, DataModel)
2. Muhammad Wafa AlAusath  2015061057  (UINasabahForm)
4. Safiira Rahma Linisa    2017051015  (UILogin, Login Controller)

# CLASS DIAGRAM
    class diagram
    Nasabah <|-- Individu
    Nasabah <|-- Perusahaan
    Nasabah "1"--o"*" Rekening : has
    
    class Nasabah{
      <<abstract>>
      #int id_nasabah
      #String nama
      #String alamat
      +int nextID()
    }
    
    class Individu{
      -long nik
      -long npwp
    }
    class Perusahaan{
      -String nib
    }
    class Rekening{
      -int no_rekening
      -double saldo
      +setorTunai(double amt)
      +tarikTunai(double amt)
      +double getSaldo()
    }
            
# Entity Relation Diagram
    erDiagram
          NASABAH ||..|| INDIVIDU : is
          NASABAH ||--|| PERUSAHAAN : is
          NASABAH ||--|{ REKENING: "has"
          NASABAH {
            int id_nasabah
            string nama
            string alamat
          }
          INDIVIDU{
            long nik
            long npwp
          }
          PERUSAHAAN{
            string nib
          }
          REKENING{
            int no_rekening
            double saldo
          }


# Tampilan pada saat login
![Screenshot 02_10_2021 19_05_39](https://user-images.githubusercontent.com/58065502/135715345-b200b473-be6c-461a-b02c-dbcfd6a2f12c.png)

# Tampilan di Tab Individu
![Screenshot 02_10_2021 19_05_47](https://user-images.githubusercontent.com/58065502/135715369-15572a5e-9589-428e-a672-0bf322352f4b.png)

# Tampilan di Tab Perusahaan
![Screenshot 02_10_2021 19_05_52](https://user-images.githubusercontent.com/58065502/135715419-d1415842-5b6b-460b-b137-b0ff2a8690e9.png)
