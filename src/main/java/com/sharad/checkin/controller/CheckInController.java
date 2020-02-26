package com.sharad.checkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sharad.checkin.dto.Reservation;
import com.sharad.checkin.dto.ReservationUpdateRequest;
import com.sharad.checkin.integration.ReservationRestClient;

@Controller
public class CheckInController {

	@Autowired
	private ReservationRestClient restClient;
	@RequestMapping("/showStartCheckin")
	public String showStartCheckIn() {
		
		return "startCheckIn";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckin(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation",reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,@RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		restClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";
		
	}
}
