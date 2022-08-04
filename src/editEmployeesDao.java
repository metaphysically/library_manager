import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class editEmployeesDao {

    public static boolean employeeExists (int employeeID, String employeeName) {
        Boolean exists = false;

        try {
            Connection con = DB.getConnection();
            String query = "select * from employees where employeeid = ? and employeename = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, employeeID);
            pst.setString(2, employeeName);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                exists = true;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return exists;
    }

    public static int updateEmployeeRecord (String employeeName, String employeeMail, String employeeContact, int employeeID) {
        int status = 0;
        try {
            String query = "update employees set employeename = ?, employeemail = ?, employeeContact = ? where employeeid = ?";
            Connection con = DB.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, employeeName);
            pst.setString(2, employeeMail);
            pst.setString(3, employeeContact);
            pst.setInt(4, employeeID);
            status = pst.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
