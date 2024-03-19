package ee.tlu.salat;

//Koosneb toiduainest ja temaga seotud kogusest toidu sees
//Klassikomplekt -> Kartul+omadused ja mitu grammi

import lombok.AllArgsConstructor;
import lombok.Getter;

//Getter -> front-end'ile kuvamiseks
//AllArgsConstructor on sama, mis teha alla Generate->Constructor->valid kõik
@AllArgsConstructor
@Getter
public class Toidukomponent {
    ToiduaineEntity toiduaine;
    int kogus;
}
