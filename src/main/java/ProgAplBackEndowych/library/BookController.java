package ProgAplBackEndowych.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/books")
public class BookController {

        @Autowired
        BookRepository bookRepository;

      /*  @GetMapping("/test")
        public int test(){
            return 1;
        }*/


        @GetMapping("/home")
        public String home() {
            return glowna.html;
        }



        @GetMapping("/books")
        public List<Book> getAll(){
            return bookRepository.getAll();
        }

        @GetMapping("/books/{id}")
        public Book getById(@PathVariable("id") int id){
            return bookRepository.getById(id);
        }

        @PostMapping("/books")
        public int add(@RequestBody List<Book> books){
            return bookRepository.save(books);
        }

        @PutMapping("/books/{id}")
        public int update(@PathVariable("id") int id, @RequestBody Book updatedBook){
            Book book = bookRepository.getById(id);

            if (book !=null){
                book.setName(updatedBook.getName());
                book.setRating(updatedBook.getRating());

                bookRepository.update(book);

                return 1;
            } else{
                return -1;
            }
        }

        @DeleteMapping("/books/{id}")
        public int delete(@PathVariable("id") int id) {
            return bookRepository.delete(id);

        }


}
