package com.elitehotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitehotel.model.AvailableRooms;
public interface AvailableRoomRepository extends JpaRepository<AvailableRooms,Integer>
{

}
