package by.kanarski.profito.interf;

import lombok.Data;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
public class Region {

    private Integer regionId;
    private String regionName;
    private Country country;

}
