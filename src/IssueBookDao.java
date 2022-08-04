import java.sql.*;
public class IssueBookDao {
	
	public static boolean checkBook (String bookcallno) {
		boolean status = false;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from books where callno = ?");
			ps.setString(1, bookcallno);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static boolean checkQuantity (String bookcallno) {
		boolean status = true;
		try{
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from books where callno=?");
			ps.setString(1, bookcallno);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int var1 = rs.getInt(6);
			int var2 = rs.getInt(7);
			if (var2 >= var1) {
				status = false;
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int save(String bookcallno, int employeeid, String employeename, String employeecontact) {
		int status = 0;
		try {
			Connection con = DB.getConnection();

			status = updatebook(bookcallno); //updates quantity and issue

			if(status > 0) {
			PreparedStatement ps = con.prepareStatement("insert into issuebooks(bookcallno, employeeid, employeename, employeecontact) values(?,?,?,?)");
			ps.setString(1, bookcallno);
			ps.setInt(2, employeeid);
			ps.setString(3, employeename);
			ps.setString(4, employeecontact);
			status = ps.executeUpdate();
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int updatebook (String bookcallno) {
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

			if(quantity > 0) {
			PreparedStatement ps2 = con.prepareStatement("update books set quantity = ?, issued = ? where callno = ?");
			ps2.setInt(1,quantity - 1);
			ps2.setInt(2,issued + 1);
			ps2.setString(3, bookcallno);

			status = ps2.executeUpdate();
			}
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static void increaseIssuedCount (int employeeID, String employeeName) {

		try {
			Connection con = DB.getConnection();
			String query = "select booksissued from employees where employeeid = ? and employeename = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, employeeID);
			pst.setString(2, employeeName);
			ResultSet rs = pst.executeQuery();
			rs.next();

			int issuedCount = rs.getInt(1);
			issuedCount++;

			String query2 = "update employees set booksissued = ? where employeeid = ?";
			pst = con.prepareStatement(query2);
			pst.setInt(1, issuedCount);
			pst.setInt(2, employeeID);
			int update = pst.executeUpdate();

			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}


}
