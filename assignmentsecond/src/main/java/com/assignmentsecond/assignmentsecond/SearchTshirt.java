package com.assignmentsecond.assignmentsecond;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SearchTshirt {

	List<Tshirt> tshirtlist = new LinkedList<Tshirt>();
	LinkedList<String> list;
	PreviewData show = new PreviewData();

	// inserting data in database
	public void insertingInDB(List<String> FileName) throws NumberFormatException, IOException, CsvException {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tshirt.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		for (String filename : FileName) {
			FileReader filereader = new FileReader(filename);
			CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).withCSVParser(parser).build();
			List<String[]> allData = csvReader.readAll();

			for (String[] record : allData) {
				Tshirt tshirt = new Tshirt();
				tshirt.setID(record[0]);
				tshirt.setName(record[1]);
				tshirt.setColour(record[2]);
				tshirt.setGender(record[3]);
				tshirt.setSize(record[4]);
				tshirt.setPrice(Float.parseFloat(record[5]));
				tshirt.setRating(Float.parseFloat(record[6]));
				tshirt.setAvailability(record[7]);

				session.save(tshirt);
			}

		}

		session.getTransaction().commit();

	}

	public void sortTshirts(String colour, String size, String gender, String outputPreference) {
		SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml").addAnnotatedClass(Tshirt.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Query query;

		// if outputpreference is price
		if (outputPreference.equals("1")) {
			query = session
					.createQuery("from Tshirt where COLOUR=:colour AND  SIZE=:size AND GENDER=:gender order by PRICE");
		}

		// if outputpreference is rate
		else if (outputPreference.equals("2")) {
			query = session.createQuery(
					"from Tshirt where COLOUR=:colour AND  SIZE=:size AND GENDER=:gender order by RATING DESC");
		}

		// if outputpreference is price and rate both
		else {
			query = session.createQuery(
					"from Tshirt where COLOUR=:colour AND  SIZE=:size AND GENDER=:gender order by PRICE,RATING DESC");
		}

		query.setParameter("colour", colour);
		query.setParameter("size", size);
		query.setParameter("gender", gender);
		List<Tshirt> findTshirts = (List<Tshirt>) query.list();

		for (Tshirt findTshirt : findTshirts) {
			tshirtlist.add(findTshirt);
		}
	}

	// print function
	public void print() {
		PreviewData preview = new PreviewData();
		preview.viewTshirts(tshirtlist);
	}
}
