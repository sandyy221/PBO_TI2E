package backend;

import java.sql.*;

public class DBHelper {
    private static Connection koneksi;

    public static void bukaKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:postgresql://localhost:5432/dbperpus";
                String user = "postgres";
                String password = "sandy1";

                DriverManager.registerDriver(new org.postgresql.Driver());

                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error koneksi!");
                t.printStackTrace();
            }
        }
    }

    public static int insertQueryGetId(String query) {
    bukaKoneksi();
    int result = -1;

    try {
        Statement stmt = koneksi.createStatement();

        // Jika query sudah mengandung "RETURNING" -> executeQuery dan ambil kolom pertama
        if (query.toUpperCase().contains("RETURNING")) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
        } else {
            // Coba pakai getGeneratedKeys()
            int affected = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                result = rs.getInt(1);
            }
            if (rs != null) rs.close();
        }

        stmt.close();
    } catch (Exception e) {
        e.printStackTrace();
        result = -1;
    }

    return result;
}


    public static boolean executeQuery(String query) {
        bukaKoneksi();
        boolean result = false;

        try {
            Statement stmt = koneksi.createStatement();
            stmt.executeUpdate(query);
            result = true;
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ResultSet selectQuery(String query) {
        bukaKoneksi();
        ResultSet rs = null;

        try {
            Statement stmt = koneksi.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
}