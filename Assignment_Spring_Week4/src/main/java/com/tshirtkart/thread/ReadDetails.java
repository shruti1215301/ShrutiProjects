package com.tshirtkart.thread;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tshirtkart.dao.CsvFileDataDao;
import com.tshirtkart.dao.OutputDao;
@Component
public class ReadDetails implements Runnable {
	private String [] data;
	
	public ReadDetails(String[] data) {
		super();
		this.data = data;
	}

@Autowired
CsvFileDataDao csvFileDataDao;

	public void run() {
		try {
			String path = "C:\\Users\\shrutijain03\\eclipse-workspace\\Assignment_Spring_Week4\\src\\main\\resources";
			csvFileDataDao.csvFileReader(path, data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public ReadDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String[] getData() {
		return data;
	}


	public void setData(String[] data) {
		this.data = data;
	}



	

}
