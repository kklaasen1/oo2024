package ee.tlu.proovikontrolltoo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToodeRepository extends JpaRepository<Toode, Long> {

    List<Toode> findByHindBetween(double hindStart, double hindEnd);

    Toode findFirstByHindNotNullOrderByHindDesc();

    List<Toode> findByNimiContains(String nimi);

    List<Toode> findByNimiStartsWith(String nimi);


}


// application.properties enne kontrolltööd = create-drop (update asemel), kui vaja andmebaas tühjendada (nt. klassi nimi sama aga andmetüübid teised)