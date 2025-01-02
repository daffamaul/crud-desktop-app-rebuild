/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daffa.service;

import daffa.connection.DatabaseConnection;
import daffa.model.ModelMahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daffa
 */
public class ServiceMahasiswa {
    public List<ModelMahasiswa> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select * from mahasiswa");
            r = p.executeQuery();
            List<ModelMahasiswa> list = new ArrayList<>();
            
            while (r.next()) {             
                int id = r.getInt("id");
                String nama = r.getString("nama");
                int nim = r.getInt("nim");
                String jurusan = r.getString("jurusan");
                int semester = r.getInt("semester");
                
                list.add(new ModelMahasiswa(id, nama, nim, jurusan,  Integer.toString(semester)));
            }
            
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }
    
    public void create(ModelMahasiswa data) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;        
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("insert into mahasiswa (id, nama, nim, jurusan, semester) values (NULL, ?, ?, ?, ?)");            
            p.setString(1, data.getNama());
            p.setInt(2, data.getNim());
            p.setString(3, data.getJurusan());
            p.setInt(4, data.getSemester());
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
    }
    
    public List<ModelMahasiswa> search(String search) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select * from mahasiswa where nama like ? or nim like ? or jurusan like ? or semester like ?");
            p.setString(1, "%" + search + "%");
            p.setString(2, "%" + search + "%");
            p.setString(3, "%" + search + "%");
            p.setString(4, "%" + search + "%");
            r = p.executeQuery();
            List<ModelMahasiswa> list = new ArrayList<>();
            
            while (r.next()) {          
                int id = r.getInt("id");
                String nama = r.getString("nama");
                int nim = r.getInt("nim");
                String jurusan = r.getString("jurusan");
                int semester = r.getInt("semester");
                
                list.add(new ModelMahasiswa(id, nama, nim, jurusan,  Integer.toString(semester)));
            }
            
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }
    
    public void edit(ModelMahasiswa data) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;        
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("update mahasiswa set nama=?, nim=?, jurusan=?, semester=? where id=?");                             
            p.setString(1, data.getNama());
            p.setInt(2, data.getNim());
            p.setString(3, data.getJurusan());
            p.setInt(4, data.getSemester());
            p.setInt(5, data.getId());
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
    }
    
    public void delete(int id) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;        
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("delete from mahasiswa where id=?");                                         
            p.setInt(1, id);
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
    }
}
