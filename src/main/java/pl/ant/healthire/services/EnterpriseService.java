package pl.ant.healthire.services;

import pl.ant.healthire.payload.EnterpriseDto;

import java.util.List;

public interface EnterpriseService {
    EnterpriseDto createEnterprise(EnterpriseDto enterpriseDto);

    List<EnterpriseDto> getAllEnterprises();
}
