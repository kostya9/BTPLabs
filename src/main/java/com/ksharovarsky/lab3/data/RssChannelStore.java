package com.ksharovarsky.lab3.data;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.feed.RssChannel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by kostya on 5/21/2017.
 */
public class RssChannelStore implements IRssChannelStore {
    private SessionFactory factory;

    @Inject
    public RssChannelStore(SessionFactory factory) {

        this.factory = factory;
    }

    @Override
    public List<RssChannel> getAllRssChannels() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<RssChannel> channels = null;
        try {
            Query query = session.createQuery("from RssChannel");
            channels = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }

        session.close();
        return channels;
    }

    @Override
    public int addRssChannel(RssChannel channel) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = 0;
        try {
            id = (int)session.save(channel);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }

        session.close();
        return id;
    }

    @Override
    public void removeRssChannel(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            RssChannel channel = session.get(RssChannel.class, id);
            session.remove(channel);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }

        session.close();
    }
}
