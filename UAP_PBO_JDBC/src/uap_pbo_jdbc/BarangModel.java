package uap_pbo_jdbc;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author Asus
 */
public class BarangModel {
    private final Connection CONN;

    public BarangModel(Connection CONN) {
        this.CONN = CONN;
    }
    
    
}