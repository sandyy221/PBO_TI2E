package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;

public class FrmAnggota extends JFrame {

    private JTextField txtIdAnggota;
    private JTextField txtName;
    private JTextField txtAlamat;
    private JTextField txtTelepon;
    private JTextField txtCari;
    private JButton btnSimpan;
    private JButton btnHapus;
    private JButton btnTambahBaru;
    private JButton btnCari;
    private JTable tblAnggota;
    private JScrollPane jScrollPane1;
    
    // Deklarasikan label sebagai instance variables
    private JLabel labelId;
    private JLabel labelName;
    private JLabel labelAlamat;
    private JLabel labelTelepon;

    public FrmAnggota() {
        initComponents();
        tampilkanData();
        kosongkanForm();
    }

    public void kosongkanForm() {
        txtIdAnggota.setText("0");
        txtName.setText("");
        txtAlamat.setText("");
        txtTelepon.setText("");
    }

    public void tampilkanData() {
        String[] kolom = { "ID", "Nama", "Alamat", "Telepon" };
        ArrayList<Anggota> list = new Anggota().getAll();
        Object rowData[] = new Object[4];

        tblAnggota.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        DefaultTableModel model = (DefaultTableModel) tblAnggota.getModel();

        for (Anggota ang : list) {
            rowData[0] = ang.getIdanggota();
            rowData[1] = ang.getnama(); // Perhatikan: getNama() bukan getnama()
            rowData[2] = ang.getAlamat();
            rowData[3] = ang.getTelepon();
            model.addRow(rowData);
        }
    }

    public void cari(String keyword) {
        String[] kolom = { "ID", "Nama", "Alamat", "Telepon" };
        ArrayList<Anggota> list = new Anggota().search(keyword);
        Object rowData[] = new Object[4];

        tblAnggota.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        DefaultTableModel model = (DefaultTableModel) tblAnggota.getModel();

        for (Anggota ang : list) {
            rowData[0] = ang.getIdanggota();
            rowData[1] = ang.getnama(); // Perhatikan: getNama() bukan getnama()
            rowData[2] = ang.getAlamat();
            rowData[3] = ang.getTelepon();
            model.addRow(rowData);
        }
    }

    private void initComponents() {
        setTitle("Form Anggota - PostgreSQL");
        setSize(550, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        labelId = new JLabel("ID Anggota");
        labelName = new JLabel("Nama Anggota");
        labelAlamat = new JLabel("Alamat");
        labelTelepon = new JLabel("Telepon");

        txtIdAnggota = new JTextField();
        txtIdAnggota.setEnabled(false);

        txtName = new JTextField();
        txtAlamat = new JTextField();
        txtTelepon = new JTextField();
        txtCari = new JTextField();

        btnSimpan = new JButton("Simpan");
        btnHapus = new JButton("Hapus");
        btnTambahBaru = new JButton("Tambah Baru");
        btnCari = new JButton("Cari");

        tblAnggota = new JTable();
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(tblAnggota);

        // ... EVENTS ...
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Anggota ang = new Anggota();
                    String idText = txtIdAnggota.getText().trim();
                    
                    if (!idText.isEmpty() && !idText.equals("0")) {
                        ang.setIdanggota(Integer.parseInt(idText));
                    }
                    
                    ang.setnama(txtName.getText()); // Perhatikan: setNama() bukan setnama()
                    ang.setAlamat(txtAlamat.getText());
                    ang.setTelepon(txtTelepon.getText());
                    
                    ang.save();
                    
                    if (idText.isEmpty() || idText.equals("0")) {
                        txtIdAnggota.setText(Integer.toString(ang.getIdanggota()));
                    }
                    
                    tampilkanData();
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID harus berupa angka!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tblAnggota.getModel();
                int row = tblAnggota.getSelectedRow();
                if (row >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin menghapus data ini?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION
                    );
                    
                    if (confirm == JOptionPane.YES_OPTION) {
                        try {
                            Anggota ang = new Anggota();
                            ang.setIdanggota(Integer.parseInt(model.getValueAt(row, 0).toString()));
                            ang.delete();
                            kosongkanForm();
                            tampilkanData();
                            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                        }
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

        tblAnggota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) tblAnggota.getModel();
                int row = tblAnggota.getSelectedRow();
                if (row >= 0) {
                    txtIdAnggota.setText(model.getValueAt(row, 0).toString());
                    txtName.setText(model.getValueAt(row, 1).toString());
                    txtAlamat.setText(model.getValueAt(row, 2).toString());
                    txtTelepon.setText(model.getValueAt(row, 3).toString());
                }
            }
        });
        
        // SETUP LAYOUT - pindahkan ke dalam method initComponents()
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelId)
                    .addComponent(labelName)
                    .addComponent(labelAlamat)
                    .addComponent(labelTelepon))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdAnggota, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName)
                    .addComponent(txtAlamat)
                    .addComponent(txtTelepon)))
            .addComponent(btnSimpan)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnTambahBaru)
                .addComponent(btnHapus)
                .addComponent(txtCari)
                .addComponent(btnCari))
            .addComponent(jScrollPane1)
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelId)
                .addComponent(txtIdAnggota))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelName)
                .addComponent(txtName))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelAlamat)
                .addComponent(txtAlamat))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelTelepon)
                .addComponent(txtTelepon))
            .addGap(10)
            .addComponent(btnSimpan)
            .addGap(10)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnTambahBaru)
                .addComponent(btnHapus)
                .addComponent(txtCari)
                .addComponent(btnCari))
            .addGap(10)
            .addComponent(jScrollPane1)
        );
        
        pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmAnggota().setVisible(true);
        });
    }
}