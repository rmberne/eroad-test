package nz.co.eroad.assignment.processing.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import nz.co.eroad.assignment.model.VehicleData;
import nz.co.eroad.assignment.processing.ItemProcessing;
import nz.co.eroad.assignment.processing.ItemReader;
import nz.co.eroad.assignment.processing.ItemWriter;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Rafael Berne
 * @since 30/08/17.
 */
public class VehicleDataProcessing extends ItemProcessing<VehicleData, VehicleData> {

    public static final String API_URL = "https://maps.googleapis.com/maps/api/timezone/json?location=38.908133," +
                                         "-77.047119&timestamp=1458000000&key=AIzaSyCjTQFK278Ar1rlmO_QTtrpvQnn7CGMq_E";

    public VehicleDataProcessing(ItemReader<VehicleData> reader, ItemWriter<VehicleData> writer) {
        super(reader, writer);
    }

    @Override
    protected VehicleData process(VehicleData item) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(API_URL);

        try {
            HttpResponse response = client.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                Gson gson = new GsonBuilder().create();

                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                MapsResult result = gson.fromJson(rd, MapsResult.class);

                if (result != null) {
                    item.setTimezone(result.getTimeZoneId());
                    DateTime dt = item.getDateTime();
                    item.setLocalizedDateTime(dt.toDateTime(DateTimeZone.forID(result.getTimeZoneId())));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    class MapsResult {
        private Long dstOffset;
        private Long rawOffset;
        private String status;
        private String timeZoneId;
        private String timeZoneName;

        public Long getDstOffset() {
            return dstOffset;
        }

        public void setDstOffset(Long dstOffset) {
            this.dstOffset = dstOffset;
        }

        public Long getRawOffset() {
            return rawOffset;
        }

        public void setRawOffset(Long rawOffset) {
            this.rawOffset = rawOffset;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTimeZoneId() {
            return timeZoneId;
        }

        public void setTimeZoneId(String timeZoneId) {
            this.timeZoneId = timeZoneId;
        }

        public String getTimeZoneName() {
            return timeZoneName;
        }

        public void setTimeZoneName(String timeZoneName) {
            this.timeZoneName = timeZoneName;
        }
    }
}
