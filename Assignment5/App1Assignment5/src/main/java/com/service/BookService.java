package com.service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import com.entity.Book;

@Component
public class BookService {

	public List<Book> retrieveBooks() {

		// inline will store the JSON data streamed in string format
		String inLine = "";

		
		try {
			URL url = new URL("http://localhost:8052/book");
			// Parse URL into HttpURLConnection in order to open the connection in order to
			// get the JSON data
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// Set the request to GET or POST as per the requirements
			conn.setRequestMethod("GET");
			// Use the connect method to create the connection bridge
			conn.connect();
			// Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " + responsecode);

			// Iterating condition to if response code is not 200 then throw a runtime
			// exception
			// else continue the actual process of getting the JSON data
			if (responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			else {
				// Scanner functionality will read the JSON data from the stream
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inLine += sc.nextLine();
				}
				System.out.println("\nJSON Response in String format");
				System.out.println(inLine);
				// Close the stream when reading the data has been finished
				sc.close();
			}

			// JSONParser reads the data from string object and break each data into key
			// value pairs
			JSONParser parse = new JSONParser();
			// Type caste the parsed json data in json object
			JSONArray jsonarr = (JSONArray) parse.parse(inLine);

			// Get data for Results array
			List<Book> allBook = new LinkedList<Book>();
			for (int i = 0; i < jsonarr.size(); i++) {
				// Store the JSON objects in an array
				// Get the index of the JSON object and print the values as per the index
				JSONObject jsonobj = (JSONObject) jsonarr.get(i);

				Long code = (Long) jsonobj.get("bookCode");
				String bookname = (String) jsonobj.get("bookName");
				String author = (String) jsonobj.get("author");
				String addedon = (String) jsonobj.get("addedOn");

				Book book = new Book();
				int bookcode = code.intValue();
				book.setAddedOn(addedon);
				book.setAuthor(author);
				book.setBookCode(bookcode);
				book.setBookName(bookname);

				allBook.add(book);

			}

			return allBook;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void deleteBook(int bookcode) {

		String inline = "";

		try {
			URL url = new URL("http://localhost:8052/App2Assignment5/book/" +bookcode);
			// Parse URL into HttpURLConnection in order to open the connection in order to
			// get the JSON data
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// Set the request to GET or POST as per the requirements
			conn.setRequestMethod("DELETE");
			// Use the connect method to create the connection bridge
			conn.connect();
			// Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " + responsecode);

			// Iterating condition to if response code is not 200 then throw a runtime
			// exception
			// else continue the actual process of getting the JSON data
			if (responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			
		}

		catch (Exception e) {
			e.printStackTrace();

		}
		
	}
	public void saveBook(Book book,String method) {

		String query_url = "http://localhost:8052/App2Assignment5/book";
		String json = "{\"bookCode\":"+book.getBookCode()+",\"bookName\":\""+book.getBookName()+"\",\"author\":\""+book.getAuthor()+"\",\"addedOn\":\""+book.getAddedOn()+"\"}";
		try {
		URL url = new URL(query_url);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod(method);
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		byte[] out = json.getBytes(StandardCharsets.UTF_8);



		OutputStream stream = http.getOutputStream();
		stream.write(out);



		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();
		System.out.println("Created JASON:"+json);
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}


		}
}
