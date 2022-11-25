package classic.web.app;

import java.sql.*;
import com.mysql.cj.jdbc.*;

class DB {

	private static MysqlConnectionPoolDataSource pool;

	public static Connection connect() throws SQLException {
	
		if(pool == null){
			pool = new MysqlConnectionPoolDataSource();
			
			pool.setURL("jdbc:mysql://localhost/Employee?useSSL=false");
			
			pool.setUser("root");
			pool.setPassword("Aadesh@0296");
		}
		
		return pool.getConnection();
	
	}

}

