package Algoritmafinal;

import java.util.Scanner;

public class mdc extends mdcrapor
{

    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);

        //Login

        System.out.println("MDC sistemine bağlanıyor.. hoş geldin!");
        System.out.print("Kullanıcı adını girin: ");
        String username = sc.nextLine();

        System.out.print("Şifrenizi girin: ");
        String password = sc.nextLine();


        if (username.equals("Murat") && password.equals("123mrt123")) {
            System.out.println("Amir " + username + " yönetim paneline hoş geldin!");
            System.out.println("1: Şüpheli sorgulama | 2: Plaka sorgulama | 3: Rapor ekleme | 4: Görev belirle ");
            System.out.print(">>>> ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Sorgulanacak kişinin T.C. kimlik numarasını girin: ");
                    String tc = sc.next();

                    if (tc.equals("12345678901")) {
                        System.out.println("Ad: Ahmet Yılmaz");
                        System.out.println("Suç Kaydı: Hırsızlık (2022)");
                        System.out.println("Aranma Durumu: Aktif");
                    } else if (tc.equals("98765432109")) {
                        System.out.println("Ad: Elif Demir");
                        System.out.println("Suç Kaydı: Temiz");
                        System.out.println("Aranma Durumu: Yok");
                    } else {
                        System.out.println("Kayıt bulunamadı.");
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Plaka girin (örn: 34ABC123): ");
                    String plaka = sc.nextLine();
                    if (plaka.equalsIgnoreCase("34ABC123")) {
                        System.out.println("Araç Sahibi: Cem Karaca\nMarka: BMW\nÇalıntı Durumu: Hayır");
                    } else if (plaka.equalsIgnoreCase("06XYZ789")) {
                        System.out.println("Araç Sahibi: Sevim Kaya\nMarka: Mercedes\nÇalıntı Durumu: Çalıntı!");
                    } else {
                        System.out.println("Plaka bilgisi bulunamadı.");
                    }
                    break;
                case 3:
                    mdcrapor rapor = new mdcrapor();
                    System.out.print("Raporu yazan kişi: ");
                    rapor.raporu_yazan = sc.nextLine();
                    sc.nextLine();

                    System.out.print("Yaşanan olayın lokasyonunu girin: ");
                    rapor.lokasyon = sc.nextLine();

                    System.out.print("Yaşanan olayı girin: ");
                    rapor.satir = sc.nextLine();

                    System.out.print("Rapor tarihini girin (örn: 25/04/2025 18:45): ");
                    rapor.date = sc.nextLine();

                    System.out.println("Raporu yazan: " + username + "  | Olay: " + rapor.satir + "  | Lokasyon: "+ rapor.lokasyon + "  | Tarih: " + rapor.date);

                    break;
                case 4:
                    sc.nextLine();
                    System.out.println(" ---- Görev yeri belirleme  ----");
                    System.out.print("Görev vermek istediğiniz polisin adını girin: ");
                    String gorevalan = sc.nextLine();

                    System.out.print("Görev yerini girin: ");
                    String lokasyon = sc.nextLine();

                    System.out.println("TELSİZ: Memur " + gorevalan + ", " + username + " amir tarafından " + lokasyon +
                    " lokasyonuna görev için yönlendirildi");
                    break;

                default:
                    System.out.println("Geçersiz veri girdiğiniz için sistem kapatılıyor.");
                    break;
            }



        } else {
            System.out.println("Geçersiz kullanıcı adı veya şifre girdiğiniz için sistem kapatıldı!");
            return;
        }






    }

}
