package pl.ant.healthire.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.ant.healthire.entities.Office;
import pl.ant.healthire.payload.OfficeDto;
import pl.ant.healthire.repositories.OfficeRepository;
import pl.ant.healthire.services.OfficeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;
    private final ModelMapper mapper;

    public OfficeServiceImpl(OfficeRepository officeRepository, ModelMapper mapper) {
        this.officeRepository = officeRepository;
        this.mapper = mapper;
    }

    @Override
    public OfficeDto createOffice(OfficeDto officeDto) {
        Office office = mapper.map(officeDto, Office.class);
        Office savedOffice = officeRepository.save(office);

        return mapper.map(savedOffice, OfficeDto.class);
    }

    @Override
    public List<OfficeDto> getAllOffices() {
        List<Office> offices = officeRepository.findAll();
        return offices.stream().map((office) -> mapper.map(office, OfficeDto.class))
                .collect(Collectors.toList());
    }
}
