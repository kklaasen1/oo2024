package ee.tlu.kontrolltoo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NovellRepository extends JpaRepository<Novell, Long> {

    Novell findFirstByAastaNotNullOrderByAastaAsc();



    List<Novell> findByAastaGreaterThan(int aasta);

    @Query(value = "SELECT n FROM Novell n ORDER BY LENGTH(n.sisu) ASC LIMIT 1")
    Novell findNovelWithShortestSisu();

}
