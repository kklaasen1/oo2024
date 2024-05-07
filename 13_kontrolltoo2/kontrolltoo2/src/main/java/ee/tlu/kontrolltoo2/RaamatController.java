package ee.tlu.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RaamatController {

    @Autowired
    RaamatRepository raamatRepository;

    @Autowired
    NovellRepository novellRepository;

    @GetMapping("koik-raamatud")
    public List<Raamat> getKoikRaamatud() {
        return raamatRepository.findAll();
    }



    @GetMapping("kokku-maksumus")
    public double getKokkuMaksumus() {
        List<Raamat> raamatud = raamatRepository.findAll();
        double kokkuMaksumus = 0.0;

        for (Raamat raamat : raamatud) {
            kokkuMaksumus += raamat.getMaksumus();
        }

        return kokkuMaksumus;
    }

    @GetMapping("koige-rohkem-lehekylgi")
    public Raamat getKoigeRohkemLehekylgi() {
        return raamatRepository.findFirstByLehekylgiOrderByLehekylgiDesc(getKoigeRohkemLehekylgi().getLehekylgi());
    }
}
