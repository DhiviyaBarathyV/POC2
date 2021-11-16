package com.elitehotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitehotel.model.BookRoom;

public interface BookingRepository extends JpaRepository<BookRoom,Integer>
{

}
