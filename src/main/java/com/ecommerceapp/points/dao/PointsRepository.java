package com.ecommerceapp.points.dao;


import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerceapp.points.model.points;



@Repository
public interface PointsRepository extends JpaRepository<points, Integer> {

	points findByMobileNo(long mobileno);

	//static Optional<points>findByMobileNo(long mobileno);
	
	@Transactional
	@Modifying
	@Query("update com.ecommerceapp.points.model.points u set u.walletPoints=:walletPoints where u.mobileNo=:mobileNo")
	int changeWalletPoints(@Param("walletPoints") int walletPoints,@Param("mobileNo") long mobileNo);
	
	
	@Query("select u from com.ecommerceapp.points.model.walletpoints u  where u.mobileNo=:mobile")
	List<points> findByMobileNoAndfindBypointsPin(@Param("mobile") long mobile)throws SQLException;
	
	void save(long mobile); 
	
	@Query("select u.walletPoints from com.ecommerceapp.points.model.points u where u.mobileNo=:mobile")
	int getWalletPoints(@Param("mobile") long mobile);


	//int findByMobileNoAndfindBypointsPin(long mobile, int pin);
}
