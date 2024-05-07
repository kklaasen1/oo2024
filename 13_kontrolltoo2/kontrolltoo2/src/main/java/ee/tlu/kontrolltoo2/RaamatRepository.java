package ee.tlu.kontrolltoo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RaamatRepository extends JpaRepository<Raamat, Long> {


    Raamat findFirstByLehekylgiOrderByLehekylgiDesc(int lehekylgi);

}
