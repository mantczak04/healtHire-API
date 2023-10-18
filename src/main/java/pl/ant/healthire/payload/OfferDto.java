package pl.ant.healthire.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ant.healthire.entities.Level;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {
    private Long id;
    private String title;
    private int salary;
    private Level level;
    //private Long enterpriseId;

    private Long officeId;

    @JsonIgnore
    private Date creationDate;
    @JsonIgnore // ignore expirationDate and creationDate for main page - show it only for ENTERPRISES
    private Date expirationDate;
}
