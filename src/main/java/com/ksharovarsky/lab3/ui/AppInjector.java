package com.ksharovarsky.lab3.ui;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.ksharovarsky.lab3.data.*;
import com.ksharovarsky.lab3.feed.LocalRssFeed;
import com.ksharovarsky.lab3.feed.MultipleRssFeedFetch;
import com.ksharovarsky.lab3.feed.text.Index;
import com.ksharovarsky.lab3.feed.text.StopWordFilter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Created by kostya on 5/21/2017.
 */
public class AppInjector extends AbstractModule {

    private SessionFactory factory;
    private StopWordFilter filter;
    public AppInjector() {
        StandardServiceRegistry registry = null;
        try {
            filter = new StopWordFilter(Files.readAllLines(FileSystems.getDefault().getPath("stop-words.txt")));
        } catch (IOException e) {
            filter = new StopWordFilter(new ArrayList<String>());
            System.err.println("Could not load the stop words list");
        }
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
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
    SessionFactory provideSessionFactory() {
        return factory;
    }

    @Provides
    @Singleton
    StopWordFilter providesStopWords() {
        return filter;
    }

    @Override
    protected void configure() {
        bind(LocalRssFeed.class).asEagerSingleton();
        bind(IRssChannelStore.class).to(RssChannelStore.class);
        bind(IFeedMessageStore.class).to(FeedMessageStore.class);
        bind(MultipleRssFeedFetch.class);
        bind(IMessageIndexStore.class).to(MessageIndexStore.class);
        bind(Index.class);
    }
}
