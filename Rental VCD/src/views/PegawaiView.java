package views;

import controller.VcdController;
import controller.DetailController;
import daos.VcdDao;
import daos.DetailDao;
import models.Vcd;
import models.Detail;
import tools.Koneksi;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PegawaiView extends javax.swing.JFrame {

    public PegawaiView() {
        initComponents();
        refresh();
        setNetralCondition();
        this.setTitle("Menu Daftar Buku");
    }
    
    VcdController bc = new VcdController();
    DetailController dc = new DetailController();
    
    List<Vcd> list = new ArrayList();
    List<Vcd> listt = new ArrayList();
    List<Detail> listDet = new ArrayList();
    int total;
    int indeks;
    int countDetail;
    boolean isShow = false;
   
    public void refresh() {
        list = bc.getBuku();
        String[][] data = new String[list.size()][7];
        int i = 0;
        for (Vcd li : list) {
            data[i][0] = li.getNovcd();
            data[i][1] = li.getJudul();
            data[i][2] = li.getKategori();
            data[i][3] = li.getNamaPencipta();
            data[i][4] = li.getNamaPenerbit();
            data[i][5] = li.getTahunRilis();
            data[i][6] = li.getSinopsis();
            i++;
        }
        Table1.setModel(new DefaultTableModel(data, new String[]{"NO_VCD", "JUDUL", "KATEGORI", "NAMA_PENCIPTA",
             "NAMA_PENERBIT", "TAHUN_RILIS"}));
    }
    
    public void getAllDetail() {
        listDet = dc.getDetail();
        String[][] data = new String[listDet.size()][4];
        int i = 0;
        for (Detail md : listDet) {
            data[i][0] = md.getId();
            data[i][1] = md.getJudul();
            data[i][2] = md.getNamaUser();
            data[i][3] = md.getTgl();
            i++;
        }
        this.countDetail = i;
        
        if(isShow) {
            tabRecord.setModel(new DefaultTableModel(data, new String[]{"Id", "Judul", "NamaUser", "Tanggal"}));
            isShow = false;
        }
    }
    
    public void getDetailBuku() {
        List<Detail> dataDet = new ArrayList();
        dataDet = dc.cariDetail(judul.getText().toString());
        
        String[][] data = new String[list.size()][4];
        int i = 0;
        for(Detail dd : dataDet) {
            data[i][0] = dd.getId();
            data[i][1] = dd.getJudul();
            data[i][2] = dd.getNamaUser();
            data[i][3] = dd.getTgl();
            i++;
        }
        
        tabRecord.setModel(new DefaultTableModel(data, new String[]{"Id", "Judul", "NamaUser", "Tanggal"}));
    }
    
    public void setNetralCondition() {
        brshtmbl.setEnabled(true);
        brutmbl.setEnabled(false);
        hpstmbl.setEnabled(false);
        msktmbl.setEnabled(true);
    }
    
    public void setInputTableCondition() {
        brshtmbl.setEnabled(true);
        brutmbl.setEnabled(true);
        hpstmbl.setEnabled(true);
        msktmbl.setEnabled(false);
    }
    
    public void clear() {
        no_vcd.setText("");
        judul.setText("");
        kategori.setText("");
        pencipta.setText("");
        penerbit.setText("");
        tahun.setText("");
        textSinopsis.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        caribuku = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        no_vcd = new javax.swing.JTextField();
        judul = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kategori = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pencipta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        penerbit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tahun = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        brshtmbl = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textSinopsis = new javax.swing.JTextArea();
        brutmbl = new javax.swing.JButton();
        hpstmbl = new javax.swing.JButton();
        msktmbl = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabRecord = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        caribuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caribukuKeyPressed(evt);
            }
        });

        jLabel2.setText("Cari VCD");

        jLabel3.setText("NO VCD");

        jLabel5.setText("Judul");

        jLabel6.setText("kategori");

        jLabel7.setText("Nama Pencipta");

        jLabel8.setText("Nama Penerbit");

        jLabel9.setText("Tahun Rilis");

        jLabel4.setText("Data VCD");

        brshtmbl.setText("Bersihkan");
        brshtmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brshtmblActionPerformed(evt);
            }
        });

        jLabel10.setText("Sinopsis");

        textSinopsis.setColumns(20);
        textSinopsis.setRows(5);
        jScrollPane2.setViewportView(textSinopsis);

        brutmbl.setText("Perbarui");
        brutmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brutmblActionPerformed(evt);
            }
        });

        hpstmbl.setText("Hapus");
        hpstmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpstmblActionPerformed(evt);
            }
        });

        msktmbl.setText("Masukkan");
        msktmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msktmblActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(caribuku, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(brshtmbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(brutmbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hpstmbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(msktmbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tahun, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(pencipta)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(89, 89, 89)
                        .addComponent(no_vcd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(judul)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caribuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(judul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(no_vcd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(pencipta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brshtmbl)
                    .addComponent(msktmbl)
                    .addComponent(hpstmbl)
                    .addComponent(brutmbl))
                .addContainerGap())
        );

        jLabel1.setText("Record VCD");

        tabRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabRecord);

        jButton1.setText("Lihat Semua");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msktmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msktmblActionPerformed
        
        String input = bc.inputDataBuku(no_vcd.getText(), judul.getText(), kategori.getText(), penerbit.getText(), 
                pencipta.getText(), textSinopsis.getText(), tahun.getText());
        refresh();
        setNetralCondition();
    }//GEN-LAST:event_msktmblActionPerformed

    private void hpstmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpstmblActionPerformed
        int konfirm = JOptionPane.showConfirmDialog(null, "Yakin Hapus?", 
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (konfirm == JOptionPane.YES_OPTION) {
            String hapus = bc.hapusBuku(no_vcd.getText().toString());
            String recHapus = dc.hapusDetail(judul.getText().toString());
            refresh();
            setNetralCondition();
        }else{
            return;
        }    
        clear();
        no_vcd.setEditable(true);
    }//GEN-LAST:event_hpstmblActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        no_vcd.setEditable(false);
        indeks = Table1.getSelectedRow();
        Vcd dataBuku = list.get(indeks);
        
        no_vcd.setText(dataBuku.getNovcd());
        judul.setText(dataBuku.getJudul());
        kategori.setText(dataBuku.getKategori());
        pencipta.setText(dataBuku.getNamaPencipta());
        penerbit.setText(dataBuku.getNamaPenerbit());
        tahun.setText(dataBuku.getTahunRilis());
        textSinopsis.setText(dataBuku.getSinopsis());
        setInputTableCondition();
        
        getDetailBuku();
    }//GEN-LAST:event_Table1MouseClicked

    private void caribukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caribukuKeyPressed
        //String katakunci = combobox.getSelectedItem().toString();
        List<Vcd> list = new ArrayList();
        list = bc.cariBuku(caribuku.getText().toString());
        String[][] data = new String[list.size()][6];
        int i = 0;
        for (Vcd li : list) {
            data[i][0] = li.getNovcd();
            data[i][1] = li.getJudul();
            data[i][2] = li.getKategori();
            data[i][3] = li.getNamaPencipta();
            data[i][4] = li.getNamaPenerbit();
            data[i][5] = li.getTahunRilis();
            i++;
        }
        Table1.setModel(new DefaultTableModel(data, new String[]{"NO_VCD",
            "JUDUL", "KATEGORI", "NAMA_PENCIPTA", "NAMA_PENERBIT", "TAHUN_RILIS"}));
    }//GEN-LAST:event_caribukuKeyPressed

    private void brutmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brutmblActionPerformed
