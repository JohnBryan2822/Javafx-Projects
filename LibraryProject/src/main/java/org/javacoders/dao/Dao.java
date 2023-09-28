package org.javacoders.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javacoders.LibraryProject.Book;
import org.javacoders.entity.Member;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Dao {
	
	SessionFactory factory;
	
	public Dao(Book book) {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Book.class)
				.buildSessionFactory();
	}
	public Dao(Member member) {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Member.class)
				.buildSessionFactory();
	}
	
	
	Session session;

	public boolean addBook(Book book) {
		session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(book);
			session.getTransaction().commit();
		} catch (Exception e) {
			return false;
			// Rise an error message
			// Failed
		}
		return true;
	}

	public ObservableList<Book> getAllBooks() {
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			return FXCollections.observableList(session.createQuery("FROM Book").getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FXCollections.observableArrayList();
	}	
	
	public boolean addMember(Member member) {
		session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(member);
			session.getTransaction().commit();
		} catch (Exception e) {
			return false;
			// Rise an error message
			// Failed
		}
		return true;
	}
	public ObservableList<Member> getAllMembers() {
		session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			return FXCollections.observableList(session.createQuery("FROM Member").getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FXCollections.observableArrayList();
	}
}
