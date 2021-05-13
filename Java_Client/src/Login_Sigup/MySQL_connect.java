/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login_Sigup;
import Client_GUI.ClientGUI;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class MySQL_connect {

    private static String servername = "localhost";
    private static String username = "root";
    private static String password = "";
    private static String dbname = "mydatabase";
    private static int portnumber = 3306;

    public static Connection getConnection() {
        Connection mydata = null;
        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPort(portnumber);

        try {
            mydata = datasource.getConnection();
        } catch (SQLException ex) {
            Component a=null;
            JOptionPane.showMessageDialog(a,"Can not connect to server");
            ClientGUI gui = new ClientGUI();
            gui.jButton_connect.setEnabled(true);
        }
        return mydata;
    }

}
