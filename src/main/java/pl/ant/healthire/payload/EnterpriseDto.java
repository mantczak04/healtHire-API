package pl.ant.healthire.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseDto {
    private Long id;
    private String name;
    private int employees;
    private List<OfficeDto> offices;
}
