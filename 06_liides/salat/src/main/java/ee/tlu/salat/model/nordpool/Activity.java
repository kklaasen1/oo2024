package ee.tlu.salat.model.nordpool;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Activity {
    private String activity;
    private String type;
    private int participants;
    private int price;
    private String link;
    private String key;
    private int accessibility;
}

//type - education, recreational, social, diy, charity, cooking, relaxation, music, busywork
//https://www.boredapi.com/api/activity?type=social&participants=2
