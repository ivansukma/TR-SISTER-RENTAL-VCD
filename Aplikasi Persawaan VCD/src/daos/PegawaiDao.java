package daos;

import models.Pegawai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PegawaiDao {
    Connection conn;
    public PegawaiDao(Connection con) {
        this.conn = con;
    }
    
    public List<Pegawai> getPegawai() {
        List<Pegawai> get = new ArrayList();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = conn.prepareCall("SELECT * FROM tb_pegawai");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pegawai entity = new Pegawai();
                entity.setPegawai(resultSet.getString(1));
                entity.setPas(resultSet.getString(2));
                get.add(entity);
            }
        } catch (Exception e) {
        }
        return get;
    }
}
