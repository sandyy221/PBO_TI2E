package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;

public class FrmKategori extends JFrame {

    private JTextField txtidkategori;
    private JTextField txtName;
    private JTextField txtKeterangan;
    private JTextField txtCari;
    private JButton btnSimpan;
    private JButton btnTambahBaru;
    private JButton btnHapus;
    private JButton btnCari;
    private JTable tblKategori;
    private JScrollPane jScrollPanel;

    public FrmKategori() {
        initComponents();
        tampilkanData();
        kosongkanForm();
    }

    public void kosongkanForm() {
        // Untuk ID auto increment, kita set kosong atau 0
        txtidkategori.setText("");
        txtName.setText("");
        txtKeterangan.setText("");
    }

    public void tampilkanData() {
        String[] kolom = { "ID", "Nama", "Keterangan" };
        ArrayList<Kategori> list = new Kategori().getAll();
        Object rowData[] = new Object[3];

        // Mengatur model tabel (membersihkan tabel lama jika ada)
        tblKategori.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        DefaultTableModel model = (DefaultTableModel) tblKategori.getModel();

        // Mengisi data
        for (Kategori kat : list) {
            rowData[0] = kat.getIdkategori();
            rowData[1] = kat.getNama();
            rowData[2] = kat.getKeterangan();
            model.addRow(rowData);
        }
    }

    public void cari(String keyword) {
        String[] kolom = { "ID", "Nama", "Keterangan" };
        ArrayList<Kategori> list = new Kategori().search(keyword);
        Object rowData[] = new Object[3];

        // Mengatur model tabel (membersihkan tabel lama jika ada)
        tblKategori.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        DefaultTableModel model = (DefaultTableModel) tblKategori.getModel();

        // Mengisi data hasil pencarian
        for (Kategori kat : list) {
            rowData[0] = kat.getIdkategori();
            rowData[1] = kat.getNama();
            rowData[2] = kat.getKeterangan();
            model.addRow(rowData);
        }
    }

    private void initComponents() {
        setTitle("Form Kategori - PostgreSQL");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel labelId = new JLabel("ID Kategori");
        JLabel labelName = new JLabel("Nama Kategori");
        JLabel labelKet = new JLabel("Keterangan");

        txtidkategori = new JTextField();
        txtidkategori.setEnabled(false); // ID tidak bisa diubah manual

        txtName = new JTextField();
        txtKeterangan = new JTextField();
        txtCari = new JTextField();

        btnSimpan = new JButton("Simpan");
        btnHapus = new JButton("Hapus");
        btnTambahBaru = new JButton("Tambah Baru");
        btnCari = new JButton("Cari");

        tblKategori = new JTable();
        jScrollPanel = new JScrollPane();
        jScrollPanel.setViewportView(tblKategori);

        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Kategori kat = new Kategori();
                    
                    // Untuk INSERT (ID kosong/0), kita tidak set ID
                    // Untuk UPDATE (ID ada nilainya), kita set ID
                    String idText = txtidkategori.getText().trim();
                    
                    if (!idText.isEmpty() && !idText.equals("0")) {
                        // UPDATE mode - ID sudah ada
                        kat.setIdkategori(Integer.parseInt(idText));
                    }
                    // Jika ID kosong atau 0, biarkan kosong untuk auto increment (INSERT)
                    
                    kat.setNama(txtName.getText());
                    kat.setKeterangan(txtKeterangan.getText());
                    
                    kat.save();
                    
                    // Setelah save, ambil ID yang dihasilkan (untuk INSERT)
                    if (idText.isEmpty() || idText.equals("0")) {
                        // Ambil ID terbaru dari database
                        // Anda mungkin perlu method khusus di kelas Kategori untuk ini
                        txtidkategori.setText(Integer.toString(kat.getIdkategori()));
                    }
                    
                    tampilkanData();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID harus berupa angka!");
                }
            }
        });

        btnHapus.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) tblKategori.getModel();
        int row = tblKategori.getSelectedRow();
        if (row >= 0) {
            // Konfirmasi penghapusan
            int confirm = JOptionPane.showConfirmDialog(
                null, 
                "Apakah Anda yakin ingin menghapus data ini?", 
                "Konfirmasi Hapus", 
                JOptionPane.YES_NO_OPTION
            );
            
            if (confirm == JOptionPane.YES_OPTION) {
                Kategori kat = new Kategori();
                kat.setIdkategori(Integer.parseInt(model.getValueAt(row, 0).toString()));
                kat.delete();
                kosongkanForm();
                tampilkanData();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus!");
        }
    }
});

        btnTambahBaru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kosongkanForm();
            }
        });

        btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cari(txtCari.getText());
            }
        });

        tblKategori.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) tblKategori.getModel();
                int row = tblKategori.getSelectedRow();
                if (row >= 0) { // Periksa apakah baris valid
                    txtidkategori.setText(model.getValueAt(row, 0).toString());
                    txtName.setText(model.getValueAt(row, 1).toString());
                    txtKeterangan.setText(model.getValueAt(row, 2).toString());
                }
            }
        });

        // Layout code (sama seperti sebelumnya)
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelId)
                    .addComponent(labelName)
                    .addComponent(labelKet))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtidkategori, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName)
                    .addComponent(txtKeterangan)))
            .addComponent(btnSimpan)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnTambahBaru)
                .addComponent(btnHapus)
                .addComponent(txtCari)
                .addComponent(btnCari))
            .addComponent(jScrollPanel)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelId)
                .addComponent(txtidkategori))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelName)
                .addComponent(txtName))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelKet)
                .addComponent(txtKeterangan))
            .addGap(10)
            .addComponent(btnSimpan)
            .addGap(10)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnTambahBaru)
                .addComponent(btnHapus)
                .addComponent(txtCari)
                .addComponent(btnCari))
            .addGap(10)
            .addComponent(jScrollPanel)
        );

        pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmKategori().setVisible(true);
        });
    }
}