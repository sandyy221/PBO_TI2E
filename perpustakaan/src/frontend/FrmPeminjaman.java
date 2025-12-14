package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrmPeminjaman extends JFrame {

    private JTextField txtId;
    private JTextField txtIdAnggota;
    private JTextField txtIdBuku;
    private JTextField txtTanggalPinjam;
    private JTextField txtTanggalKembali;

    private JButton btnCariAnggota;
    private JButton btnCariBuku;

    private JLabel lblNamaAnggota;
    private JLabel lblJudulBuku;

    private JButton btnSimpan;
    private JButton btnTambahBaru;
    private JButton btnHapus;

    private JTable tblPeminjaman;
    private JScrollPane jScrollPane1;

    public FrmPeminjaman() {
        initComponents();
        tampilkanData();
        kosongkanForm();
        setTanggalDefault();
    }

    public void kosongkanForm() {
        txtId.setText("0");
        txtIdAnggota.setText("");
        txtIdBuku.setText("");
        lblNamaAnggota.setText("");
        lblJudulBuku.setText("");
        setTanggalDefault();
    }

    public void setTanggalDefault() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tanggalSekarang = sdf.format(new Date());
        txtTanggalPinjam.setText(tanggalSekarang);
        
        // Default tanggal kembali 14 hari dari sekarang
        Date tanggalKembali = new Date(System.currentTimeMillis() + (14L * 24 * 60 * 60 * 1000));
        txtTanggalKembali.setText(sdf.format(tanggalKembali));
    }

    public void tampilkanData() {
        String[] kolom = {"ID", "Peminjam", "Buku", "Tgl Pinjam", "Tgl Kembali"};
        ArrayList<Peminjaman> list = new Peminjaman().getAll();
        
        DefaultTableModel model = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tblPeminjaman.setModel(model);
        
        for (Peminjaman pem : list) {
            Object[] rowData = new Object[5];
            rowData[0] = pem.getIdpeminjaman();
            rowData[1] = pem.getAnggota().getnama();
            rowData[2] = pem.getBuku().getJudul();
            rowData[3] = pem.getTanggalpinjam();
            rowData[4] = pem.getTanggalkembali();
            model.addRow(rowData);
        }
    }

    private void initComponents() {
        setTitle("Form Peminjaman - PostgreSQL");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // MAIN PANEL dengan BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // === PANEL ATAS (FORM INPUT) ===
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        
        // Baris 1: ID
        JPanel panelId = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panelId.add(new JLabel("ID"));
        txtId = new JTextField(5);
        txtId.setEnabled(false);
        panelId.add(txtId);
        panelId.add(Box.createHorizontalStrut(100)); // Spacer
        formPanel.add(panelId);
        
        // Baris 2: ID Anggota + Cari + Nama
        JPanel panelAnggota = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panelAnggota.add(new JLabel("ID Anggota"));
        txtIdAnggota = new JTextField(5);
        panelAnggota.add(txtIdAnggota);
        
        btnCariAnggota = new JButton("Cari");
        panelAnggota.add(btnCariAnggota);
        
        lblNamaAnggota = new JLabel("");
        lblNamaAnggota.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(2, 5, 2, 5)
        ));
        lblNamaAnggota.setPreferredSize(new Dimension(150, 25));
        panelAnggota.add(lblNamaAnggota);
        
        formPanel.add(panelAnggota);
        
        // Baris 3: ID Buku + Cari + Judul
        JPanel panelBuku = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panelBuku.add(new JLabel("ID Buku"));
        txtIdBuku = new JTextField(5);
        panelBuku.add(txtIdBuku);
        
        btnCariBuku = new JButton("Cari");
        panelBuku.add(btnCariBuku);
        
        lblJudulBuku = new JLabel("");
        lblJudulBuku.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(2, 5, 2, 5)
        ));
        lblJudulBuku.setPreferredSize(new Dimension(150, 25));
        panelBuku.add(lblJudulBuku);
        
        formPanel.add(panelBuku);
        
        // Baris 4: Tanggal Pinjam
        JPanel panelTglPinjam = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panelTglPinjam.add(new JLabel("Tanggal Pinjam"));
        txtTanggalPinjam = new JTextField(10);
        panelTglPinjam.add(txtTanggalPinjam);
        
        JLabel labelFormat1 = new JLabel("Format: YYYY-MM-DD");
        labelFormat1.setForeground(Color.GRAY);
        panelTglPinjam.add(labelFormat1);
        
        formPanel.add(panelTglPinjam);
        
        // Baris 5: Tanggal Kembali
        JPanel panelTglKembali = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panelTglKembali.add(new JLabel("Tanggal Kembali"));
        txtTanggalKembali = new JTextField(10);
        panelTglKembali.add(txtTanggalKembali);
        
        JLabel labelFormat2 = new JLabel("Format: YYYY-MM-DD");
        labelFormat2.setForeground(Color.GRAY);
        panelTglKembali.add(labelFormat2);
        
        formPanel.add(panelTglKembali);

        // === PANEL TENGAH (TOMBOL) ===
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnSimpan = new JButton("Simpan");
        btnTambahBaru = new JButton("Tambah Baru");
        btnHapus = new JButton("Hapus");
        
        buttonPanel.add(btnSimpan);
        buttonPanel.add(btnTambahBaru);
        buttonPanel.add(btnHapus);

        // === PANEL BAWAH (TABEL) ===
        JPanel tablePanel = new JPanel(new BorderLayout());
        tblPeminjaman = new JTable();
        jScrollPane1 = new JScrollPane(tblPeminjaman);
        tablePanel.add(jScrollPane1, BorderLayout.CENTER);

        // === GABUNG SEMUA PANEL ===
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(tablePanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);

        // === ACTION LISTENERS ===
        
        // Cari Anggota
        btnCariAnggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = txtIdAnggota.getText().trim();
                if (idText.isEmpty()) {
                    lblNamaAnggota.setText("");
                    return;
                }
                
                try {
                    int id = Integer.parseInt(idText);
                    Anggota ang = new Anggota().getById(id);
                    if (ang.getIdanggota() != 0) {
                        lblNamaAnggota.setText(ang.getnama());
                    } else {
                        lblNamaAnggota.setText("[Tidak Ditemukan]");
                    }
                } catch (Exception ex) {
                    lblNamaAnggota.setText("[ID Invalid]");
                }
            }
        });

        // Cari Buku
        btnCariBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = txtIdBuku.getText().trim();
                if (idText.isEmpty()) {
                    lblJudulBuku.setText("");
                    return;
                }
                
                try {
                    int id = Integer.parseInt(idText);
                    Buku buku = new Buku().getById(id);
                    if (buku.getIdbuku() != 0) {
                        lblJudulBuku.setText(buku.getJudul());
                    } else {
                        lblJudulBuku.setText("[Tidak Ditemukan]");
                    }
                } catch (Exception ex) {
                    lblJudulBuku.setText("[ID Invalid]");
                }
            }
        });

        // Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validasi
                if (txtIdAnggota.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ID Anggota harus diisi!");
                    return;
                }
                if (txtIdBuku.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ID Buku harus diisi!");
                    return;
                }
                if (txtTanggalPinjam.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tanggal Pinjam harus diisi!");
                    return;
                }
                if (txtTanggalKembali.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tanggal Kembali harus diisi!");
                    return;
                }
                
                try {
                    // Cek apakah anggota ada
                    int idAnggota = Integer.parseInt(txtIdAnggota.getText());
                    Anggota anggota = new Anggota().getById(idAnggota);
                    if (anggota.getIdanggota() == 0) {
                        JOptionPane.showMessageDialog(null, "Anggota tidak ditemukan!");
                        return;
                    }
                    
                    // Cek apakah buku ada
                    int idBuku = Integer.parseInt(txtIdBuku.getText());
                    Buku buku = new Buku().getById(idBuku);
                    if (buku.getIdbuku() == 0) {
                        JOptionPane.showMessageDialog(null, "Buku tidak ditemukan!");
                        return;
                    }
                    
                    // Validasi tanggal
                    String tglPinjam = txtTanggalPinjam.getText();
                    String tglKembali = txtTanggalKembali.getText();
                    
                    // Simpan data
                    Peminjaman peminjaman = new Peminjaman();
                    peminjaman.setIdpeminjaman(Integer.parseInt(txtId.getText()));
                    peminjaman.setAnggota(anggota);
                    peminjaman.setBuku(buku);
                    peminjaman.setTanggalpinjam(tglPinjam);
                    peminjaman.setTanggalkembali(tglKembali);
                    
                    peminjaman.save();
                    
                    txtId.setText(Integer.toString(peminjaman.getIdpeminjaman()));
                    tampilkanData();
                    
                    JOptionPane.showMessageDialog(null, "Data peminjaman berhasil disimpan!");
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID harus berupa angka!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // Tambah Baru
        btnTambahBaru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kosongkanForm();
            }
        });

        // Hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tblPeminjaman.getModel();
                int row = tblPeminjaman.getSelectedRow();
                
                if (row >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(null, 
                            "Apakah Anda yakin ingin menghapus data peminjaman ini?", 
                            "Konfirmasi Hapus", 
                            JOptionPane.YES_NO_OPTION);
                    
                    if (confirm == JOptionPane.YES_OPTION) {
                        try {
                            int idPeminjaman = Integer.parseInt(model.getValueAt(row, 0).toString());
                            Peminjaman peminjaman = new Peminjaman();
                            peminjaman.setIdpeminjaman(idPeminjaman);
                            peminjaman.delete();
                            
                            kosongkanForm();
                            tampilkanData();
                            JOptionPane.showMessageDialog(null, "Data peminjaman berhasil dihapus!");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih data peminjaman yang akan dihapus dari tabel!");
                }
            }
        });

        // Klik tabel
        tblPeminjaman.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) tblPeminjaman.getModel();
                int row = tblPeminjaman.getSelectedRow();
                
                if (row != -1) {
                    try {
                        int id = Integer.parseInt(model.getValueAt(row, 0).toString());
                        Peminjaman pinj = new Peminjaman().getById(id);
                        
                        txtId.setText(String.valueOf(pinj.getIdpeminjaman()));
                        txtIdAnggota.setText(String.valueOf(pinj.getAnggota().getIdanggota()));
                        txtIdBuku.setText(String.valueOf(pinj.getBuku().getIdbuku()));
                        txtTanggalPinjam.setText(pinj.getTanggalpinjam());
                        txtTanggalKembali.setText(pinj.getTanggalkembali());
                        
                        lblNamaAnggota.setText(pinj.getAnggota().getnama());
                        lblJudulBuku.setText(pinj.getBuku().getJudul());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                }
            }
        });

        // Set ukuran window
        setSize(600, 450);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmPeminjaman().setVisible(true);
            }
        });
    }
}