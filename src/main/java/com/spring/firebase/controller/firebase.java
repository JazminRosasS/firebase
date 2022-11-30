package com.spring.firebase.controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Service
public class firebase {

// se realiza la inicializacion de nuestra bd aqui va la coneccion
    @PostConstruct
    private void iniFirestore() throws IOException {
//nombre del documento .json  en el cual esta la coneccion
        InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("private-key-firestore.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                //va el nombre de mi bd tal y como aparecen
                .setDatabaseUrl("http://fir-spring-firebase-bfee2.firebaseio.com")
                .build();

        if(FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp(options);

        }
    }
    public Firestore getFirestore(){
        return FirestoreClient.getFirestore();

    }
}