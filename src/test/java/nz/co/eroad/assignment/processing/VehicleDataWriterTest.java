package nz.co.eroad.assignment.processing;

import nz.co.eroad.assignment.model.VehicleData;
import nz.co.eroad.assignment.processing.impl.VehicleDataWriter;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Rafael Berne
 * @since 30/08/17.
 */
public class VehicleDataWriterTest {

    @Test
    public void testWriter() throws IOException {
        ItemWriter<VehicleData> writer = new VehicleDataWriter("/tmp/test.csv");

        VehicleData item = new VehicleData();
        item.setDateTime(new DateTime());
        item.setLatitude(-44.490947);
        item.setLongitude(171.220966);
        item.setTimezone("Pacific/Auckland");
        item.setLocalizedDateTime(new DateTime());

        writer.write(item);

    }

}
