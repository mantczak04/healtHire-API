package pl.ant.healthire.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// A non detailed type of offer for Job List Display - contains only key information.
public class NonDetailedOffer {
    private String title;
    private int salary;
    private String enterpriseName;
    private String city;
}
