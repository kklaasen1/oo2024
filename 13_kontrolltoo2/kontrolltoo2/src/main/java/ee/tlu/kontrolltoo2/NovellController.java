package ee.tlu.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class NovellController {

    @Autowired
    NovellRepository novellRepository;

    @GetMapping("novellid")
    public List<Novell> getNovellid() {
        return novellRepository.findAll();
    }

    @PostMapping("novellid")
    public List<Novell> postNovell(@RequestBody Novell novell) {
        if (novell.getSisu().length() < 10) {
            return novellRepository.findAll();
        }
        novellRepository.save(novell);
        return novellRepository.findAll();
    }

    @DeleteMapping("novellid/{id}")
    public List<Novell> deleteNovell(@PathVariable Long id) {
        novellRepository.deleteById(id);
        return novellRepository.findAll();
    }

    @GetMapping("vanim-novell")
    public Novell getVanimNovell() {
        return novellRepository.findFirstByAastaNotNullOrderByAastaAsc();
    }

    @GetMapping("uuemad-novellid/{aasta}")
    public List<Novell> getUuemadNovellid(@PathVariable int aasta) {
        return novellRepository.findByAastaGreaterThan(aasta);
    }

    @GetMapping("lyhim-novell")
    public Novell getLyhimNovell() {
        return novellRepository.findNovelWithShortestSisu();
    }


}
