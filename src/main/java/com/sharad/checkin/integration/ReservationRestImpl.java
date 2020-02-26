package com.sharad.checkin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sharad.checkin.dto.Reservation;
import com.sharad.checkin.dto.ReservationUpdateRequest;

@Component
public class ReservationRestImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "http://localhost:9090/FlightReservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {

		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate
				.getForObject(RESERVATION_REST_URL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {

		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
		return null;
	}

}
