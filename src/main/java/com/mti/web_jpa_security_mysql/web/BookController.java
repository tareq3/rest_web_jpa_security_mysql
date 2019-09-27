package com.mti.web_jpa_security_mysql.web;

        import com.mti.web_jpa_security_mysql.utility.BookNotFoundException;
        import com.mti.web_jpa_security_mysql.repository.BookRepository;
        import com.mti.web_jpa_security_mysql.domain.Book;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BookController {
    BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Get All notes
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //Create New Note
    @PostMapping("/books")
    public Book addBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    //get A single Book
    @GetMapping("/books/{id}")
    public Book getNoteById(@PathVariable(value = "id") Long bookId) throws BookNotFoundException {
        return bookRepository.findById(bookId).orElseThrow(()->new BookNotFoundException(bookId));
    }

    //Update book
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable(value = "id") Long bookId, @Valid @RequestBody Book bookDetails) throws BookNotFoundException{
        Book book = bookRepository.findById(bookId).orElseThrow(()->new BookNotFoundException(bookId));
        book.setBookName(bookDetails.getBookName());
        book.setAuthorName(bookDetails.getAuthorName());
        book.setIsbn(bookDetails.getIsbn());

        Book updatedBook = bookRepository.save(book);
        return updatedBook;
    }

    //Delete a Book
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) throws BookNotFoundException {
        Book book = bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException(bookId));
        bookRepository.delete(book);

        return ResponseEntity.ok().build();
    }
}
