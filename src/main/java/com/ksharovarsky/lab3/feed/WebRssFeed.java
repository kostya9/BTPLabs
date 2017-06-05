package com.ksharovarsky.lab3.feed;

import com.ksharovarsky.lab3.model.RSS;

import javax.net.ssl.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.URL;
import java.security.cert.X509Certificate;

/**
 * Created by kostya on 5/22/2017.
 */
public class WebRssFeed {
    private String address;

    static {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        } };
        // Install the all-trusting trust manager
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebRssFeed(String address) {
        this.address = address;
    }

    public boolean IsValid() {
        try {
            RSS rss = Acquire();
            if(rss.channel!= null &&
                    rss.channel.items!= null &&
                    rss.channel.items.size() > 0)
                return true;
        }
        catch (Exception e) {
            return false;
        }

        return false;
    }

    public RSS Acquire() throws Exception{
        URL url = new URL(address);
        JAXBContext context = JAXBContext.newInstance(RSS.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (RSS) unmarshaller.unmarshal(url.openStream());
    }
}
