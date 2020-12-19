package robinstewart.marsrover.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Component
public class DatesService {
    private final Logger logger = LoggerFactory.getLogger(DatesService.class);

    public List<String> getDates() {
        List<String> dateList = new ArrayList<>();
        try {
            InputStream inputStream = getClass().getResourceAsStream("/InputDates.txt");
            Stream<String> stream = new BufferedReader(new InputStreamReader(inputStream)).lines();
            DateFormat nasaDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String[] formats = {"MM/dd/yy", "MMM d, yyyy", "MMM-d-yyyy"};
            stream.forEach(date -> {
                for (String format : formats) {
                    DateFormat originalFormat = new SimpleDateFormat(format);
                    try {
                        Date newDate = originalFormat.parse(date);
                        if (newDate != null) {
                            String nasaDate = nasaDateFormat.format(newDate);
                            dateList.add(nasaDate);
                            logger.info("{} added to list", nasaDate);
                        }
                    } catch (Exception e) {
                        logger.info("Date format, {}, does not match {}", format, e.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            logger.error("Error with file {}", e.getMessage());
        }
        return dateList;
    }
}