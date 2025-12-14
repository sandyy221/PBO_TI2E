package backend;

import java.util.ArrayList;
import java.sql.*;

public class Peminjaman {
    private int idpeminjaman;
    private Anggota anggota = new Anggota();
    private Buku buku = new Buku();
    private String tanggalpinjam;
    private String tanggalkembali;

    public Peminjaman() {
    }

    public Peminjaman(Anggota anggota, Buku buku, String tanggalpinjam, String tanggalkembali) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalpinjam = tanggalpinjam;
        this.tanggalkembali = tanggalkembali;
    }

    public int getIdpeminjaman() { 
        return idpeminjaman; 
    }
    
    public void setIdpeminjaman(int idpeminjaman) { 
        this.idpeminjaman = idpeminjaman; 
    }

    public Anggota getAnggota() { 
        return anggota; 
    }
    
    public void setAnggota(Anggota anggota) { 
        this.anggota = anggota; 
    }

    public Buku getBuku() { 
        return buku; 
    }
    
    public void setBuku(Buku buku) { 
        this.buku = buku; 
    }

    public String getTanggalpinjam() { 
        return tanggalpinjam; 
    }
    
    public void setTanggalpinjam(String tanggalpinjam) { 
        this.tanggalpinjam = tanggalpinjam; 
    }

    public String getTanggalkembali() { 
        return tanggalkembali; 
    }
    
    public void setTanggalkembali(String tanggalkembali) { 
        this.tanggalkembali = tanggalkembali; 
    }

    public Peminjaman getById(int id) {
        Peminjaman pen = new Peminjaman();
        String sql = "SELECT " +
                     "p.idpeminjaman, p.tanggalpinjam, p.tanggalkembali, " +
                     "p.idanggota, a.nama AS nama_anggota, " +
                     "p.idbuku, b.judul AS judul_buku " +
                     "FROM peminjaman p " +
                     "LEFT JOIN anggota a ON p.idanggota = a.idanggota " +
                     "LEFT JOIN buku b ON p.idbuku = b.idbuku " +
                     "WHERE p.idpeminjaman = " + id;

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                pen = new Peminjaman();
                pen.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pen.getAnggota().setIdanggota(rs.getInt("idanggota"));
                pen.getAnggota().setnama(rs.getString("nama_anggota"));
                pen.getBuku().setIdbuku(rs.getInt("idbuku"));
                pen.getBuku().setJudul(rs.getString("judul_buku"));
                pen.setTanggalpinjam(rs.getString("tanggalpinjam"));
                pen.setTanggalkembali(rs.getString("tanggalkembali"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pen;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList<>();

        String sql = "SELECT " +
                     "p.idpeminjaman, p.tanggalpinjam, p.tanggalkembali, " +
                     "p.idanggota, a.nama AS nama_anggota, " +
                     "p.idbuku, b.judul AS judul_buku " +
                     "FROM peminjaman p " +
                     "LEFT JOIN anggota a ON p.idanggota = a.idanggota " +
                     "LEFT JOIN buku b ON p.idbuku = b.idbuku";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Peminjaman pen = new Peminjaman();
                pen.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pen.getAnggota().setIdanggota(rs.getInt("idanggota"));
                pen.getAnggota().setnama(rs.getString("nama_anggota"));
                pen.getBuku().setIdbuku(rs.getInt("idbuku"));
                pen.getBuku().setJudul(rs.getString("judul_buku"));
                pen.setTanggalpinjam(rs.getString("tanggalpinjam"));
                pen.setTanggalkembali(rs.getString("tanggalkembali"));
                
                ListPeminjaman.add(pen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPeminjaman;
    }

    public ArrayList<Peminjaman> search(String keyword) {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList<>();

        String sql = "SELECT " +
                     "p.idpeminjaman, p.tanggalpinjam, p.tanggalkembali, " +
                     "p.idanggota, a.nama AS nama_anggota, " +
                     "p.idbuku, b.judul AS judul_buku " +
                     "FROM peminjaman p " +
                     "LEFT JOIN anggota a ON p.idanggota = a.idanggota " +
                     "LEFT JOIN buku b ON p.idbuku = b.idbuku " +
                     "WHERE a.nama LIKE '%" + keyword + "%' " +
                     "OR b.judul LIKE '%" + keyword + "%' " +
                     "OR p.tanggalpinjam LIKE '%" + keyword + "%'";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Peminjaman pen = new Peminjaman();
                pen.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pen.getAnggota().setIdanggota(rs.getInt("idanggota"));
                pen.getAnggota().setnama(rs.getString("nama_anggota"));
                pen.getBuku().setIdbuku(rs.getInt("idbuku"));
                pen.getBuku().setJudul(rs.getString("judul_buku"));
                pen.setTanggalpinjam(rs.getString("tanggalpinjam"));
                pen.setTanggalkembali(rs.getString("tanggalkembali"));
                
                ListPeminjaman.add(pen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPeminjaman;
    }

    public void save() {
        if (getById(idpeminjaman).getIdpeminjaman() == 0) {
            String sql = "INSERT INTO peminjaman (idanggota, idbuku, tanggalpinjam, tanggalkembali) " +
                         "VALUES(" +
                         "'" + this.getAnggota().getIdanggota() + "', " +
                         "'" + this.getBuku().getIdbuku() + "', " +
                         "'" + this.tanggalpinjam + "', " +
                         "'" + this.tanggalkembali + "')";

            this.idpeminjaman = DBHelper.insertQueryGetId(sql);
        } else {
            String sql = "UPDATE peminjaman SET " +
                         "idanggota = '" + this.getAnggota().getIdanggota() + "', " +
                         "idbuku = '" + this.getBuku().getIdbuku() + "', " +
                         "tanggalpinjam = '" + this.tanggalpinjam + "', " +
                         "tanggalkembali = '" + this.tanggalkembali + "' " +
                         "WHERE idpeminjaman = '" + this.idpeminjaman + "'";
            
            DBHelper.executeQuery(sql);
        }
    }

    public void delete() {
        String sql = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(sql);
    }
}