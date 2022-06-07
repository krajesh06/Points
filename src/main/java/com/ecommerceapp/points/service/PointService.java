package com.ecommerceapp.points.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerceapp.points.dao.PointsRepository;
import com.ecommerceapp.points.model.points;
import com.ecommerceapp.points.validator.pointsValidattor;

@Component
public class PointService {

	@Autowired

	PointsRepository pointsRepository;

	public String findByMobileNo(long mobile, int amount) {
		try {
			pointsValidattor.validate(mobile);
			points point = pointsRepository.findByMobileNo(mobile);
			int walletPoints = 0;
			int totalpoints = point.getWalletPoints();
			if (amount > 1000) {

				walletPoints = 500 + totalpoints;

			}else
			{
				walletPoints = 0 +	totalpoints;	
			}
		
			pointsRepository.changeWalletPoints(walletPoints, mobile);
			
			System.out.println("Reward point");
			System.out.println(walletPoints);


		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}
	
	public int updateWalletAddPoints(long mobile,int points)
	{
		int existingPoints=pointsRepository.getWalletPoints(mobile);
		int updatedPoints=existingPoints+points;
		pointsRepository.changeWalletPoints(updatedPoints, mobile);
		return 1;
	}
	 public int updateWalletSubtractPoints(long mobile,int points)
	 {
		 int existingPoints=pointsRepository.getWalletPoints(mobile);
			int updatedPoints=existingPoints-points;
			pointsRepository.changeWalletPoints(updatedPoints, mobile);
			return 1;
	 }
	 

	}
