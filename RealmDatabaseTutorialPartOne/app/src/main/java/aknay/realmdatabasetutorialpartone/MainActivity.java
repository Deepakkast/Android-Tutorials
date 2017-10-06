package aknay.realmdatabasetutorialpartone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import aknay.realmdatabasetutorialpartone.model.Person;
import aknay.realmdatabasetutorialpartone.repository.PersonRepository;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PersonRepository personRepository = PersonRepository.getInstance();

        //new person called 'Joe'
        Person joe = new Person();
        joe.setId(1); //unique ID
        joe.setAge(18);
        joe.setName("Joe");
        personRepository.insert(joe); //insert to repository

        //new person called 'Bob'
        Person bob = new Person();
        bob.setId(2);
        bob.setAge(21);
        bob.setName("Bob");
        personRepository.insert(bob);

        //list all people
        RealmResults<Person> results = personRepository.getAll();
        for (Person p : results) {
            Log.d(TAG, "Person List -> " + "name: " + p.getName() + ", " + "Age: " + p.getAge());
        }

        //retrieve 'Joe'
        Person retrievedJoe = personRepository.findByName("Joe");
        Log.d(TAG, "Young Joe -> " + "name: " + retrievedJoe.getName() + ", " + "Age: " + retrievedJoe.getAge());

        //update 'Joe' age
        joe.setAge(60);
        personRepository.update(joe);

        //observe the change
        Person oldJoe = personRepository.findByName("Joe");
        Log.d(TAG, "Old Joe -> " + "name: " + oldJoe.getName() + ", " + "Age: " + oldJoe.getAge());

        //delete all entries
        personRepository.deleteAll();
    }
}