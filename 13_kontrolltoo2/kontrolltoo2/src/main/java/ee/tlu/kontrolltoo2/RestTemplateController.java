package ee.tlu.kontrolltoo2;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
public class RestTemplateController {

    @GetMapping("saa-raamatud")
    public List<Raamatud> getRaamatud() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.itbook.store/1.0/search/mongodb";
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);
        return response.getBody().books;
    }

    @GetMapping("saa-raamatud/pealkirjad")
    public List<String> getRaamatudPealkirjad() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.itbook.store/1.0/search/mongodb";
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);

        List<String> pealkirjad = new ArrayList<>();
        if (response.getBody() != null && response.getBody().getBooks() != null) {
            for (Raamatud raamat : response.getBody().getBooks()) {
                pealkirjad.add(raamat.getTitle());
            }
        }

        return pealkirjad;
    }

    @GetMapping("saa-raamat/{pealkiri}")
    public ResponseEntity<Raamatud> getRaamat(@PathVariable String pealkiri) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.itbook.store/1.0/search/" + pealkiri;
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);

        if (response.getBody() != null && response.getBody().getBooks() != null) {
            for (Raamatud raamat : response.getBody().getBooks()) {
                if (raamat.getTitle().equalsIgnoreCase(pealkiri)) {
                    return ResponseEntity.ok(raamat);
                }
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("vanim-raamat")
    public ResponseEntity<Books> getOldestBook() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/books";
        ResponseEntity<Books[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Books[].class);
        Books[] books = response.getBody();
        if (books != null && books.length > 0) {
            Books oldestBook = null;
            Integer oldestYear = Integer.MAX_VALUE;
            for (Books book : books) {
                if (book.getPublication_year() != null) {
                    try {
                        Integer year = Integer.parseInt(book.getPublication_year().toString());
                        if (year < oldestYear) {
                            oldestYear = year;
                            oldestBook = book;
                        }
                    } catch (NumberFormatException e) {
                        //
                    }
                }
            }
            if (oldestBook != null) {
                return ResponseEntity.ok(oldestBook);
            }
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("uuemad-raamatud/{aasta}")
    public ResponseEntity<List<Books>> getNewerBooks(@PathVariable("aasta") int aasta) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/books";
        ResponseEntity<Books[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Books[].class);
        Books[] books = response.getBody();
        if (books != null) {
            List<Books> newerBooks = Arrays.stream(books)
                    .filter(book -> {
                        Object publicationYear = book.getPublication_year();
                        if (publicationYear instanceof Integer) {
                            return (int) publicationYear >= aasta;
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(newerBooks);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("vahemik/{aasta1}/{aasta2}")
    public ResponseEntity<List<Books>> getBooksInRange(@PathVariable("aasta1") int aasta1, @PathVariable("aasta2") int aasta2) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/books";
        ResponseEntity<Books[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Books[].class);
        Books[] books = response.getBody();
        if (books != null) {
            List<Books> booksInRange = Arrays.stream(books)
                    .filter(book -> {
                        Object publicationYear = book.getPublication_year();
                        if (publicationYear instanceof Integer) {
                            int year = (int) publicationYear;
                            return year >= aasta1 && year <= aasta2;
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(booksInRange);
        }
        return ResponseEntity.notFound().build();
    }



}
