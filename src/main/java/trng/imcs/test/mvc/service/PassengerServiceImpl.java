package trng.imcs.test.mvc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import trng.imcs.test.mvc.model.Passenger;

@Service("passengerService")
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private RestTemplate restTemplate;


	private static String URL = "http://localhost:8081/passenger";

	/*@SuppressWarnings("unchecked")
	@Cacheable(value="employees", key ="#deptId")
	public List<Employee> getAllEmployeesByDeptId(int deptId) {
		return (List<Employee>) restTemplate.getForObject(URL + "/dept/" + deptId, List.class);
	}*/
	public Passenger addPassenger(Passenger p) {
		Passenger res = restTemplate.postForObject(URL + "/", p, Passenger.class);
		//System.out.println("printing body in service lyaer "+res.getBody());
		return res;

	}
	public Passenger updatePassenger(Passenger p) {
		HttpEntity<Passenger> request = new HttpEntity<>(p);
		ResponseEntity<Passenger> res = restTemplate.exchange(URL, HttpMethod.PUT, request, Passenger.class);
		return res.getBody();
	}
	public void deletePassenger(int profileId) {
		String entityUrl = URL + "/" + profileId;
		restTemplate.delete(entityUrl);

	}
	public Passenger getPassenger(int empId) {
		String entityUrl = URL + "/" + empId;
		ResponseEntity<Passenger> response = restTemplate.getForEntity(entityUrl, Passenger.class);
		if (response.getStatusCodeValue() == 200) {
			return null;
		}
		return response.getBody();
	}

}
