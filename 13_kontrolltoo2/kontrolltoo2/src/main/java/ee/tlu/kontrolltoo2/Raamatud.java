package ee.tlu.kontrolltoo2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Raamatud {
    private String title;
    private String subtitle;
    private String isbn13;
    private String price;
    private String image;
    private String url;
}
