

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ReturnBookDao {


	static int delay;

	public static String getIssuedDate(String callno, int employeeid) {
		String issueddate = "";
		try {
			Connection con = DB.getConnection();
			PreparedStatement pst = con.prepareStatement("Select issueddate from issuebooks where bookcallno = ? and employeeid = ?");
			pst.setString(1, callno);
			pst.setInt(2, employeeid);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				issueddate = rs.getString(1);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return issueddate;
	}

	public static int delete(String bookcallno, int employeeid){
		int status = 0;
		try {
			Connection con = DB.getConnection();
			
			status = updatebook(bookcallno); //updating quantity and issue
			
			if(status > 0) {
				PreparedStatement ps = con.prepareStatement("delete from issuebooks where bookcallno = ? and employeeid = ?");
				ps.setString(1, bookcallno);
				ps.setInt(2, employeeid);
				status = ps.executeUpdate();
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int updatebook(String bookcallno) {
		int status = 0;
		int quantity = 0, issued = 0;
		try {
			Connection con = DB.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select quantity, issued from books where callno = ?");
			ps.setString(1, bookcallno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				quantity = rs.getInt("quantity");
				issued = rs.getInt("issued");
			}
			
			if(issued > 0) {
			PreparedStatement ps2 = con.prepareStatement("update books set quantity = ?, issued = ? where callno = ?");
			ps2.setInt(1,quantity + 1);
			ps2.setInt(2,issued - 1);
			ps2.setString(3, bookcallno);
			
			status = ps2.executeUpdate();
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static boolean isLate(String callno, int employeeid) {
		String issuedate = getIssuedDate(callno, employeeid);

		// Create a formatting object and a LocalDateTime object that stores current time.
		DateTimeFormatter formatting = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(); //current date
		LocalDateTime issueDate = LocalDateTime.parse(issuedate, formatting); //date at which book was issued.
		LocalDateTime returnDate = issueDate.plus(1, ChronoUnit.WEEKS); //date at which was to be returned.

		// find difference between "now" and "returnDate".
		long diff = ChronoUnit.DAYS.between(returnDate, now);

		if (diff > 0) {
			delay = (int) diff;
			return true;
			// late.
		}
		else {
			return false;
			// on-time/early.
		}
	}

	public static void increaseReturnCount (int employeeID) {

		try {
			Connection con = DB.getConnection();
			String query = "select booksreturned from employees where employeeid = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, employeeID);
			ResultSet rs = pst.executeQuery();
			rs.next();

			int returnCount = rs.getInt(1);
			returnCount++;

			String query2 = "update employees set booksreturned = ? where employeeid = ?";
			pst = con.prepareStatement(query2);
			pst.setInt(1, returnCount);
			pst.setInt(2, employeeID);
			int update = pst.executeUpdate();

			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
