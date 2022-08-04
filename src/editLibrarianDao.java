import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class editLibrarianDao {

    public static boolean librarianExists (int librarianID, String librarianName) {
        boolean exists = true;
        try {
            Connection con = DB.getConnection();
            String query = "select * from librarian where id = ? and name = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, librarianID);
            pst.setString(2, librarianName);
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

    public static int updateLibrarianRecord (String name, String email, String contact, int ID) {
        int status = 0;
        try {
            String query = "update librarian set name = ?, email = ?, contact = ? where id = ?";
            Connection con = DB.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, contact);
            pst.setInt(4, ID);
            status = pst.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
