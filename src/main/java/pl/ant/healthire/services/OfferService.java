package pl.ant.healthire.services;

import pl.ant.healthire.entities.Offer;
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

    List<NonDetailedOffer> getAllNonDetailedOffersByCity(String city);
}
