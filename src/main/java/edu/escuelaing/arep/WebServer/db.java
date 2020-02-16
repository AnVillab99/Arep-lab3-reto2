package edu.escuelaing.arep.WebServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class db {

	private final String url = "jdbc:postgresql://ec2-54-225-95-183.compute-1.amazonaws.com:5432/d1eklfanov8b4e";
	private final String user = "lhwhsablrhjkzl";
    private final String password = "4ae800cc156641d730e12a8c0d5c76321dc49e24174bf119e16035c8a114cd34";
    private static Connection conn;
    private  ResultSet rs;

	public Connection connect() {
		conn = null;
		try {

			System.out.println("crearla");
			conn = DriverManager.getConnection(url, user, password);

			System.out.println("creada");
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}

	public String consultarUsuarios()  {
		
        //String SQL = "select exists(select 1 from users WHERE username=(?) and password = (?))";
        String SQL = "select * from users";
        String res ="Usuarios: ";
		try {Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            rs = pstmt.executeQuery();
			while(rs.next()){
                res+=rs.getString("username")+"; ";

            }
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		
		return res;
	}
}
