package com.justintime.dao;

import java.util.List;

import com.justintime.model.BookingDetails;

/**
 * @author Sagnik
 *
 */
public interface BookingHistoryDao {
	List bookingHistory(String email,String pass);

}
