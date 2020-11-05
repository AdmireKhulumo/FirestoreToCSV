import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import java.util.List;
import java.io.File;
import java.io.FileWriter;


public class Main {

    public static void main(String[] args) {
        try{
            //instantiate class that connects to the database
            FirestoreClass firestoreObj = new FirestoreClass();

            //get db variable from firestore class
            final Firestore db = firestoreObj.db;

            //get all data in a collection
            ApiFuture<QuerySnapshot> query = db.collection("users").get();

            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

            //write to file
            File file = new File("Users.csv");
            file.createNewFile();

            FileWriter writer = new FileWriter(file);
            //write headings
            writer.write("FirstName,Surname,Age\n");

            String fname, sname;
            double age;

            for (QueryDocumentSnapshot document : documents) {
                System.out.println("Doc Id: " + document.getId());
                System.out.println(document.getData());

                fname = document.getString("fname");
                sname = document.getString("sname");
                age = document.getDouble("age");

                writer.write(fname + "," + sname + "," + age + "\n");

            }

            //close writer
            writer.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
