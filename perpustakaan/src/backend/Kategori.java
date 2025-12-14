package backend;

import java.util.ArrayList;
import java.sql.*;

public class Kategori {
    private int idkategori;

    public int getIdkategori() {
        return idkategori;
    }

    public void setIdkategori(int idkategori) {
        this.idkategori = idkategori;
    }

    private String nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    private String keterangan;

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Kategori() {

    }

    public Kategori(String nama, String keterangan) {
        this.nama = nama;
        this.keterangan = keterangan;
    }
    @Override
    public String toString() {
        return this.nama != null ? this.nama : "";
    }

    public Kategori getById(int id) {
        Kategori kat = new Kategori();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM kategori "
                + " WHERE idkategori = '" + id + "'");

        try {
            while (rs.next()) {
                kat = new Kategori();
                kat.setIdkategori(rs.getInt("idkategori"));
                kat.setNama(rs.getString("nama"));
                kat.setKeterangan(rs.getString("keterangan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kat;
    }

    public ArrayList<Kategori> getAll() {
        ArrayList<Kategori> ListKategori = new ArrayList<>();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM kategori");

        try {
            while (rs.next()) {
                Kategori kat = new Kategori();
                kat.setIdkategori(rs.getInt("idkategori"));
                kat.setNama(rs.getString("nama"));
                kat.setKeterangan(rs.getString("keterangan"));

                ListKategori.add(kat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListKategori;
    }

    public ArrayList<Kategori> search(String keyword) {
        ArrayList<Kategori> ListKategori = new ArrayList<>();

        String sql = "SELECT * FROM kategori WHERE "
                + " nama LIKE '%" + keyword + "%'"
                + " OR keterangan LIKE '%" + keyword + "%'";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Kategori kat = new Kategori();
                kat.setIdkategori(rs.getInt("idkategori"));
                kat.setNama(rs.getString("nama"));
                kat.setKeterangan(rs.getString("keterangan"));

                ListKategori.add(kat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListKategori;
    }

    public void save() {
    if (this.idkategori == 0) { // baru
        String query = "INSERT INTO kategori (nama, keterangan) " +
                       "VALUES ('" + this.nama.replace("'", "''") + "', '" + this.keterangan.replace("'", "''") + "')" +
                       " RETURNING idkategori;";
        int newId = DBHelper.insertQueryGetId(query);
        if (newId != -1) {
            this.idkategori = newId;
        } else {
            System.out.println("Gagal insert kategori");
        }
    } else { // update
        String query = "UPDATE kategori SET nama = '" + this.nama.replace("'", "''") +
                       "', keterangan = '" + this.keterangan.replace("'", "''") +
                       "' WHERE idkategori = " + this.idkategori;
        DBHelper.executeQuery(query);
    }
}


    public void delete() {
        String SQL = "DELETE FROM kategori WHERE idkategori = '" + this.idkategori + "'";
        DBHelper.executeQuery(SQL);
    }

}
