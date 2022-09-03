package ProgAplBackEndowych.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

        @Autowired
        BookRepository bookRepository;

      /*  @GetMapping("/test")
        public int test(){
            return 1;
        }*/

        @GetMapping("/")
        public List<Book> getAll(){
            return bookRepository.getAll();
        }

        @GetMapping("/{id}")
        public Book getById(@PathVariable("id") int id){
            return bookRepository.getById(id);
        }

        @PostMapping("/")
        public int add(@RequestBody List<Book> books){
            return bookRepository.save(books);
        }


}
