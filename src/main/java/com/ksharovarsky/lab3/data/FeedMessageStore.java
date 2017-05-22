package com.ksharovarsky.lab3.data;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.feed.FeedMessage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
            FeedMessage message = (FeedMessage) session.get(FeedMessage.class, id);
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
}
