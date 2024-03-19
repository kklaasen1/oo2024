package ee.tlu.salat;

import org.springframework.data.jpa.repository.JpaRepository;

//Interface - me ei lähe midagi tegema, see on ise meile genereeritud
//extends - teeb ToiduaineRepository'st alamklassi
public interface ToiduaineRepository extends JpaRepository<ToiduaineEntity, String> {
}
