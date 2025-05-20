import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Giriş Yap\n2. Üye Ol\n0. Çıkış");
            String secim = input.nextLine();

            if (secim.equals("1")) {
                int uyeId = Kullanici.girisYap();
                if (uyeId != -1) {
                    menu(uyeId);
                }
            } else if (secim.equals("2")) {
                Kullanici.uyeOl();
            } else if (secim.equals("0")) {
                System.out.println("Çıkış yapılıyor.");
                break;
            } else {
                System.out.println("Geçersiz giriş.");
            }
        }
    }

    public static void menu(int uyeId) {
        while (true) {
            System.out.println("\n1. Kalori Hesapla\n2. Spor Önerisi Yap\n3. Haftalık Spor Programı Göster\n0. Çıkış");
            String secim = input.nextLine();

            switch (secim) {
                case "1":
                    Egzersiz.kaloriHesapla(uyeId);
                    break;
                case "2":
                    System.out.print("Tahmini kalori girin: ");
                    int kalori = input.nextInt();
                    input.nextLine();
                    SporProgrami.sporOnerisiYap(kalori);
                    break;
                case "3":
                    SporProgrami.haftalikPlaniGoster();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }
}