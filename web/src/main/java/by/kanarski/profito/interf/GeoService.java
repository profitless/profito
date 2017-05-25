package by.kanarski.profito.interf;

import com.vk.api.sdk.objects.base.Country;
import com.vk.api.sdk.objects.database.City;
import com.vk.api.sdk.objects.database.Region;

import java.util.List;
import java.util.Locale;

/**
 * The interface Geo service.
 *
 * @author Dzmitry Kanarski
 * @version 1.0
 */
public interface GeoService {

//    Обязательные

    /**
     * Gets country by id.
     *
     * @param countryId the country id
     * @param locale the locale
     * @return the country by id
     */
    Country getCountryById(Integer countryId, Locale locale);

    /**
     * countryCode можно получать через Locale.getISOCountries()
     *
     * @param countryCode the country code
     * @param locale the locale
     * @return the country by code
     */
    Country getCountryByCode(String countryCode, Locale locale);

    /**
     * Gets region by id.
     *
     * @param regionId the region id
     * @param locale the locale
     * @return the region by id
     */
    Region getRegionById(Integer regionId, Locale locale);

    /**
     * Gets region by country.
     *
     * @param country the country
     * @param locale  the locale
     * @return the region by country
     */
    List<Region> getRegionByCountry (Country country, Locale locale);

    /**
     * Gets city by id.
     *
     * @param cityId the city id
     * @param locale the locale
     * @return the city by id
     */
    City getCityById (Integer cityId, Locale locale);

    /**
     * Gets city by country.
     *
     * @param country the country
     * @param locale  the locale
     * @return the city by country
     */
    List<City> getCityByCountry(Country country, Locale locale);

    /**
     * Gets city by region.
     *
     * @param region the region
     * @param locale the locale
     * @return the city by region
     */
    List<City> getCityByRegion(Region region, Locale locale);

//    Если получится

    /**
     * Gets nearest countries.
     *
     * @param count       the count, сколько стран нужно получить
     * @param baseCountry the base country, страна, относительно которой осуществляется поиск
     * @param locale      the locale
     * @return the nearest countries
     */
    List<Country> getNearestCountries(Integer count, Country baseCountry, Locale locale);

    /**
     * Gets nearest regions.
     *
     * @param count the count
     * @param baseRegion the base region
     * @param locale  the locale
     * @return the nearest regions
     */
    List<Region> getNearestRegions(Integer count, Region baseRegion, Locale locale);

    /**
     * Gets nearest city.
     *
     * @param count the count
     * @param baseCity the base city
     * @param locale the locale
     * @return the nearest city
     */
    List<City> getNearestCity(Integer count, City baseCity, Locale locale);

}
