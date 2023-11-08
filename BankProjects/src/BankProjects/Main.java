package BankProjects;

import java.util.*;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		
		//array
		ArrayList<Bank> users = new ArrayList<>();
		users.add(new Bank("wildan", 1234, 4321, 500));
		users.add(new Bank("trf1", 1122, 2211, 1000));
		users.add(new Bank("trf2", 5678, 8765, 1000));
		
		//array konvensional
		//Bank[] users = new Bank[3];
		//users[0] = new Bank("Wildan", 1234, 4321, 500);
		//users[1] = new Bank("trf1", 1122, 2211, 1000000);
		//users[2] = new Bank("trf2", 5678, 8765, 1000000);
		
		boolean lanjut= true;
		
		while (lanjut) {
		System.out.println("Selamat datang di MyBank");
		System.out.println("");
			
		System.out.println("(1)LOGIN \n"  + "(2)DAFTAR \n");
		System.out.print("Pilih menu :"); 
		
			
		Scanner menu = new Scanner (System.in);
		Scanner scanner = new Scanner(System.in);
		
		int inputmenu = menu.nextInt();
		
		if (inputmenu == 2) {
			
			boolean lanjutdaft = true;

			
			System.out.print("Masukan nama baru : ");
			String inpname = scanner.nextLine();

			boolean namaSudahDigunakan = users.stream().anyMatch(user -> inpname.equalsIgnoreCase(user.getNamaNasabah()));

			if (namaSudahDigunakan) {
			    System.out.println("Nama sudah digunakan");
			    lanjutdaft = false;
			} else {
			    System.out.print("Buat rekening baru : ");
			    int inprek = scanner.nextInt();

			    
			    boolean rekSudahDigunakan = users.stream().anyMatch(user -> inprek == user.getRekNasabah());

			    if (rekSudahDigunakan) {
			        System.out.println("No Rekening sudah digunakan");
			        lanjutdaft = false;
			    } else {
			        System.out.print("Buat pin baru : ");
			        int inppw = scanner.nextInt();

			        System.out.print("Masukan jumlah saldo deposit : ");
			        int inpdepo = scanner.nextInt();

			        Bank Akunbaru = new Bank(inpname, inprek, inppw, inpdepo);
			        users.add(Akunbaru);
			        System.out.println("Pendaftaran berhasil untuk " + inpname);
			    }
			}
			System.out.print("Apakah Anda ingin kembali? (ya/tidak): ");
	        String answer = scanner.next();
	        lanjut = answer.equalsIgnoreCase("ya");
				
			}
		
			
		if (inputmenu == 1) {
		
		while(lanjut) {
		System.out.print("Masukan nama nasabah :");
		String inputNama = scanner.nextLine();
		boolean found = false;

		for (Bank user : users) {
			
			if (inputNama.equalsIgnoreCase(user.getNamaNasabah())) {
				found = true;
				
				System.out.print("Masukkan nomor rekening : ");
				int inputRekening = scanner.nextInt();

				
				if (inputRekening == user.getRekNasabah()) {

					// pin
					System.out.print("Masukan pin : ");
					int inputPin = scanner.nextInt();
					
					if (inputPin == user.getPinNasabah()) {
						System.out.println("     MENU");
						System.out.print("(1)Transfer \n" + "(2)Tarik tunai \n" + "(3)Cek Saldo \n"
								+ "(4)Tambah saldo\n" + "(5)Scan Qris\n");

						System.out.print("Pilih opsi : ");
						int trf = scanner.nextInt();

						if (trf == 1) {
							
							System.out.println("Saldo anda adalah Rp" + user.getIsiSaldo() );
							
							System.out.print("Masukan Nama Nasabah Yang Ingin Di tf : ");
							scanner.nextLine();
							String trfnasabah = scanner.nextLine();

							boolean y = false;

							for (Bank nsabah : users) {
								if (trfnasabah.equals(nsabah.getNamaNasabah())) {

									y = true;
												
									if 	(trfnasabah.equals(user.getNamaNasabah())) {
										System.out.println("Tidak bisa mentransfer ke Akun sendiri ");
										break;
									}
									
									System.out.print("Masukan nominal duit : ");
									int nomduit = scanner.nextInt();

									if (nomduit > user.getIsiSaldo()) {
										System.out.print("Saldo anda tidak cukup untuk melakukan transfer \n");
									}
									
									if (nomduit == nsabah.getIsiSaldo()) {
										user.setIsiSaldo(user.getIsiSaldo() - nomduit);
										nsabah.setIsiSaldo(nsabah.getIsiSaldo() + nomduit);
										System.out.println("Transfer berhasil sebesar Rp" + nomduit + " ke " + nsabah.getNamaNasabah());
									}
										
									else {
										user.setIsiSaldo(user.getIsiSaldo() - nomduit); 
						                nsabah.setIsiSaldo(nsabah.getIsiSaldo() + nomduit); 
						                System.out.println("Transfer berhasil sebesar Rp" + nomduit + " ke " + nsabah.getNamaNasabah());
									}
									break;
								}

							}
							if (!y) {
								System.out.print("Nama Nasabah tidak ditemukan ");
							}
							
						}if (trf == 2) {
							
							System.out.println("Saldo anda Adalah Rp" + user.getIsiSaldo());
							
							System.out.print("Masukan jumlah yang ingin di tarik : ");
							int tarik = scanner.nextInt();
							
							if (tarik < user.getIsiSaldo()) {
						        user.setIsiSaldo(user.getIsiSaldo() - tarik); 
						        System.out.print("Tarik saldo berhasil, Uang anda tinggal = " + user.getIsiSaldo() + "\n");
							}

							else if (tarik > user.getIsiSaldo()) {
								System.out.println("Saldo anda tidak cukup");						
							}
							
							else if (tarik == user.getIsiSaldo()) {
								user.setIsiSaldo(user.getIsiSaldo() - tarik);
								System.out.print("Tarik saldo berhasil, Uang anda tinggal = " + user.getIsiSaldo() + "\n");
							}

						}if (trf == 3) {
							System.out.print("Saldo anda adalah Rp" + user.getIsiSaldo() + "\n");

						}if (trf == 4) {
							System.out.print("Masukan nominal yang ingin ditambah : ");
							int ngisi = scanner.nextInt();
							
							user.setIsiSaldo(user.getIsiSaldo() + ngisi);

							System.out.print("Pengisian saldo berhasil. Saldo anda menjadi " + user.getIsiSaldo() + "\n");
						}if (trf == 5) {
							Frame frame = new Frame();
						}

					} else {
						System.out.println("Pin Salah ");
					}

				} else {
					System.out.println("Nomor rekening salah");
				} 
			}
		}
				
				
		if (!found) {
	        System.out.println("Nama Nasabah tidak ditemukan");
	        
	    }
			break;	
		}
		
		//solve
		System.out.print("Apakah Anda ingin kembali? (ya/tidak): ");
        String answer = scanner.next();
        lanjut = answer.equalsIgnoreCase("ya");
		
		}
	}
}
}
