package com.sopa;

import java.sql.*;


public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\sopha\\Documents\\Workspace\\SopaDB\\" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
//            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
//                                "(name TEXT,phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts(" + COLUMN_NAME + " ," + COLUMN_PHONE + " ," + COLUMN_EMAIL + ")"  +
//                                " VALUES('SopaT', '5625064942', 'pat.peou@gmail.com') ");

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while(results.next()){
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getString(COLUMN_PHONE) + " " +
                        results.getString(COLUMN_EMAIL));
            }

            results.close();
            statement.close();
            conn.close();

        } catch(SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());

        }
    }
}
