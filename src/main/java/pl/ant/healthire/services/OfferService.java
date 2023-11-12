package pl.ant.healthire.services;

import pl.ant.healthire.payload.NonDetailedOffer;
import pl.ant.healthire.payload.OfferDto;

import java.util.List;

public interface OfferService {
    OfferDto createOffer(OfferDto offerDto);

    List<OfferDto> getAllOffers();

    OfferDto getOfferById(Long id);

    OfferDto updateOfferById(OfferDto offerDto, Long id);

    List<NonDetailedOffer> getAllNonDetailedOffers(); // non-detailed offers for main page offers list

    void deleteOfferById(Long id);

    List<OfferDto> getAllByCity(String city);


    List<OfferDto> searchOffersByTitle(String query);

    List<OfferDto> searchOffersBySalaryRange(Integer minSalary, Integer maxSalary);

    List<OfferDto> searchOffersByCityAndSalaryRange(String city, Integer minSalary, Integer maxSalary);

    List<NonDetailedOffer> searchNonDetailedOffersByCityAndSalaryRange(String city,
                                                                       Integer minSalary,
                                                                       Integer maxSalary);

}
