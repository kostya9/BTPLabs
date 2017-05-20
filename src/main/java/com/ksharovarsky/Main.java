package com.ksharovarsky;

import com.ksharovarsky.lab3.data.FeedMessageStore;
import com.ksharovarsky.lab3.parse.FeedMessage;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        //Application.launch(args);
        SessionFactory factory;
        StandardServiceRegistry registry = null;
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.out.println("Failed to create hibernate session factory " + ex.getMessage());
            if(registry != null)
                StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError();
        }

        FeedMessageStore store = new FeedMessageStore(factory);
        Integer i = store.addFeedMessage(new FeedMessage("123", "lol"));
        System.out.println(String.format("Employee with id %s was created", i.toString()));

        FeedMessage message = store.getFeedMessage(i - 1);
        System.out.println(String.format("Employee with id %s has name %s", i - 1, message.getTitle()));

        store.removeFeedMessage(message.getId());
        System.out.println(String.format("Employee with id %s was removed", i - 1, message.getTitle()));
    }
}