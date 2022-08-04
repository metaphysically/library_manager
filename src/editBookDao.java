import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class editBookDao {

    public static boolean bookExists (String callno, String name) {
        boolean exists = false;

        try {
            String query = "select * from books where callno = ? and name = ?";
            Connection con = DB.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, callno);
            pst.setString(2, name);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                exists = true;
            }
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return exists;
    }

    public static int updateBookRecord (String bookName, String bookAuthor, String bookPublisher, int bookQuantity, String bookCallNo) {
        int status = 0;

        try {
            String query = "update books set name = ?, author = ?, publisher = ?, quantity = ? where callno = ?";
            Connection con = DB.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, bookName);
            pst.setString(2, bookAuthor);
            pst.setString(3, bookPublisher);
            pst.setInt(4, bookQuantity);
            pst.setString(5, bookCallNo);
            status = pst.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
