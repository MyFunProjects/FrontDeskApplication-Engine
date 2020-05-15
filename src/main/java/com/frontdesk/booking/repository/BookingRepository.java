package com.frontdesk.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frontdesk.booking.model.BookingEntity;

@Repository
public interface BookingRepository
        extends JpaRepository<BookingEntity, Long> {

}