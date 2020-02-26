package com.sharad.checkin.integration;

import com.sharad.checkin.dto.Reservation;
import com.sharad.checkin.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	public Reservation updateReservation(ReservationUpdateRequest request);
}
