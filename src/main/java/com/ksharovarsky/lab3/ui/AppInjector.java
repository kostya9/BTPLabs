package com.ksharovarsky.lab3.ui;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.ksharovarsky.lab3.data.IRssChannelStore;
import com.ksharovarsky.lab3.data.RssChannelStore;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by kostya on 5/21/2017.
 */
public class AppInjector extends AbstractModule {

    private SessionFactory factory;
    public AppInjector() {
        StandardServiceRegistry registry = null;
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            registry = new StandardServiceRegistryBuilder().configure("data/hibernate.cfg.xml").build();
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.out.println("Failed to create hibernate session factory " + ex.getMessage());
            if(registry != null)
                StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError();
        }
    }

    @Provides
    @Singleton
    SessionFactory provideMyConfiguration() {
        return factory;
    }
    @Override
    protected void configure() {
        bind(IRssChannelStore.class).to(RssChannelStore.class);
    }
}
