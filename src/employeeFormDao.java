import java.sql.*;

public class employeeFormDao {

    public static boolean exists (int employeeID, String employeeName) {
        boolean check = false;
        try {
            Connection con = DB.getConnection();
            String query = "select * from employees where employeeid = ? and employeename = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, employeeID);
            pst.setString(2, employeeName);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                check = true;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return check;
    }

    public static int save (int employeeID, String employeeName, String employeeEmail, String employeeContact) {
        int status = 0;

        try {
            Connection con=DB.getConnection();

            PreparedStatement ps=con.prepareStatement("insert into employees (employeeid, employeename, employeecontact, employeemail, booksissued, booksreturned) values(?, ?, ?, ?, ?, ?)");

            ps.setInt(1, employeeID);
            ps.setString(2, employeeName);
            ps.setString(3,employeeContact);
            ps.setString(4,employeeEmail);
            ps.setInt(5,0);
            ps.setInt(6,0);

            status=ps.executeUpdate();

            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        return status;
    }

    public static int delete (int employeeID) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from employees where id = ?");
            pst.setInt(1, employeeID);
            status = pst.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

}
