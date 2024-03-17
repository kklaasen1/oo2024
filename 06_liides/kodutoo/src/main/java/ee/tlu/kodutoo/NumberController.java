package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NumberController {
    List<Integer> numbers = new ArrayList<>();

    //localhost:8080/numbers
    @GetMapping("numbers")
    public List<Integer> getAllNumbers() {
        return numbers;
    }

    @PostMapping("numbers")
    public void addNumber(@RequestParam int number) {
        numbers.add(number);
    }

    @DeleteMapping("numbers/{number}")
    public List<Integer> deleteNumber(@PathVariable int number) {
        numbers.remove(Integer.valueOf(number));
        return numbers;
    }

    @GetMapping("numbers/count")
    public int countNumbers() {
        return numbers.size();
    }

    @GetMapping("numbers/sum")
    public int sumNumbers(){
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    @GetMapping("numbers/average")
    public double averageNumbers() {
        if (numbers.isEmpty()) {
            return 0.0;
        } else {
            int sum = sumNumbers();
            return (double) sum / numbers.size();
        }
    }

}
