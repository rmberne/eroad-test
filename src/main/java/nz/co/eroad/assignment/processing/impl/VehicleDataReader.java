package nz.co.eroad.assignment.processing.impl;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import nz.co.eroad.assignment.model.VehicleData;
import nz.co.eroad.assignment.processing.ItemReader;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Rafael Berne
 * @since 30/08/17.
 */
public class VehicleDataReader implements ItemReader<VehicleData> {

    private CSVIterator iterator;

    public VehicleDataReader(String csvFile) throws IOException {
        if (StringUtils.isBlank(csvFile)) {
            throw new IllegalArgumentException("The csvFile argument must not be null!");
        }
        iterator = new CSVIterator(new CSVReaderBuilder(new FileReader(csvFile)).build());
    }

    @Override
    public VehicleData read() {
        VehicleData item = null;
        if (iterator.hasNext()) {
            String[] line = iterator.next();
            if (line != null && line.length == 3) {
                item = new VehicleData();
                item.setDateTime(DateTime.parse(line[0], DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
                item.setLatitude(Double.parseDouble(line[1]));
                item.setLongitude(Double.parseDouble(line[2]));
            }
        }
        return item;
    }

}
