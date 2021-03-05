package controller;

import java.sql.Connection;
import models.Pegawai;
import daos.PegawaiDao;
import tools.Koneksi;
import java.util.List;
import java.util.ArrayList;

public class PegawaiController {
    
    public List<Pegawai> loginPegawai() {
        List<Pegawai> adm = new ArrayList();
        Koneksi loginP = new Koneksi();
        Connection conn = loginP.getConnection();
        PegawaiDao peg = new PegawaiDao(conn);
        adm = peg.getPegawai();
        if(adm != null) {
            System.out.println("Success");
            return adm;
        }else {
            System.out.println("Fail");
            return null;
        }
    }
}
