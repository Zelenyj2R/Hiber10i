package Servise;

import entity.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;


public class PlanetCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void create(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(planet);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public Optional<Planet> get(String id) {
        try (Session session = sessionFactory.openSession()) {
            Planet planet = session.get(Planet.class, id);
            return Optional.ofNullable(planet);
        }
    }

    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(planet);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public void delete(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Query query = session.createQuery("SELECT t FROM Ticket t " +
                        "WHERE t.from_planet_id = :from OR t.to_planet_id = :to");
                query.setParameter("from", planet.getId());
                query.setParameter("to", planet.getId());
                query.list().forEach(session::remove);
                session.remove(planet);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public List<Planet> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }
}