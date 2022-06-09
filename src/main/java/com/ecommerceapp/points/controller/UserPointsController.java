package com.ecommerceapp.points.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceapp.points.dao.PointsRepository;
import com.ecommerceapp.points.dto.MessageDTO;
import com.ecommerceapp.points.model.points;
import com.ecommerceapp.points.service.PointService;

@RestController
public class UserPointsController {

	@Autowired
	PointsRepository pointsRepository;

	@Autowired
	PointService pointservice;

//	@GetMapping("user/points")
//	public ResponseEntity<?> findByMobile_no(@RequestParam("mobile") long mobile, @RequestParam("amount") int amount) {
//		int n = 0;
//		try {
//			System.out.println(mobile);
//
//			@SuppressWarnings("unused")
//			String message = pointservice.findByMobileNo(mobile, amount);
//			List<points> count = null;
//			//count = pointsRepository.findByMobileNoAndfindBypointsPin(mobile);
//			for (points l : count) {
//				n = l.getWalletPoints();
//
//			}
//			@SuppressWarnings("unused")
//			MessageDTO message1 = new MessageDTO("success");
//			return new ResponseEntity<>(n, HttpStatus.OK);
//
//		} catch (Exception e) {
//			MessageDTO message = new MessageDTO(e.getMessage());
//			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
//		}
//	}

	@GetMapping("user/validate/points")
	public ResponseEntity<?> updateWalletPoints(@RequestParam("mobile") long mobileNo,@RequestParam("amount") int amount) {
		//System.out.println("hi");
		System.out.println(mobileNo+" "+amount);
		
			//System.out.println("hi");
		
			int exsistingPoints = pointsRepository.getWalletPoints(mobileNo);
			System.out.println(exsistingPoints);
			if (amount > 1000) {
				int points = amount / 10;
				int currentPoints= amount/10;
				points = points + exsistingPoints;
				System.out.println(points);
				int updated = pointsRepository.changeWalletPoints(points, mobileNo);
				MessageDTO message = new MessageDTO("success");
				message.setPoints(currentPoints);
				//message.setPoints(points);	
				return new ResponseEntity<>(message, HttpStatus.OK);

			} else {
				MessageDTO message1 = new MessageDTO("success");
				message1.setPoints(0);
				return new ResponseEntity<>(message1, HttpStatus.OK);

			}
			
			
	}	
			@GetMapping("user/exsisting/points")
			public ResponseEntity<?> showWalletPoints(@RequestParam("mobile") long mobileNo,@RequestParam("amount") int amount) {
				//System.out.println("hi");
				System.out.println(mobileNo+" "+amount);
				
					//System.out.println("hi");
				
					int exsistingPoints = pointsRepository.getWalletPoints(mobileNo);
					System.out.println(exsistingPoints);
					if (amount > 1000) {
						int points = amount / 10;
						points = points + exsistingPoints;
						System.out.println(points);
						int updated = pointsRepository.changeWalletPoints(points, mobileNo);
						MessageDTO message = new MessageDTO("success");
						message.setPoints(points);
						//message.setPoints(points);	
						return new ResponseEntity<>(message, HttpStatus.OK);

					} else {
						MessageDTO message1 = new MessageDTO("success");
						message1.setPoints(0);
						return new ResponseEntity<>(message1, HttpStatus.OK);

					}

	}

}
