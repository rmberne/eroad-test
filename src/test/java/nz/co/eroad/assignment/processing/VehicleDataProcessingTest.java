package nz.co.eroad.assignment.processing;

import nz.co.eroad.assignment.processing.impl.VehicleDataProcessing;
import nz.co.eroad.assignment.processing.impl.VehicleDataReader;
import nz.co.eroad.assignment.processing.impl.VehicleDataWriter;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Rafael Berne
 * @since 30/08/17.
 */
public class VehicleDataProcessingTest {

    @Test
    public void testProcess() throws IOException {
        VehicleDataReader reader = new VehicleDataReader(getClass().getResource("/input.csv").getFile());
        VehicleDataWriter writer = new VehicleDataWriter("/tmp/" + System.currentTimeMillis() + ".csv");
        VehicleDataProcessing vehicleDataProcessing = new VehicleDataProcessing(reader, writer);

        try {
            vehicleDataProcessing.run();
        } catch (Exception e) {
            Assert.fail();
        }
    }

}
