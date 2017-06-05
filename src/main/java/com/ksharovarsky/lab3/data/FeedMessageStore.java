package com.ksharovarsky.lab3.data;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.feed.FeedMessage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * Created by kostya on 5/20/2017.
 */
public class FeedMessageStore implements IFeedMessageStore{
    private SessionFactory factory;


    @Inject
    public FeedMessageStore(SessionFactory factory) {
        this.factory = factory;
    }

    public void addFeedMessage(FeedMessage message) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(message);
            transaction.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeFeedMessage(String id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            FeedMessage message = session.get(FeedMessage.class, id);
            session.remove(message);
            transaction.commit();
        }
        catch(HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }

        session.close();
    }

    @Override
    public FeedMessage getFeedMessage(String id) {
        Session session = factory.openSession();
        FeedMessage message = null;
        Transaction transaction = session.beginTransaction();
        try{
            message = session.get(FeedMessage.class, id);
            transaction.commit();
        }
        catch(HibernateException e) {
            e.printStackTrace();
        }

        session.close();
        return message;
    }

    @Override
    public List<FeedMessage> getAllFeedMessages() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<FeedMessage> messages = null;
        try {
            Query query = session.createQuery("from FeedMessage");
            messages = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }

        session.close();
        return messages;
    }

    @Override
    public boolean exists(String id) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);
            Root<FeedMessage> root = query.from(FeedMessage.class);
            query.select(builder.count(root));
            query.where(builder.equal(root.get("id"), id));
            EntityManager manager = session.getEntityManagerFactory().createEntityManager();
            Long result = manager.createQuery(query).getSingleResult();
            transaction.commit();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int removeOlderThan(Date date) {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<FeedMessage> query = builder.createCriteriaDelete(FeedMessage.class);
            Root<FeedMessage> root = query.from(FeedMessage.class);
            query.where(builder.lessThan(root.get("pubDate"), date));
            EntityManager manager = session.getEntityManagerFactory().createEntityManager();
            manager.getTransaction().begin();
            int result = manager.createQuery(query).executeUpdate();
            manager.getTransaction().commit();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
