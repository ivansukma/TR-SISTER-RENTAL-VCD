package controller;

import daos.VcdDao;
import java.sql.Connection;
import java.util.ArrayList;
import models.Vcd;
import tools.Koneksi;
import java.util.List;

public class VcdController {
    
    public String inputDataVCD(String no_vcd, String judul, String kategori, String NamaPenerbit,String NamaPencipta,String Sinopsis,String TahunRilis) {
        Koneksi inputBuku = new Koneksi();
        Connection conn = inputBuku.getConnection();
        VcdDao bukuDao = new VcdDao(conn);
        Vcd buku = new Vcd();
        buku.setNovcd(no_vcd);
        buku.setJudul(judul);
        buku.setKategori(kategori);
        buku.setNamaPenerbit(NamaPenerbit);
        buku.setNamaPencipta(NamaPencipta);
        buku.setSinopsis(Sinopsis);
        buku.setTahunRilis(TahunRilis);
        if(bukuDao.inputData(buku)) {
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public String updateVCD(String no_vcd, String judul, String kategori, String NamaPenerbit,String NamaPencipta,String TahunRilis, String Sinopsis) {
        Koneksi inputBuku = new Koneksi();
        Connection conn = inputBuku.getConnection();
        VcdDao vcdDao = new VcdDao(conn);
        Vcd vcd = new Vcd();
        vcd.setNovcd(no_vcd);
        vcd.setJudul(judul);
        vcd.setKategori(kategori);
        vcd.setNamaPenerbit(NamaPenerbit);
        vcd.setNamaPencipta(NamaPencipta);
        vcd.setTahunRilis(TahunRilis);
        vcd.setSinopsis(Sinopsis);
        if(vcdDao.perbarui(vcd)) {
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public String hapusVCD(String no_vcd) {
        Koneksi inputBuku = new Koneksi();
        Connection conn = inputBuku.getConnection();
        VcdDao vcdDao = new VcdDao(conn);
        if (vcdDao.hapus(no_vcd)) {
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public List<Vcd> cariVCD(String judul) {
        List<Vcd> lb = new ArrayList();
        Koneksi inputBuku = new Koneksi();
        Connection conn = inputBuku.getConnection();
        VcdDao vcdDao = new VcdDao(conn);
        lb = vcdDao.cariBuku(judul);
        if(lb != null) {
            System.out.println("Success");
            return lb;
        }else {
            System.out.println("Fail");
            return null;
        }
    }
    
    public List<Vcd> getVCD() {
        List<Vcd> lb = new ArrayList();
        Koneksi inputBuku = new Koneksi();
        Connection conn = inputBuku.getConnection();
        VcdDao vcdDao = new VcdDao(conn);
        lb = vcdDao.getAll();
        if (lb != null) {
            System.out.println("Success");
            return lb;
        } else {
            System.out.println("Fail");
            return null;
        }
    }
}