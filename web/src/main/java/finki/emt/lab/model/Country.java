package finki.emt.lab.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String continent;

    public Country(String name, String continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }

    public Country(){}
}