//        String isbnt=isbn.getText().toString();
//        String judult=judul.getText().toString();
//        String kategorit=kategori.getText().toString();
//        String npet=pengarang.getText().toString();
//        String npt=penerbit.getText().toString();
//        String tht=tahun.getText().toString();
//        String sinop = textSinopsis.getText().toString();
        
        String update=bc.updateBuku(no_vcd.getText().toString(), judul.getText().toString(), kategori.getText().toString(), penerbit.getText().toString(), pencipta.getText().toString(),tahun.getText().toString(), textSinopsis.getText().toString());
        refresh();
        clear();
        setNetralCondition();
        no_vcd.setEditable(true);
    }//GEN-LAST:event_brutmblActionPerformed

    private void brshtmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brshtmblActionPerformed
        no_vcd.setEditable(true);
        clear();
        setNetralCondition();
    }//GEN-LAST:event_brshtmblActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.isShow = true;
        getAllDetail();
    }//GEN-LAST:event_jButton1ActionPerformed

 
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PegawaiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JButton brshtmbl;
    private javax.swing.JButton brutmbl;
    private javax.swing.JTextField caribuku;
    private javax.swing.JButton hpstmbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField kategori;
    private javax.swing.JButton msktmbl;
    private javax.swing.JTextField no_vcd;
    private javax.swing.JTextField pencipta;
    private javax.swing.JTextField penerbit;
    private javax.swing.JTable tabRecord;
    private javax.swing.JTextField tahun;
    private javax.swing.JTextArea textSinopsis;
    // End of variables declaration//GEN-END:variables
}
