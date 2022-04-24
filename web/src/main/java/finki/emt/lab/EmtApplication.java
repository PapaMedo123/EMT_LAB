package finki.emt.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ServletComponentScan
public class EmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmtApplication.class, args);
    }

}
/*
Во рамки на апликацијата се чуваат следните податоци за книгите: id (Long), name (String),
category (enum), author (Author), availableCopies (Integer). Категоријата на книгата може да
биде: NOVEL, THRILER, HISTORY, FANTASY, BIOGRAPHY, CLASSICS, DRAMA. За секој автор пак се
чуваат податоците: id (Long), name (String), surname (String), country (Country). За секоја земја се
чуваат податоците: id (Long), name (String), continent (String)
*/