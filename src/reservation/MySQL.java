package reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
String driver;
String server, dbname, url, user, password;
Connection con;
Statement stmt;
ResultSet rs;
public MySQL() {

this.driver = "org.gjt.mm.mysql.Driver";
this.server = "ms000.sist.ac.jp"; // MySQLサーバ ( IP または ホスト名 );
this.dbname = "java2016"; // データベース名
this.url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";

	this.user = "java2016";
	this.password ="java2016";
	
	try {
		this.con = DriverManager.getConnection(url, user, password);
		this.stmt = con.createStatement ();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Class.forName (driver);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void close(){
	try {
		rs.close();
		stmt.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public ResultSet selectAll(){
	String sql = "SELECT * FROM `50516051`";
	ResultSet rs = null;
	try {
		rs = stmt.executeQuery (sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //try catchで囲む
	return rs;

 }
public ResultSet selectReservation(String rdate, String facility){
String sql = "SELECT * FROM reservation WHERE date ='" + rdate + "' AND facility_name = '"+ facility +"' ORDER BY start_time;";
 ResultSet rs = null;
try {
 rs = stmt.executeQuery (sql); //try catchで囲む
 } catch (SQLException e) {
	 // TODO Auto-generated catch block
 e.printStackTrace();
}
 return rs;
 }

public ResultSet selectUser(String userid){
 String sql = "SELECT * FROM user WHERE user_id ='" + userid + "';";
 ResultSet rs = null;
 try {
 rs = stmt.executeQuery (sql); //try catchで囲む
 } catch (SQLException e) {
// TODO Auto-generated catch block
 e.printStackTrace();
}
 return rs;
}

public int insertReservation(String rdate, String facility, String st, String et, String userid){
 String sql = "INSERT INTO reservation (date,start_time,end_time,user_id,facility_name) VALUES ( '"
+ rdate +"', '"+ st +"','" + et + "','" + userid +"','" + facility +"');";
 int rs_int = 0;
try {
 rs_int = stmt.executeUpdate(sql);
 } catch (SQLException e) {
// TODO Auto-generated catch block
 e.printStackTrace();
}
 return rs_int;
}

public int outReservation(String rdate, String facility, String st, String et, String userid){
String sql = "DELETE FROM reservation WHERE date ='" + rdate + "' AND facility_name = '"+ facility +"'AND start_time = '"+ st +"'AND end_time = '"+ et +"'AND user_id = '"+ userid +"' ORDER BY start_time;";
int rs_int = 0;
try {
rs_int = stmt.executeUpdate(sql);
} catch (SQLException e) {
//TODO Auto-generated catch block
e.printStackTrace();
}
return rs_int;
}
public ResultSet getReservationIn(String facility){
	String sql = "SELECT * FROM reservation WHERE facility_name ='" + facility + "'ORDER BY start_time;";
	 ResultSet rs = null;
	try {
	 rs = stmt.executeQuery (sql); //try catchで囲む
	 } catch (SQLException e) {
		 // TODO Auto-generated catch block
	 e.printStackTrace();
	}
	 return rs;
	 }	
}

