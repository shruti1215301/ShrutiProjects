package com.tshirtkart.dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tshirtkart.entities.ProductDetails;


@Component
public class CsvFileDataDao {
	
	@Autowired
	ProductDetailsDao productDetailsDao;
	@Autowired
	OutputDao outputDao;
//	@Autowired
//	ProductDetails productDetails;
	public void csvFileReader(String path,String[] data ) {
		List<String> matchedData = new ArrayList<String>();
		long start = System.currentTimeMillis();		
		Timer timer = new Timer();
		
		TimerTask timerTask = new TimerTask() 
		{
		
			@Override
			public void run() 
			{

				File[] files = new File(path)
						.listFiles(obj -> obj.isFile() && obj.getName().endsWith(".csv"));
				String line = "";
				
				for (int j = 0; j < files.length; j++) 
				{
					try (BufferedReader br = new BufferedReader(new FileReader(files[j]))) {
						br.readLine();
						while ((line = br.readLine()) != null) {

							String[] hash = line.split("\\|");
							
							try {
								
							ProductDetails productDetails=new ProductDetails();
							productDetails.setId(hash[0]);
							productDetails.setName(hash[1]);
							productDetails.setColor(hash[2]);
							productDetails.setGenderRecommendation(hash[3]);
							productDetails.setSize(hash[4]);
							productDetails.setPrice(Double.parseDouble(hash[5]));
							productDetails.setRating(Double.parseDouble(hash[6]));
							productDetails.setAvailability(hash[7]);
							
//							
//							
						productDetailsDao.save(productDetails);

							System.out.println("Executed Successfully");
							
							}
							catch (Exception e) {
//	
								continue;
							}

						}

					} catch (FileNotFoundException e) {
						System.out.print("file is not found");
						e.printStackTrace();
					}

					catch (IOException e) {
						System.out.println("Error while reading a file");
					}

				}

			};

		};
		timer.scheduleAtFixedRate(timerTask, new Date(), 5000);
	}

}
