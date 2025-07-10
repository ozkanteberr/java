import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose=0,sTotal=0;

        String [] products = {"Ekmek","Yumurta(30)","Bakliyat K.","Dondurma","Cips","Su"};
        double [] prices = {25,160,380,65,45,10};

        ArrayList<String> order= new ArrayList<>();
        ArrayList<Double> total= new ArrayList<>();
        ArrayList<Integer> quantity= new ArrayList<>();

        System.out.print("Bakiyenizi girin:");
        int balance =scanner.nextInt();

        while(choose!=5){
            System.out.println("---Sanal Markete Hoşgeldin---");
            System.out.println("Bakiye:"+ balance);
            menuyuListele();
            System.out.print("İşlem numarası girin:");
            choose=scanner.nextInt();

            switch(choose){
                case 1:
                    urunleriListele(products,prices);
                   break;
                case 2:
                    urunleriListele(products,prices);
                    urunEkle(products,prices,order,total,quantity);

                break;
                case 3:
                    sepetiGoruntule(order,total,quantity);
                    break;
                case 4:
                    odemeYap(balance,sTotal,total);
                    break;
                case 5:
                    System.out.println("Çıkış yapıldı,görüşmek üzere");
                    break;
                default:
                    System.out.println("Geçersiz işlem numarası");
                    break;
            }
        }
    }
    public static void menuyuListele(){
        System.out.println("1.Ürünleri Listele");
        System.out.println("2.Sepete Ekle");
        System.out.println("3.Sepeti Görüntüle");
        System.out.println("4.Ödeme Yap");
        System.out.println("5.Çıkış Yap!");
    }
    public static void urunleriListele(String [] products,double [] prices){
        for(int i=0;i< products.length;i++){
            System.out.println(i+1 + ".   "+products[i] + "  -> "+ prices[i]+"TL");
        }
    }

    public static void urunEkle(String [] products,double [] prices,ArrayList<String>order,ArrayList<Double> total,ArrayList<Integer> quantity){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Septenize eklemek istediğiniz ürün kodunu girin:");
        int productId=scanner.nextInt();
        if(productId<0 || productId>products.length){
            System.out.println("Geçersiz ürün numarası!");
        }else{
            System.out.print("Adet girin:");
            int quanty=scanner.nextInt();
            if(quanty<0){
                System.out.println("0'Dan büyük deger giriniz!");
            }else{
                order.add(products[productId-1]);
                total.add(prices[productId-1]*quanty);
                quantity.add(quanty);
            }

        }
    }
    public static void sepetiGoruntule(ArrayList<String>order,ArrayList<Double> total,ArrayList<Integer> quantity){
        int sTotal=0;
        System.out.println("---Sepetim---");
        System.out.println("Adet     ÜrünAdı    Fiyat");
        System.out.println("----     -------    -----");
        for(int i=0;i<order.toArray().length;i++){
            System.out.println(quantity.get(i)+"        "+order.get(i)+"     "+total.get(i));
            sTotal+=total.get(i);
        }
        System.out.println("Total:              "+sTotal);
    }
    public static void odemeYap(int balance,double sTotal,ArrayList<Double> total){
        Scanner scanner=new Scanner(System.in);
        for(double pPrice:total){
            sTotal+=pPrice;
        }
        if(balance>=sTotal){
            System.out.print("Sepeti onaylıyor musunuz(e-h):");
            String ans=scanner.nextLine();
            if(ans.equalsIgnoreCase("e")){
                System.out.println("Ödeme yapıldı,teşekkür ederiz");
                balance-=sTotal;
            }else{
                System.out.println("Ödeme yapılmadı!");
            }
        }else{
            System.out.println("Bakiyeniz yetersiz ödeme yapılamaz!");
        }
    }

}