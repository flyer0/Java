package mondial;
import java.sql.*;

public class Countries{

    public static void main( String [] args ){
	try {
	    Class.forName( "org.mariadb.jdbc.Driver" );
	    Class.forName( "org.postgresql.Driver" );
	}
	catch ( ClassNotFoundException e ) {
	    System.out.println( "Fehler beim Laden des DB-Treibers " + e );
	    return;
	}

	Connection con;
	PreparedStatement stmt;
	ResultSet rSet;
	
	try {
	    String url = "jdbc:postgresql://172.17.0.2:5432/Mondial";
	    con = DriverManager.getConnection( url, "postgres", "test" );
	    stmt = con.prepareStatement(
		"SELECT code, name FROM country WHERE name like ?" );
	    stmt.setString( 1, "S%" );

	    rSet = stmt.executeQuery( );
	    
	    while ( rSet.next() )
		System.out.println ( rSet.getString(1) + "\t" + rSet.getString(2) );
	    
	    stmt.close();
	    con.close();
	}
	catch ( SQLException e ){
	    System.out.println( "Fehler bei Tabellenabfrage" + e );
	    return;
	}
  }
}	


