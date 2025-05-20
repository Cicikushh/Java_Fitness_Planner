import java.sql.*;
import java.util.Scanner;

public class Kullanici {
    static Scanner input = new Scanner(System.in);

    public static void uyeOl() {
        try (Connection conn = Database.connect()) {
            System.out.print("İsim: ");
            String isim = input.nextLine();
            System.out.print("Öğrenci No: ");
            String ogrNo = input.nextLine();
            System.out.print("Şifre: ");
            String sifre = input.nextLine();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO uyeler (isim, ogrenci_no, sifre) VALUES (?, ?, ?)");
            ps.setString(1, isim);
            ps.setString(2, ogrNo);
            ps.setString(3, sifre);
            ps.executeUpdate();

            System.out.println("Üyelik başarılı!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int girisYap() {
        try (Connection conn = Database.connect()) {
            System.out.print("Öğrenci No: ");
            String ogrNo = input.nextLine();
            System.out.print("Şifre: ");
            String sifre = input.nextLine();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM uyeler WHERE ogrenci_no = ? AND sifre = ?");
            ps.setString(1, ogrNo);
            ps.setString(2, sifre);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Giriş başarılı. Hoş geldiniz, " + rs.getString("isim"));
                return rs.getInt("uye_id");
            } else {
                System.out.println("Hatalı giriş.");
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}