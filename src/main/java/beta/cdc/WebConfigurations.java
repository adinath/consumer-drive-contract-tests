package beta.cdc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class WebConfigurations {

    @Bean
    public ObjectMapper objectMapper() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");

        return new ObjectMapper()
                .setDateFormat(df)
                .registerModule(new JodaModule());
    }




}
