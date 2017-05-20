package com.ksharovarsky.lab3.data;

import com.ksharovarsky.lab3.parse.FeedMessage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by kostya on 5/20/2017.
 */
public class FeedMessageStore implements IFeedMessageStore{
    private SessionFactory factory;

    public FeedMessageStore(SessionFactory factory) {

        this.factory = factory;
    }

    public int addFeedMessage(FeedMessage message) {
        Session session = factory.openSession();
        int messageId = 0;

        try {
            messageId = (int) session.save(message);
        }
        catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return messageId;
    }

    @Override
    public void removeFeedMessage(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            FeedMessage message = (FeedMessage) session.get(FeedMessage.class, id);
            session.delete(message);
            transaction.commit();
        }
        catch(HibernateException e) {
            e.printStackTrace();
        }

        session.close();
    }

    @Override
    public FeedMessage getFeedMessage(int id) {
        Session session = factory.openSession();
        FeedMessage message = null;

        try{
            message = session.get(FeedMessage.class, id);
        }
        catch(HibernateException e) {
            e.printStackTrace();
        }

        session.close();
        return message;
    }
}
