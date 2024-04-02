package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UniversityEntityController {
    UniversityRepository universityRepository;

    public UniversityEntityController(UniversityRepository uinversityRepository) {
        this.universityRepository = uinversityRepository;
    }
    //List<UniversityEntity> universities = new ArrayList<>();

    // localhost:8080/api/universities
    @GetMapping("universities")
    public List<UniversityEntity> getAllUniversities() {
        return universityRepository.findAll();
    }

    // localhost:8080/api/universities -->
    // body - raw - json - { "id": 1, "name": "Tallinna Ülikool", "location": "Tallinn", "totalStudents": 9000 }
    @PostMapping("universities/{id}/{name}/{location}/{totalStudents}")
    public List<UniversityEntity> addUniversity(
            @PathVariable int id,
            @PathVariable String name,
            @PathVariable String location,
            @PathVariable int totalStudents
    ) {
        UniversityEntity university = new UniversityEntity(id, name, location, totalStudents);
        universityRepository.save(university);
        return universityRepository.findAll();
    }

    // localhost: 8080/api/universities/1   number tähistab id
    @DeleteMapping("universities/{id}")
    public List<UniversityEntity> deleteUniversity(@PathVariable Integer id) {
        universityRepository.deleteById(id);
        return universityRepository.findAll();
    }

    // localhost:8080/api/universities/2 -->
    // body - raw - json - { "id": 2, "name": "Tartu Ülikool", "location": "Tartu", "totalStudents": 11000 }
    @PutMapping("universities/{id}/{name}/{location}/{totalStudents}")
    public List<UniversityEntity> updateUniversity(
            @PathVariable int id,
            @PathVariable String name,
            @PathVariable String location,
            @PathVariable int totalStudents
    ) {
        UniversityEntity university = universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found with id: " + id));
        universityRepository.save(university);
        return universityRepository.findAll();
    }

    // localhost:8080/api/universities/totalStudents
    @GetMapping("universities/totalStudents")
    public int getTotalStudentsInUniversities() {
        int total = 0;
        for (UniversityEntity uni : universityRepository.findAll()) {
            total += uni.getTotalStudents();
        }
        return total;
    }
}