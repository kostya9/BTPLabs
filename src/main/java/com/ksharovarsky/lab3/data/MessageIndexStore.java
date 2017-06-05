package com.ksharovarsky.lab3.data;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.feed.FeedMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

/**
 * Created by kostya on 6/5/2017.
 */
public class MessageIndexStore implements IMessageIndexStore{

    private SessionFactory factory;

    @Inject
    public MessageIndexStore(SessionFactory factory) {

        this.factory = factory;
    }

    @Override
    public void updateIndex(FeedMessage message, Map<String, Long> frequencies) {
        try(Session session = factory.openSession()) {
            EntityManager manager = session.getEntityManagerFactory().createEntityManager();
            for(String word : frequencies.keySet()) {
                manager.getTransaction().begin();
                try {
                    CriteriaBuilder builder = manager.getCriteriaBuilder();
                    CriteriaQuery<Long> query = builder.createQuery(Long.class);
                    Root<RssIndexEntry> root = query.from(RssIndexEntry.class);
                    query.select(builder.count(root));
                    query.where(builder.and(
                            builder.equal(root.get("word"), word),
                            builder.equal(root.get("FeedMessage"), message)));
                    Long result = (Long)manager.createQuery(query).getSingleResult();
                    if (result == 0) {
                        manager.persist(new RssIndexEntry(word, (int)(long) frequencies.get(word), message));
                    }
                    manager.getTransaction().commit();
                }
                catch (Exception e) {
                    manager.getTransaction().rollback();
                }
            }
        }
    }

    @Override
    public List<String> getIndexForWord(String word) {
        try(Session session = factory.openSession()) {
            EntityManager manager = session.getEntityManagerFactory().createEntityManager();
            manager.getTransaction().begin();
            try {
                CriteriaBuilder builder = manager.getCriteriaBuilder();
                CriteriaQuery<String> query = builder.createQuery(String.class);
                Root<RssIndexEntry> root = query.from(RssIndexEntry.class);
                query.orderBy(builder.desc(root.get("frequency")))
                    .select(root.get("FeedMessage").get("id"))
                    .where(builder.equal(root.get("word"), word));
                List<String> ids = manager.createQuery(query)
                                        .setMaxResults(10)
                                        .getResultList();
                manager.getTransaction().commit();
                return ids;
            }
            catch (Exception e) {
                manager.getTransaction().rollback();
                return null;
            }
        }
    }
}
