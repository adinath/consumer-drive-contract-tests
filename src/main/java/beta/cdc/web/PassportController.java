package beta.cdc.web;

import beta.cdc.models.Country;
import beta.cdc.models.Gender;
import beta.cdc.models.Name;
import beta.cdc.models.Passport;
import org.joda.time.LocalDate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Set;

@Controller("/passport")
public class PassportController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Collection<Passport>> create() {
        Passport passport = new Passport()
                .withNumber("H323455")
                .withName(new Name("John Jr", "Smith"))
                .withBirthDate(new LocalDate(1980, 3, 3))
                .withDateOfIssue(new LocalDate(2000, 3, 3))
                .withDateOfExpiry(new LocalDate(2020, 3, 3))
                .withNationality(Country.Indian)
                .withCountryCode(Country.Indian)
                .withFileNumber("PNP3643434")
                .withSex(Gender.Male);

        return ResponseEntity.ok(Set.of(passport));
    }

}
