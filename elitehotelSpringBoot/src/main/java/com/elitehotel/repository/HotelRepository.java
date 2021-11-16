package com.elitehotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitehotel.model.User;

public interface HotelRepository extends JpaRepository<User,String>
{

}
