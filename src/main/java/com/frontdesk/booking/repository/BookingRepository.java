package com.frontdesk.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.frontdesk.booking.model.BookingEntity;

@Repository
public interface BookingRepository
        extends JpaRepository<BookingEntity, Long> {
	
	@Modifying
	@Query("update BookingEntity b set b.status = ?1 where b.id = ?2")
	int setNewStatus(String status, Long id);
}
