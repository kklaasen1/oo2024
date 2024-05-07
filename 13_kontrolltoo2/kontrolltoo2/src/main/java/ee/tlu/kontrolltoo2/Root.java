package ee.tlu.kontrolltoo2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Root {
        public String error;
        public String total;
        public String page;
        public ArrayList<Raamatud> books;

}
