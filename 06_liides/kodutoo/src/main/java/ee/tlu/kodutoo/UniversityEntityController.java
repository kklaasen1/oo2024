package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UniversityEntityController {
    List<UniversityEntity> universities = new ArrayList<>();

    // localhost:8080/api/universities
    @GetMapping("universities")
    public List<UniversityEntity> getAllUniversities() {
        return universities;
    }

    // localhost:8080/api/universities -->
    // body - raw - json - { "id": 1, "name": "Tallinna Ülikool", "location": "Tallinn", "totalStudents": 9000 }
    @PostMapping("universities")
    public void addUniversity(@RequestBody UniversityEntity university) {
        universities.add(university);
    }

    // localhost: 8080/api/universities/1   number tähistab id
    @DeleteMapping("universities/{id}")
    public List<UniversityEntity> deleteUniversity(@PathVariable int id) {
        for (UniversityEntity uni : universities) {
            if (uni.getId() == id) {
                universities.remove(uni);
                break;
            }
        }
        return universities;
    }

    // localhost:8080/api/universities/2 -->
    // body - raw - json - { "id": 2, "name": "Tartu Ülikool", "location": "Tartu", "totalStudents": 11000 }
    @PutMapping("universities/{id}")
    public List<UniversityEntity> updateUniversity(@PathVariable int id, @RequestBody UniversityEntity updatedUniversity) {
        for (UniversityEntity uni : universities) {
            if (uni.getId() == id) {
                uni.setName(updatedUniversity.getName());
                uni.setLocation(updatedUniversity.getLocation());
                uni.setTotalStudents(updatedUniversity.getTotalStudents());
                break;
            }
        }
        return universities;
    }

    // localhost:8080/api/universities/totalStudents
    @GetMapping("universities/totalStudents")
    public int getTotalStudentsInUniversities() {
        int total = 0;
        for (UniversityEntity uni : universities) {
            total += uni.getTotalStudents();
        }
        return total;
    }
}
