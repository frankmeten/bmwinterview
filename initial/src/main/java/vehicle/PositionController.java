package vehicle;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.Greeting;

@RestController
public class PositionController {

	@RequestMapping(value = "/position", consumes = "application/json", method = RequestMethod.POST)
	public String position(@RequestBody Position pos) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();
		// Using DateFormat format method we can create a string
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		String fileName = "data" + reportDate + ".txt";
		FileWriter fw;
		try {
			fw = new FileWriter(fileName);

			fw.write("timestamp:" + pos.getTimestamp() + "         ");
			fw.write("sessionid:" + pos.getSessionid() + "         ");
			fw.write("vehicleid:" + pos.getVehicleid() + "         ");
			fw.write("latitude:" + pos.getLatitude() + "         ");
			fw.write("longitude:" + pos.getLongitude() + "         ");
			fw.write("heading:" + pos.getHeading() + System.getProperty("line.separator"));

			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// save new Position(timestamp, sessionid, vehicleid, latitude,
		// longitude, heading);
		return "success";
	}

	@RequestMapping("/position")
	public Position getSessionsByvehicleId(
			@RequestParam(value = "nvehicleidame", defaultValue = "IRVQ5IQLEQKY7LR") String vehicleid) {

		long timestamp = 1519990625885L;
		// String vehicleid = "IRVQ5IQLEQKY7LR";
		String sessionid = "d081204be8e7f89efe9267057c6ec0d8";
		double latitude = 48.1781;
		double longitude = 28.781;
		int heading = 342;
		return new Position(timestamp, vehicleid, sessionid, latitude, longitude, heading);
	}

}
