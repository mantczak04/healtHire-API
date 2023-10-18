package pl.ant.healthire.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.ant.healthire.entities.Offer;
import pl.ant.healthire.exceptions.ResourceNotFoundException;
import pl.ant.healthire.payload.NonDetailedOffer;
import pl.ant.healthire.payload.OfferDto;
import pl.ant.healthire.repositories.EnterpriseRepository;
import pl.ant.healthire.repositories.OfferRepository;
import pl.ant.healthire.services.OfferService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    private final ModelMapper mapper;

    private final EnterpriseRepository enterpriseRepository;

    public OfferServiceImpl(OfferRepository offerRepository,
                            ModelMapper mapper,
                            EnterpriseRepository enterpriseRepository) {
        this.offerRepository = offerRepository;
        this.mapper = mapper;
        this.enterpriseRepository = enterpriseRepository;
    }

    @Override
    public OfferDto createOffer(OfferDto offerDto) {
        Offer offer = mapper.map(offerDto, Offer.class);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        offer.setCreationDate(now);
        calendar.add(Calendar.DATE, 30);
        now = calendar.getTime();
        offer.setExpirationDate(now);
        Offer savedOffer = offerRepository.save(offer);


        return mapper.map(savedOffer, OfferDto.class);
    }


    @Override
    public List<OfferDto> getAllOffers() {
        List<Offer> offers = offerRepository.findAll();
        return offers.stream().map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OfferDto getOfferById(Long id) {
        Offer offer = offerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Offer", "id", id)
        );
        return mapper.map(offer, OfferDto.class);
    }

    @Override
    public OfferDto updateOfferById(OfferDto offerDto, Long id) {
        Offer offer = offerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Offer", "id", id)
        );
        offer.setTitle(offerDto.getTitle());
        offer.setLevel(offerDto.getLevel());
        offer.setSalary(offerDto.getSalary());
        offer.setExpirationDate(offerDto.getExpirationDate());
        offer.setCreationDate(offerDto.getCreationDate());
        offer.setId(id);

        Offer updatedOffer = offerRepository.save(offer);
        return mapper.map(updatedOffer, OfferDto.class);
    }

    @Override
    public List<NonDetailedOffer> getAllNonDetailedOffers() {
        List<Offer> offers = offerRepository.findAll();

        return offers.stream().map(this::mapOfferToNonDetailedOffer)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOfferById(Long id) {
        Offer offer = offerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Offer", "id", id));
        offerRepository.delete(offer);
    }

    @Override
    public List<OfferDto> getAllByCity(String city) {
        List<Offer> offers = offerRepository.getAllByCity(city);
        return offers.stream().map((offer) -> mapToDto(offer))
                .collect(Collectors.toList());
    }

    @Override
    public List<NonDetailedOffer> getAllNonDetailedOffersByCity(String city) {
        List<Offer> offers = offerRepository.getAllByCity(city);
        return offers.stream().map(this::mapOfferToNonDetailedOffer)
                .collect(Collectors.toList());
    }

    private NonDetailedOffer mapOfferToNonDetailedOffer(Offer offer){
        NonDetailedOffer nonDetailedOffer = new NonDetailedOffer();
        nonDetailedOffer.setSalary(offer.getSalary());
        nonDetailedOffer.setTitle(offer.getTitle());
        nonDetailedOffer.setEnterpriseName(offer.getOffice().getEnterprise().getName());
        nonDetailedOffer.setCity(offer.getOffice().getCity());

        return nonDetailedOffer;
    }

    private OfferDto mapToDto(Offer offer){
        OfferDto offerDto = new OfferDto();
        offerDto.setId(offer.getId());
        offerDto.setTitle(offer.getTitle());
        offerDto.setLevel(offer.getLevel());
        offerDto.setSalary(offer.getSalary());
        offerDto.setCreationDate(offer.getCreationDate());
        offerDto.setOfficeId(offer.getOffice().getId());

        return offerDto;
    }

}
