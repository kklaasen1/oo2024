package ee.tlu.salat.controller;

import ee.tlu.salat.entity.Toidukomponent;
import ee.tlu.salat.entity.Toit;
import ee.tlu.salat.repository.ToidukomponentRepository;
import ee.tlu.salat.repository.ToitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToitController {

    @Autowired
    ToitRepository toitRepository;

    @Autowired
    ToidukomponentRepository toidukomponentRepository;

    // localhost:8080/toit
    @GetMapping("toit")
    public List<Toit> getToidud() {
        return toitRepository.findAll();
    }
    // DELETE localhost:8080/toit
    @DeleteMapping("toit/{id}")
    public List<Toit> deleteToit(@PathVariable Long id) {
        toitRepository.deleteById(id);
        return toitRepository.findAll();
    }

    @PostMapping("toit")
    public List<Toit> addToit(@RequestBody Toit toit) {
        toitRepository.save(toit);
        return toitRepository.findAll();
    }

    @GetMapping("toidu-valgu-kogus/{id}")
    public double getToiduValguKogus(@PathVariable Long id) {
        double sum = 0;
        List<Toidukomponent> toidukomponendid = toidukomponentRepository.findByToit_Id(id);
        for (Toidukomponent t: toidukomponendid) {
            sum += t.getKogus() * t.getToiduaine().getValk();
        }
        return sum;
    }
}
