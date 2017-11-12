/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DanVz
 */
public class Conectar {
    protected Connection con;
    protected PreparedStatement consulta;
    protected ResultSet datos;
    private String server, user, db,pass;
    
    public Conectar(){
        this.server = "localhost";
        this.user = "root";
        this.db = "usuarios";
        this.pass = "123";
    }
    
    public void establecerConexion() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://"+this.server+"/"+this.db,this.user,this.pass);   
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }
    
    public void desconectar() throws SQLException{
        this.con.close();
    }
    
    public ResultSet devolverDatos() throws SQLException{
        this.establecerConexion();
        this.consulta = this.con.prepareStatement("select * from usuarios");
        this.datos = this.consulta.executeQuery();
        return this.datos;
    }
}
