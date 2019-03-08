package beta.cdc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.joda.time.LocalDate;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    String number;
    Name name;
    LocalDate dateOfIssue;
    LocalDate dateOfExpiry;
    String fileNumber;
    Country nationality;
    Country countryCode;
    String placeOfBirth;
    String placeOfIssue;
    Gender sex;
    LocalDate birthDate;
}
