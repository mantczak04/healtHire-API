package pl.ant.healthire.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ant.healthire.entities.Offer;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfficeDto {
    private Long id;
    private String city;
    private String address;
    private Long enterpriseId;
    private List<Offer> offers;
}
