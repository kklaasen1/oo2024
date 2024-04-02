package ee.tlu.kodutoo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class UniversityEntity {
    @Id
    Integer id;
    String name;
    String location;
    int totalStudents;

    /*public UniversityEntity(int id, String name, String location, int totalStudents) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.totalStudents = totalStudents;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }*/
}