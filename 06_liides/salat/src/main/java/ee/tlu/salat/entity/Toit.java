package ee.tlu.salat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Toit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nimetus;

    @ManyToMany
    List<Toidukomponent> toidukomponendid;
    // [{"nimi": kapsas, kogus: 100g}, {"nimi": porgand, kogus: 200g}]
}

// GenerationType.SEQUENCE -- saan alustada mingist kindlast numbrist
    // ja liikuda mingite kindlate numbrite võrra edasi
// GenerationType.UUID -- acde070d-8c4c-4f0d-9d8a-162843c10333
// GenerationType.AUTO -- automaatselt Postgres seadistus
// GenerationType.IDENTITY -- 1,2,3,4,5...