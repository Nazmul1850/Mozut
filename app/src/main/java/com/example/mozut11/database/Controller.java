package com.example.mozut11.database;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
public class Controller {
    private static FirebaseAuth firebaseAuth;
    private static FirebaseFirestore myDatabase;
    private static CollectionReference collectionReference;
    public interface CreateAccountInterface
    {
        public void setAccount(String message);
    }
    public static void createAccount(User user, String password,CreateAccountInterface createAccountInterface)
    {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(user.getEmail(),password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseUser firebaseUser = authResult.getUser();
                        user.setId(firebaseUser.getUid());
                        saveUser(user,createAccountInterface);
                        // save customer

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        createAccountInterface.setAccount(e.getMessage());
                    }
                });
    }
    private static void saveUser(User user,CreateAccountInterface createAccountInterface)
    {
        myDatabase =  FirebaseFirestore.getInstance();
        myDatabase.collection("Users")
                .document(user.getId())
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        createAccountInterface.setAccount("Done");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        createAccountInterface.setAccount(e.getMessage());
                    }
                });
    }
}
