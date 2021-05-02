/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login_Sigup;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Logger.getLogger("Get connection -->" + MySQL_connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mydata;
    }

}
