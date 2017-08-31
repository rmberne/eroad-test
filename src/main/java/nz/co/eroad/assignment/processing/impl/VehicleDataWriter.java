package nz.co.eroad.assignment.processing.impl;

import com.opencsv.CSVWriter;
import nz.co.eroad.assignment.model.VehicleData;
import nz.co.eroad.assignment.processing.ItemWriter;
import org.joda.time.format.DateTimeFormat;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Rafael Berne
 * @since 30/08/17.
 */
public class VehicleDataWriter implements ItemWriter<VehicleData> {

    private String destinationFile;
    private CSVWriter writer;

    public VehicleDataWriter(String destinationFile) throws IOException {
        this.destinationFile = destinationFile;
        this.writer = new CSVWriter(new FileWriter(destinationFile));
    }

    @Override
    public void write(VehicleData item) {
        String[] line = new String[] { item.getDateTime().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")),
                                       item.getLatitude().toString(), item.getLongitude().toString(),
                                       item.getTimezone(), item.getLocalizedDateTime().toString(
                DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")) };
        writer.writeNext(line);
        writer.flushQuietly();
    }

    @Override
    public void close() {
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
