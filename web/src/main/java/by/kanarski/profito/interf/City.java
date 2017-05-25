package by.kanarski.profito.interf;

import lombok.Data;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
public class City {

    private Integer cityId;
    private String cityName;
    private Region region;


}
