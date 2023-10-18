package pl.ant.healthire.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.ant.healthire.entities.Enterprise;
import pl.ant.healthire.payload.EnterpriseDto;
import pl.ant.healthire.repositories.EnterpriseRepository;
import pl.ant.healthire.services.EnterpriseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    private EnterpriseRepository enterpriseRepository;
    private ModelMapper mapper;

    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository, ModelMapper mapper) {
        this.enterpriseRepository = enterpriseRepository;
        this.mapper = mapper;
    }

    @Override
    public EnterpriseDto createEnterprise(EnterpriseDto enterpriseDto) {
        Enterprise enterprise = mapper.map(enterpriseDto, Enterprise.class);
        Enterprise savedEnterprise = enterpriseRepository.save(enterprise);
        return mapper.map(savedEnterprise, EnterpriseDto.class);
    }

    @Override
    public List<EnterpriseDto> getAllEnterprises() {
        List<Enterprise> enterprises = enterpriseRepository.findAll();
        return enterprises.stream().map((enterprise) -> mapper.map(enterprise, EnterpriseDto.class))
                .collect(Collectors.toList());
    }
}
