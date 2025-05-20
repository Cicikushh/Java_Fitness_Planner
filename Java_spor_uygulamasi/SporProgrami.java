import java.util.Random;

public class SporProgrami {
    public static void sporOnerisiYap(int kalori) {
        if (kalori <= 100)
            System.out.println("Öneri: Yürüyüş");
        else if (kalori <= 200)
            System.out.println("Öneri: Koşu");
        else if (kalori <= 300)
            System.out.println("Öneri: Bisiklet");
        else if (kalori <= 400)
            System.out.println("Öneri: Yüzme");
        else if (kalori <= 500)
            System.out.println("Öneri: Fonksiyonel Antrenman");
        else if (kalori <= 600)
            System.out.println("Öneri: Kuvvet Antrenmanı");
        else
            System.out.println("Öneri: HIIT");
    }

    public static void haftalikPlaniGoster() {
        String[] gunler = {"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar"};
        String[] aktiviteler = {"Yürüyüş", "Koşu", "Bisiklet", "Yüzme", "Fonksiyonel Antrenman", "Kuvvet Antrenmanı", "HIIT"};

        Random rand = new Random();
        for (String gun : gunler) {
            int sec = rand.nextInt(aktiviteler.length);
            System.out.println(gun + " → " + aktiviteler[sec]);
        }
    }
}