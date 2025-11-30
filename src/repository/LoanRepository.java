package repository;

import database.Database;
import model.Loan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanRepository {

    public boolean isBookBorrowed(int bookId) {
        String sql = "SELECT count(*) FROM loans WHERE bookId = ? AND dateReturned IS NULL";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void add(Loan loan) {
        if(isBookBorrowed(loan.getBookId())) {
            System.out.println("Islem Basarisiz: Kitap zaten oduncte.");
            return;
        }
        String sql = "INSERT INTO loans(bookId, studentId, dateBorrowed) VALUES(?,?,?)";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, loan.getBookId());
            pstmt.setInt(2, loan.getStudentId());
            pstmt.setString(3, loan.getDateBorrowed());
            pstmt.executeUpdate();
            System.out.println("Kitap odunc verildi.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(int bookId, String returnDate) {
        String sql = "UPDATE loans SET dateReturned = ? WHERE bookId = ? AND dateReturned IS NULL";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, returnDate);
            pstmt.setInt(2, bookId);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Kitap iade alindi.");
            } else {
                System.out.println("Hata: Kitap oduncte gorunmuyor.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Loan> getAll() {
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT * FROM loans";
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                loans.add(new Loan(
                    rs.getInt("id"),
                    rs.getInt("bookId"),
                    rs.getInt("studentId"),
                    rs.getString("dateBorrowed"),
                    rs.getString("dateReturned")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return loans;
    }
}