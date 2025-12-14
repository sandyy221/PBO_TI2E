package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.*;
import java.awt.*;

public class FrmBuku extends JFrame {

    private JTextField txtIdBuku;
    private JComboBox<Kategori> cmbKategori;
    private JTextField txtJudul;
    private JTextField txtPenerbit;
    private JTextField txtPenulis;
    private JTextField txtCari;
    private JButton btnSimpan;
    private JButton btnHapus;
    private JButton btnTambahBaru;
    private JButton btnCari;
    private JTable tblBuku;
    private JScrollPane jScrollPanel;

    public FrmBuku() {
        initComponents();
        tampilkanData();
        tampilkanCmbKategori();
        kosongkanForm();
    }

    public void kosongkanForm() {
        txtIdBuku.setText("0");
        if (cmbKategori.getItemCount() > 0) {
            cmbKategori.setSelectedIndex(0);
        }
        txtJudul.setText("");
        txtPenerbit.setText("");
        txtPenulis.setText("");
    }

    public void tampilkanData() {
        String[] kolom = {"ID", "Kategori", "Judul", "Penerbit", "Penulis"};
        ArrayList<Buku> list = new Buku().getAll();
        Object rowData[] = new Object[5];

        tblBuku.setModel(new DefaultTableModel(new Object[][]{}, kolom));
        DefaultTableModel model = (DefaultTableModel) tblBuku.getModel();

        for (Buku buku : list) {
            rowData[0] = buku.getIdbuku();
            rowData[1] = buku.getKategori().getNama();
            rowData[2] = buku.getJudul();
            rowData[3] = buku.getPenerbit();
            rowData[4] = buku.getPenulis();
            model.addRow(rowData);
        }
    }

    public void cari(String keyword) {
        String[] kolom = {"ID", "Kategori", "Judul", "Penerbit", "Penulis"};
        ArrayList<Buku> list = new Buku().search(keyword);
        Object rowData[] = new Object[5];

        tblBuku.setModel(new DefaultTableModel(new Object[][]{}, kolom));
        DefaultTableModel model = (DefaultTableModel) tblBuku.getModel();

        for (Buku buku : list) {
            rowData[0] = buku.getIdbuku();
            rowData[1] = buku.getKategori().getNama();
            rowData[2] = buku.getJudul();
            rowData[3] = buku.getPenerbit();
            rowData[4] = buku.getPenulis();
            model.addRow(rowData);
        }
    }

    public void tampilkanCmbKategori() {
        ArrayList<Kategori> listKategori = new Kategori().getAll();
        cmbKategori.setModel(new DefaultComboBoxModel<Kategori>(listKategori.toArray(new Kategori[0])));
    }

    private void initComponents() {
        setTitle("Form Buku - PostgreSQL");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel labelId = new JLabel("ID Buku");
        JLabel labelKat = new JLabel("Kategori");
        JLabel labelJudul = new JLabel("Judul");
        JLabel labelPenerbit = new JLabel("Penerbit");
        JLabel labelPenulis = new JLabel("Penulis");
        JLabel labelCari = new JLabel("Cari");

        txtIdBuku = new JTextField();
        txtIdBuku.setEnabled(false);

        cmbKategori = new JComboBox<>();

        txtJudul = new JTextField();
        txtPenerbit = new JTextField();
        txtPenulis = new JTextField();
        txtCari = new JTextField();

        btnSimpan = new JButton("Simpan");
        btnHapus = new JButton("Hapus");
        btnTambahBaru = new JButton("Tambah Baru");
        btnCari = new JButton("Cari");

        tblBuku = new JTable();
        jScrollPanel = new JScrollPane();
        jScrollPanel.setViewportView(tblBuku);

        // Action Listener untuk btnSimpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buku buku = new Buku();
                buku.setIdbuku(Integer.parseInt(txtIdBuku.getText()));
                buku.setKategori((Kategori) cmbKategori.getSelectedItem());
                buku.setJudul(txtJudul.getText());
                buku.setPenerbit(txtPenerbit.getText());
                buku.setPenulis(txtPenulis.getText());

                buku.save();

                txtIdBuku.setText(Integer.toString(buku.getIdbuku()));
                tampilkanData();
            }
        });

        // Action Listener untuk btnHapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tblBuku.getModel();
                int row = tblBuku.getSelectedRow();

                if (row >= 0) {
                    Buku buku = new Buku();
                    buku.setIdbuku(Integer.parseInt(model.getValueAt(row, 0).toString()));
                    buku.delete();
                    kosongkanForm();
                    tampilkanData();
                }
            }
        });

        // Action Listener untuk btnTambahBaru
        btnTambahBaru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kosongkanForm();
            }
        });

        // Action Listener untuk btnCari
        btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cari(txtCari.getText());
            }
        });

        // Mouse Listener untuk tabel
        tblBuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) tblBuku.getModel();
                int row = tblBuku.getSelectedRow();

                int id = Integer.parseInt(model.getValueAt(row, 0).toString());
                Buku buku = new Buku().getById(id);

                txtIdBuku.setText(String.valueOf(buku.getIdbuku()));
                txtJudul.setText(buku.getJudul());
                txtPenerbit.setText(buku.getPenerbit());
                txtPenulis.setText(buku.getPenulis());

                int idkategoriDBuku = buku.getKategori().getIdkategori();
                for (int i = 0; i < cmbKategori.getItemCount(); i++) {
                    Kategori kat = cmbKategori.getItemAt(i);
                    if (kat.getIdkategori() == idkategoriDBuku) {
                        cmbKategori.setSelectedIndex(i);
                        break;
                    }
                }
            }
        });

        // Setup Layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Horizontal Group
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelId)
                    .addComponent(labelKat)
                    .addComponent(labelJudul)
                    .addComponent(labelPenerbit)
                    .addComponent(labelPenulis)
                    .addComponent(labelCari))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdBuku, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKategori, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtJudul)
                    .addComponent(txtPenerbit)
                    .addComponent(txtPenulis)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCari)
                        .addComponent(btnCari)))
                .addComponent(btnSimpan))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnTambahBaru)
                .addComponent(btnHapus))
            .addComponent(jScrollPanel)
        );

        // Vertical Group
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelId)
                .addComponent(txtIdBuku))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelKat)
                .addComponent(cmbKategori))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelJudul)
                .addComponent(txtJudul))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelPenerbit)
                .addComponent(txtPenerbit))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelPenulis)
                .addComponent(txtPenulis))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelCari)
                .addComponent(txtCari)
                .addComponent(btnCari))
            .addGap(10)
            .addComponent(btnSimpan)
            .addGap(10)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnTambahBaru)
                .addComponent(btnHapus))
            .addGap(10)
            .addComponent(jScrollPanel)
        );

        pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmBuku().setVisible(true);
            }
        });
    }
} 