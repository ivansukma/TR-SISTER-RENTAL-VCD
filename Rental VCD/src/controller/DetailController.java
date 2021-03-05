package controller;

import daos.DetailDao;
import java.sql.Connection;
import java.util.ArrayList;
import models.Detail;
import tools.Koneksi;
import java.util.List;

public class DetailController {
    
    public String inputDataDetail(String id, String judul, String namaUser, String tgl) {
        Koneksi cariDetail = new Koneksi();
        Connection conn = cariDetail.getConnection();
        DetailDao detailDao = new DetailDao(conn);
        Detail detail = new Detail();
        detail.setId(id);
        detail.setJudul(judul);
        detail.setNamaUser(namaUser);
        detail.setTgl(tgl);
        if(detailDao.inputDetail(detail)) {
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public String hapusDetail(String judul) {
        Koneksi inputBuku = new Koneksi();
        Connection conn = inputBuku.getConnection();
        DetailDao bukuDao = new DetailDao(conn);
        if (bukuDao.hapusSetDetail(judul)) {
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public List<Detail> cariDetail(String judul) {
        List<Detail> ld = new ArrayList();
        Koneksi cariDetail = new Koneksi();
        Connection conn = cariDetail.getConnection();
        DetailDao detailDao = new DetailDao(conn);
        ld = detailDao.lihatDetail(judul);
        if(ld != null) {
            System.out.println("Success");
            return ld;
        }else {
            System.out.println("Fail");
            return null;
        }
    }
    
    public List<Detail> getDetail() {
        List<Detail> ld = new ArrayList();
        Koneksi cariDetail = new Koneksi();
        Connection conn = cariDetail.getConnection();
        DetailDao detailDao = new DetailDao(conn);
        ld = detailDao.getAllDetail();
        if(ld != null) {
            System.out.println("Success");
            return ld;
        }else {
            System.out.println("Fail");
            return null;
        }
    }
}
