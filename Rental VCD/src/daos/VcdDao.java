package daos;

import models.Vcd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VcdDao {
    private Connection conn = null;

    public VcdDao(Connection con) {
        this.conn = con;
    }
    
    
    public boolean inputData(Vcd entity) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement("INSERT INTO tb_vcd (no_vcd,judul,kategori,nama_pencipta,nama_penerbit,tahun_rilis, sinopsis) "
                    + "VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, entity.getNovcd());
            preparedStatement.setString(2, entity.getJudul());
            preparedStatement.setString(3, entity.getKategori());
            preparedStatement.setString(4, entity.getNamaPencipta());
            preparedStatement.setString(5, entity.getNamaPenerbit());
            preparedStatement.setString(6, entity.getTahunRilis());
            preparedStatement.setString(7, entity.getSinopsis());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public List<Vcd> getAll() {
        List<Vcd> get = new ArrayList();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = conn.prepareCall("SELECT * FROM tb_vcd");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vcd entity = new Vcd();
                entity.setNovcd(resultSet.getString(1));
                entity.setJudul(resultSet.getString(2));
                entity.setKategori(resultSet.getString(3));
                entity.setNamaPencipta(resultSet.getString(4));
                entity.setNamaPenerbit(resultSet.getString(5));
                entity.setTahunRilis(resultSet.getString(6));
                entity.setSinopsis(resultSet.getString(7));
                get.add(entity);
            }
        } catch (Exception e) {
        }
        return get;
    }
    
    public List<Vcd> cariBuku(String judul) {
        List<Vcd> get = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareCall("SELECT * FROM tb_vcd WHERE judul LIKE '%" + judul + "%' OR nama_pencipta LIKE '%" + 
                    judul + "%' OR nama_penerbit LIKE '%" + judul + "%' OR tahun_rilis LIKE '%" + judul + "%'");
            rs = ps.executeQuery();
            while (rs.next()) {
                Vcd t = new Vcd();
                t.setNovcd(rs.getString(1));
                t.setJudul(rs.getString(2));
                t.setKategori(rs.getString(3));
                t.setNamaPencipta(rs.getString(4));
                t.setNamaPenerbit(rs.getString(5));
                t.setTahunRilis(rs.getString(6));
                t.setSinopsis(rs.getString(7));
                get.add(t);
            }
        } catch (Exception e) {
        }
        return get;
    }
    
    public boolean hapus(String vcd) {
        boolean hasil = false;
        String query = "DELETE FROM tb_vcd WHERE no_vcd='" + vcd + "'";
        Statement st;
        try {
            st = conn.createStatement();
            if (st.executeUpdate(query) > 0) {
                hasil = true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean perbarui(Vcd en) {
        boolean hasil = false;
        String sql = "UPDATE tb_vcd SET vcd='" + en.getNovcd() + "',judul='" + en.getJudul() + "',kategori='" + en.getKategori() + "'"
                + ",nama_pencipta = '" + en.getNamaPencipta() + "',nama_penerbit = '" + en.getNamaPenerbit() + 
                "',tahun_rilis = '" + en.getTahunRilis() + "', sinopsis = '"+ en.getSinopsis()+"' WHERE no_vcd = '" + en.getNovcd() + "'";
        Statement st;
        try {
            st = conn.createStatement();
            if (st.executeUpdate(sql) > 0) {
                hasil = true;
            }
        } catch (Exception e) {
        }
        return hasil;
    }
    
}
