package finki.emt.lab.web.rest;

import finki.emt.lab.model.Book;
import finki.emt.lab.model.enums.BookCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/category")
public class CategoriesRestController {

    @GetMapping
    public List<BookCategory> findAll(){
        return new ArrayList<BookCategory>(List.of(BookCategory.values()));
    }
}
