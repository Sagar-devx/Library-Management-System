A Java-based console application for managing books, students, and transactions in a library.
This project demonstrates Object-Oriented Programming (OOP) concepts, file handling, and exception management.

Features-
            Book Management – Add, view, search, and delete books.

            Student Management – Register students, view details, and update information.

            Transaction Management – Issue and return books with proper tracking.

            File Storage – Data is stored in .dat files to retain information between sessions.

            Custom Exceptions – Handles cases like Book Not Found or Student Not Found.

            Package Structure – Clean separation of code into packages for better maintainability.

Project Structure - Library Management System/
                    │── pkg_book/                - Book-related classes
                    │── pkg_person/              - Student and Librarian classes
                    │── pkg_transaction/         - Book issue & return logic
                    │── pkg_exception/           - Custom exceptions
                    │── pkg_main/                - Main entry point
                    │── Books.dat                - Stores book data
                    │── Student.dat              - Stores student data
                    │── book_transactions.dat    - Stores issued/returned book records
                    │── .gitignore               - Ignored files/folders

Technologies Used-
                    Java (Core, OOP, File I/O, Exception Handling)

                    Packages for modular design

                    Custom Exceptions for better error handling                    
                                
How to Run -  (1) Clone the repository  - git clone  https://github.com/Sagar-devx/Library-Management-System.git

              (2) Open in IntelliJ IDEA or any Java IDE

              (3) Run the main.java file from pkg_main package.      

Sample OutPut -  ====== Library Management System ======

                        Enter 1 if Student
                        Enter 2 if Librarian
                        Enter 3 if want to exit:
                                        

