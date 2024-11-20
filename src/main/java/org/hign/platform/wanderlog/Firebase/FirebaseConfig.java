package org.hign.platform.wanderlog.Firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initializeFirebase() throws IOException {
        InputStream serviceAccount =
                getClass().getClassLoader().getResourceAsStream("Firebase/key/wanderlog-19add-28e940ac1f6d.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setProjectId("wanderlog-19add")
                .build();

        FirebaseApp.initializeApp(options);

    }
}