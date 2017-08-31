package nz.co.eroad.assignment.processing;

import nz.co.eroad.assignment.model.VehicleData;
import nz.co.eroad.assignment.processing.impl.VehicleDataReader;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Rafael Berne
 * @since 30/08/17.
 */
public class VehicleDataReaderTest {

    @Test
    public void testRead() throws IOException {

        ItemReader<VehicleData> reader = new VehicleDataReader(getClass().getResource("/input.csv").getFile());

        VehicleData item1 = reader.read();
        assertEquals("DateTime should be 2013-07-10 02:52:49", item1.getDateTime(),
                DateTime.parse("2013-07-10 02:52:49", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
        assertTrue("Latitude should be -44.490947", -44.490947D == item1.getLatitude());
        assertTrue("Longitude should be 171.220966", 171.220966D == item1.getLongitude());

        VehicleData item2 = reader.read();
        assertEquals("DateTime should be 2013-07-10 02:52:49", item2.getDateTime(),
                DateTime.parse("2013-07-10 02:52:49", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
        assertTrue("Latitude should be -33.912167", -33.912167D == item2.getLatitude());
        assertTrue("Longitude should be 151.215820", 151.215820D == item2.getLongitude());
    }

}
