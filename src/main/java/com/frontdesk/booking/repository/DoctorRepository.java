package com.frontdesk.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.frontdesk.booking.model.DoctorEntity;

@Repository
public interface DoctorRepository
        extends JpaRepository<DoctorEntity, Long> {
	
	@Query("FROM DoctorEntity WHERE specialist = ?1")
    public List<DoctorEntity> findBySpecialist(String pSpecialist);

}
