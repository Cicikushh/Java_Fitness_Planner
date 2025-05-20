import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Egzersiz {
    static Scanner input = new Scanner(System.in);

    public static void kaloriHesapla(int uyeId) {
        System.out.print("Egzersiz süresi (dakika): ");
        int dakika = input.nextInt();
        int kalori = dakika * 5;

        System.out.println("Yaklaşık kalori: " + kalori + " kcal");
        kaydetKalori(uyeId, dakika, kalori);
        SporProgrami.sporOnerisiYap(kalori);
    }

    private static void kaydetKalori(int uyeId, int dakika, int kalori) {
        try (Connection conn = Database.connect()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO egzersiz_kayitlari (uye_id, dakika, kalori) VALUES (?, ?, ?)");
            ps.setInt(1, uyeId);
            ps.setInt(2, dakika);
            ps.setInt(3, kalori);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}