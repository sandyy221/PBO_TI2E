package backend;

import java.util.ArrayList;
import java.sql.*;

public class Anggota {
    private int idanggota;
    private String nama;
    private String alamat;
    private String telepon;

    public Anggota() {
    }

    public Anggota(String nama, String alamat, String telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public int getIdanggota() {
        return idanggota;
    }

    public void setIdanggota(int idanggota) {
        this.idanggota = idanggota;
    }

    public String getnama() {
        return nama;
    }

    public void setnama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Anggota getById(int id) {
        Anggota ang = new Anggota();
        ResultSet rs = DBHelper.selectQuery("select * from anggota where idanggota = '" + id + "'");

        try {
            while (rs.next()) {
                ang = new Anggota();
                ang.setIdanggota(rs.getInt("idanggota"));
                ang.setnama(rs.getString("nama"));
                ang.setAlamat(rs.getString("alamat"));
                ang.setTelepon(rs.getString("telepon"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ang;
    }

    public ArrayList<Anggota> getAll() {
        ArrayList<Anggota> ListAnggota = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("select * from anggota");

        try {
            while (rs.next()) {
                Anggota ang = new Anggota();
                ang.setIdanggota(rs.getInt("idanggota"));
                ang.setnama(rs.getString("nama"));
                ang.setAlamat(rs.getString("alamat"));
                ang.setTelepon(rs.getString("telepon"));
                ListAnggota.add(ang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListAnggota;
    }

    public ArrayList<Anggota> search(String keyword) {
        ArrayList<Anggota> ListAnggota = new ArrayList();

        String sql = "select * from anggota where " +
                "nama like '%" + keyword + "%' " +
                "or alamat like '%" + keyword + "%' " +
                "or telepon like '%" + keyword + "%'";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Anggota ang = new Anggota();
                ang.setIdanggota(rs.getInt("idanggota"));
                ang.setnama(rs.getString("nama"));
                ang.setAlamat(rs.getString("alamat"));
                ang.setTelepon(rs.getString("telepon"));
                ListAnggota.add(ang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListAnggota;
    }

    public void save() {
        if (getById(idanggota).getIdanggota() == 0) {
            String sql = "insert into anggota (nama, alamat, telepon) values(" +
                    "'" + this.nama + "'," +
                    "'" + this.alamat + "'," +
                    "'" + this.telepon + "')";
            this.idanggota = DBHelper.insertQueryGetId(sql);
        } else {
            String sql = "update anggota set " +
                    "nama = '" + this.nama + "'," +
                    "alamat = '" + this.alamat + "'," +
                    "telepon = '" + this.telepon + "' " +
                    "where idanggota = '" + this.idanggota + "'";
            DBHelper.executeQuery(sql);
        }
    }

    public void delete() {
        String sql = "delete from anggota where idanggota = '" + this.idanggota + "'";
        DBHelper.executeQuery(sql);
    }
}