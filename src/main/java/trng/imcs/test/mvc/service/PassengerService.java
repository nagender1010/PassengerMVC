package trng.imcs.test.mvc.service;

import java.util.List;

import trng.imcs.test.mvc.model.Passenger;

public interface PassengerService {

	public Passenger addPassenger(Passenger p);

	public Passenger updatePassenger(Passenger p);

	public void deletePassenger(int profileId);

	public Passenger getPassenger(int profileId);

	// public List<Employee> getAllEmployeesByDeptId(int deptId);

}
