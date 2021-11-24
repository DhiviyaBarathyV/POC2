package com.dhiviyaBookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dhiviyaBookStore.model.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails,Integer> 
{

}
