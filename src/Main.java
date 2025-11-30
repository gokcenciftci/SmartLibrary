import database.Database;
import model.Book;
import model.Loan;
import model.Student;
import repository.BookRepository;
import repository.LoanRepository;
import repository.StudentRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database.createNewDatabase();

        BookRepository bookRepo = new BookRepository();
        StudentRepository studentRepo = new StudentRepository();
        LoanRepository loanRepo = new LoanRepository();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- SMART LIBRARY SISTEMI ---");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitaplari Listele");
            System.out.println("3. Kitap Guncelle");
            System.out.println("4. Kitap Sil");
            System.out.println("5. Ogrenci Ekle");
            System.out.println("6. Ogrencileri Listele");
            System.out.println("7. Ogrenci Guncelle");
            System.out.println("8. Ogrenci Sil");
            System.out.println("9. Kitap Odunc Ver");
            System.out.println("10. Odunc Listesi");
            System.out.println("11. Kitap Iade Al");
            System.out.println("0. Cikis");
            System.out.print("Seciminiz: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Gecersiz giris.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Baslik: ");
                    String title = scanner.nextLine();
                    System.out.print("Yazar: ");
                    String author = scanner.nextLine();
                    System.out.print("Yil: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    bookRepo.add(new Book(title, author, year));
                    break;

                case 2:
                    for (Book b : bookRepo.getAll()) {
                        System.out.println(b);
                    }
                    break;

                case 3:
                    System.out.print("Guncellenecek Kitap ID: ");
                    int updateBookId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Yeni Baslik: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Yeni Yazar: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Yeni Yil: ");
                    int newYear = Integer.parseInt(scanner.nextLine());
                    bookRepo.update(new Book(updateBookId, newTitle, newAuthor, newYear));
                    System.out.println("Kitap guncellendi.");
                    break;

                case 4:
                    System.out.print("Silinecek Kitap ID: ");
                    int deleteBookId = Integer.parseInt(scanner.nextLine());
                    bookRepo.delete(deleteBookId);
                    System.out.println("Kitap silindi.");
                    break;

                case 5:
                    System.out.print("Ogrenci Ad: ");
                    String name = scanner.nextLine();
                    System.out.print("Bolum: ");
                    String dept = scanner.nextLine();
                    studentRepo.add(new Student(name, dept));
                    break;

                case 6:
                    for (Student s : studentRepo.getAll()) {
                        System.out.println(s);
                    }
                    break;

                case 7:
                    System.out.print("Guncellenecek Ogrenci ID: ");
                    int updateStudentId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Yeni Ad: ");
                    String newName = scanner.nextLine();
                    System.out.print("Yeni Bolum: ");
                    String newDept = scanner.nextLine();
                    studentRepo.update(new Student(updateStudentId, newName, newDept));
                    System.out.println("Ogrenci guncellendi.");
                    break;

                case 8:
                    System.out.print("Silinecek Ogrenci ID: ");
                    int deleteStudentId = Integer.parseInt(scanner.nextLine());
                    studentRepo.delete(deleteStudentId);
                    System.out.println("Ogrenci silindi.");
                    break;

                case 9:
                    System.out.print("Kitap ID: ");
                    int bId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ogrenci ID: ");
                    int sId = Integer.parseInt(scanner.nextLine());
                    String date = LocalDate.now().toString();
                    loanRepo.add(new Loan(bId, sId, date));
                    break;

                case 10:
                    for (Loan l : loanRepo.getAll()) {
                        System.out.println(l);
                    }
                    break;

                case 11:
                    System.out.print("Iade Edilen Kitap ID: ");
                    int retId = Integer.parseInt(scanner.nextLine());
                    String retDate = LocalDate.now().toString();
                    loanRepo.returnBook(retId, retDate);
                    break;

                case 0:
                    System.out.println("Cikis yapiliyor...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Hatali secim.");
            }
        }
    }
}