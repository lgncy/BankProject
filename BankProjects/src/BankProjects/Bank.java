package BankProjects;

public class Bank {
    private String NamaNasabah;
    private int RekNasabah;
    private int PinNasabah;
    private int IsiSaldo;

    Bank(String Nama_Nasabah, int Rek_Nasabah, int Pin_Nasabah, int Isi_Saldo) {
        this.NamaNasabah = Nama_Nasabah;
        this.RekNasabah = Rek_Nasabah;
        this.PinNasabah = Pin_Nasabah;
        this.IsiSaldo = Isi_Saldo;

    }

  
    public String getNamaNasabah() {
        return this.NamaNasabah;
        
    }

    public int getRekNasabah() {
        return this.RekNasabah;
    }

    public int getPinNasabah() {
        return this.PinNasabah;

    }

    public int getIsiSaldo() {
        return this.IsiSaldo;
    }

    
    public void setNamaNasabah(String NewNama) {
        this.NamaNasabah = NewNama;
    }

    public void setRekNasabah(int NewRek) {
        this.RekNasabah = NewRek;
    }

    public void setPinNasabah(int NewPin) {
        this.PinNasabah = NewPin;
    }

    public void setIsiSaldo(int NewSaldo) {
        this.IsiSaldo = NewSaldo;
    }
    
    public void setTrasfer(int newTrasfer) {
    	this.IsiSaldo += newTrasfer;
    }
    
    

}

