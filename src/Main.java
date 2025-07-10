import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int islem=0;

        System.out.println("---Kafe Yönetim Paneline Hoşgeldiniz---");
        System.out.print("Bakiyenizi girin:");
        int bakiye = scanner.nextInt();
        String [] yiyecekListesi = {"Gözleme","Patates Kızartması","Kaşarlı Tost","Sandviç","Poğaça"};
        int [] yiyecekFiyat= {60,55,40,45,20};
        String [] icecekListesi = {"Türk Kahvesi","Su","Çay","Limonata","Meyve Suyu"};
        int [] icecekFiyat = {54,10,15,25,20};
        String [] siparisListesi = new String[20];
        int [][] siparisFis= new int [20][2];
        int index=0;
        while(islem !=4){
            System.out.println("Bakiyeniz:"+bakiye);
            System.out.println("1-Yiyecekleri Listele");
            System.out.println("2-İçecekleri Listele");
            System.out.println("3-Siparişini görüntüle");
            System.out.println("4-Sistemden çıkış yap");
            System.out.print("İşlem numarası girin:");
            islem=scanner.nextInt();
            if(islem==1){
                System.out.println("---Yiyecek Listesi---");
                for(int i=0;i<yiyecekListesi.length;i++){
                    System.out.println(i+1+"."+yiyecekListesi[i]+"   ->"+yiyecekFiyat[i]+"TL");
                }
                System.out.println("Siparis vermek istediğin ürün kodunu girin:");
                int kod = scanner.nextInt();
                System.out.println("Adet giriniz:");
                int adet = scanner.nextInt();

                if(adet*yiyecekFiyat[kod-1]>=bakiye){
                    System.out.println("Bakiye yetersiz");
                }else if ( kod<=0 || kod> yiyecekListesi.length ){
                    System.out.println("Geçersiz ürün kodu");
                }else {
                    siparisListesi[index]= yiyecekListesi[kod-1];
                    siparisFis[index][0]= adet;
                    siparisFis [index][1] = adet*yiyecekFiyat[kod-1];
                    bakiye -= adet*yiyecekFiyat[kod-1];
                    index ++;
                }

            }else if (islem ==2){
                System.out.println("---Icecek Listesi---");
                for(int i=0;i<icecekListesi.length;i++){
                    System.out.println(i+1+"."+icecekListesi[i]+"   ->"+icecekFiyat[i]+"TL");
                }
                System.out.println("Siparis vermek istediğin ürün kodunu girin:");
                int kod = scanner.nextInt();
                System.out.println("Adet giriniz:");
                int adet = scanner.nextInt();

                if(adet*icecekFiyat[kod-1]>=bakiye){
                    System.out.println("Bakiye yetersiz");
                }else if ( kod<=0 || kod>icecekListesi.length ){
                    System.out.println("Geçersiz ürün kodu");
                }else {
                    siparisListesi[index]= icecekListesi[kod-1];
                    siparisFis[index][0]= adet;
                    siparisFis [index][1] = adet*icecekFiyat[kod-1];
                    bakiye -= adet*icecekFiyat[kod-1];
                    index ++;
                }
            }else if (islem ==3){
                System.out.println("---Siparis Fisi ---");
                for(int i=0;i<siparisListesi.length;i++){
                    if(siparisListesi[i] != null){
                        System.out.println(siparisFis[i][0]+"x  "+siparisListesi[i]+"  "+siparisFis[i][1]+"TL");
                    }
                }
            }else if( islem == 4){
                break;
            }else {
                System.out.println("Gecersiz islem numarası");
            }
        }


    }
}