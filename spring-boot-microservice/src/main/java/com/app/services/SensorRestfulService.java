package com.app.services;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.app.entities.Sensor;

@Named
@Path("/")
public class SensorRestfulService {
	
private static List<Sensor> sensorList = new ArrayList<Sensor>();
private final String ALERT_UW = "Under Weight";
private final String ALERT_OW = "Over Weight";
private final int BASE_WEIGHT = 150;
/*@Inject
SensorDAO sensorDao;*/

	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	public void saveData(@QueryParam("timestamp") String timestamp, @QueryParam("value") int value) throws UnknownHostException {
		Sensor s1 = new Sensor();
		s1.setTimestamp(timestamp);
		s1.setWeight(value);
		s1.setAlert(getAlert(s1.getWeight()));
		sensorList.add(s1);
//		sensorDao.save(s1);
//		System.out.println(sensorDao);
		System.out.println("Added sensor data successfully "+s1.getTimestamp() +" --- "+s1.getWeight());
	}
	
	@GET
	@Path("read")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sensor> readData() {
		System.out.println("Data read successfully..!");
		return sensorList;
	}
	
	@GET
	@Path("readByTimeRange")
	@Produces(MediaType.APPLICATION_JSON)
	public Sensor readDataByTime(@QueryParam("timestamp") String timestamp) {
		Sensor sensor = null;
		for(Sensor s :sensorList){
			if(s.getTimestamp().equals(timestamp)){
				sensor = s;
			}
		}
		System.out.println("Data read by timestamp "+timestamp+" is "+sensor);
		return sensor;
	}
	
	public String getAlert(int weight) {
		if(weight > BASE_WEIGHT){
			return ALERT_OW;
		}
		else if(weight < BASE_WEIGHT){
			return ALERT_UW;
		}
		else{
			return "";
		}
	}
}
