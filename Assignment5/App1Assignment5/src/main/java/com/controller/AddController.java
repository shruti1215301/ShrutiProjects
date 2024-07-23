package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

import java.time.Month;

import com.entity.Author;
import com.entity.Book;
import com.service.AuthorService;
import com.service.BookService;

@Controller
public class AddController {

	@Autowired
	Book book;
	@Autowired
	AuthorService authors;
	@Autowired
	BookService bookService;

	@PostMapping("/Add") // for post method mapping
	public ModelAndView editBook(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		String date = java.time.LocalDate.now().toString();
		LocalDate currentDate = LocalDate.parse(date);

		// Get day from date
		int day = currentDate.getDayOfMonth();

		// Get month from date
		Month month = currentDate.getMonth();

		// Get year from date
		int year = currentDate.getYear();

		String Date = day + " " + month + " " + year;
		List<Author> Author = authors.retrieveAuthors();

		mv.addObject("Author", Author);
		mv.addObject("date", Date);
		mv.setViewName("AddBook");

		return mv;
	}

	@PostMapping("/Addbook") // for post method mapping
	public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();

        book.setAddedOn(request.getParameter("addedOn"));
        book.setAuthor(request.getParameter("author"));
        book.setBookCode(Integer.parseInt(request.getParameter("bookCode")));
        book.setBookName(request.getParameter("bookName"));

        bookService.saveBook(book, "POST");
        HttpSession session = request.getSession();
        List<Book> books = bookService.retrieveBooks();
        session.setAttribute("books", books);
        modelAndView.setViewName("bookListing");

        return modelAndView;
	}
}
