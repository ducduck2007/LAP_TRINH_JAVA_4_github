package org.example.democud.res;

import org.example.democud.model.Attendance;
import org.example.democud.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AttendanceRes {
    public List<Attendance> getAll() {
        Session session = HibernateUtil.getSession();
        Query<Attendance> query = session.createQuery("FROM Attendance", Attendance.class);
        List<Attendance> attendances = query.getResultList();
        session.close();
        return attendances;
    }

    public boolean deleteByID(Integer id) {
        boolean isSuccess = false;
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Query<Attendance> query = session.createQuery("FROM Attendance WHERE attendanceID = :id", Attendance.class);
        query.setParameter("id", id);

        Attendance attendance = query.getSingleResultOrNull();

        if (attendance != null) {
            session.remove(attendance);
            isSuccess = true;
        }

        transaction.commit();
        session.close();

        return isSuccess;
    }

    public Attendance findById(Integer id) {
        Session session = HibernateUtil.getSession();
        Attendance att = session.find(Attendance.class, id);
        session.close();
        return att;
    }

    public void update(Attendance att) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.merge(att);
        tx.commit();
        session.close();
    }
}
