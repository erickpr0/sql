package com.example.probando;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection con;
    String uname, pass, ip, port, database;

    public Connection connectionclass(){
        ip = "10.0.2.2";
        database = "DORMIMUNDO_RFID";
        uname = "test";
        port = "1433";
        pass = "sa";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConectionURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConectionURL = "jdbc:jtds:sqlserver://"+ ip + ":" + port + ";" + "databasename="
                    + database + ";user=" + uname + ";password=" + pass +";";
            connection = DriverManager.getConnection(ConectionURL);

        } catch (Exception e){
            Log.e("Error", e.getMessage());
        }
        return connection;
    }
}
