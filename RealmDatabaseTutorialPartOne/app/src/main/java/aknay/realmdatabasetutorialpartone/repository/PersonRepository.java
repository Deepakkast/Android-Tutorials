package aknay.realmdatabasetutorialpartone.repository;

import android.support.annotation.NonNull;

import aknay.realmdatabasetutorialpartone.model.Person;
import io.realm.Realm;
import io.realm.RealmResults;

public class PersonRepository {
    private PersonRepository() {
        mRealm = Realm.getDefaultInstance();
    }

    private static PersonRepository mPersonRepository = null;
    private Realm mRealm = null;

    //singleton pattern
    public static PersonRepository getInstance() {
        if (mPersonRepository == null) {
            mPersonRepository = new PersonRepository();
        }
        return mPersonRepository;
    }

    public void deleteAll() {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                realm.delete(Person.class);
            }
        });
    }

    public void insert(final Person person) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                realm.copyToRealm(person);
            }
        });
    }

    public RealmResults<Person> getAll() {
        return mRealm.where(Person.class).findAll();
    }

    public Person findByName(String name) {
        return mRealm.where(Person.class).equalTo("name", name).findFirst();
    }

    public void update(final Person person) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                Person personCopy = findByName(person.getName());
                personCopy.setAge(person.getAge());
            }
        });
    }
}