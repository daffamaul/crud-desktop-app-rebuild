/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daffa.model;

/**
 *
 * @author daffa
 */
public class ModelMahasiswa {
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    private int id;
    private String nama;
    private int nim;
    private String jurusan;
    private int semester;
    
    public ModelMahasiswa(int id, String nama, int nim, String jurusan, String semester) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.semester = Integer.parseInt(semester);
    }
    
    public ModelMahasiswa() {
        
    }
    
    public Object[] toTableRow(int rowNum) {        
        return new Object[]{false, rowNum, this, nim, jurusan, semester};
    }

    @Override
    public String toString() {
        return nama;
    }
}
