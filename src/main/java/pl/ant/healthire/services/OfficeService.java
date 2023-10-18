package pl.ant.healthire.services;

import pl.ant.healthire.payload.OfficeDto;

import java.util.List;

public interface OfficeService {

    OfficeDto createOffice(OfficeDto officeDto);

    List<OfficeDto> getAllOffices();
}
