package org.example.th04091.res;

import org.example.th04091.model.Books;
import org.example.th04091.util.HibernateUtil;
import org.hibernate.Session;

import org.hibernate.query.Query;
import java.util.List;

public class BookRes {
    public List<Books> getAll(){
        Session session = HibernateUtil.getSession();
        Query<Books> query = session.createQuery("FROM Books", Books.class);
        List<Books> books = query.getResultList();
        return books;
    }

    public List<Books> getAllCategory(){
        Session session = HibernateUtil.getSession();
        Query<Books> query = session.createQuery("FROM Books b WHERE b.category = :cat", Books.class);
        query.setParameter("cat", "Tiểu thuyết");
        return query.getResultList();
    }

    public List<Books> getAllOutOfStock(){
        Session session = HibernateUtil.getSession();
        Query<Books> query = session.createQuery("FROM Books b WHERE b.quantityInStock  < 20", Books.class);
        List<Books> books = query.getResultList();
        return books;
    }

    public List<Books> getAllComingDue(){
        Session session = HibernateUtil.getSession();
        Query<Books> query = session.createQuery("FROM Books b ORDER BY returnDueDate ASC", Books.class);
        List<Books> books = query.getResultList();
        return books;
    }

    public List<Books> searchByKeyword(String keyword) {
        Session session = HibernateUtil.getSession();
        String hql = "FROM Books b WHERE b.title LIKE :kw OR b.summary LIKE :kw";
        Query<Books> query = session.createQuery(hql, Books.class);
        query.setParameter("kw", "%" + keyword + "%");
        return query.getResultList();
    }
}
