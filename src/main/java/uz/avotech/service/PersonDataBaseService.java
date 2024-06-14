package uz.avotech.service;

import jakarta.persistence.LockModeType;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import uz.avotech.domain.PersonEntity;
import uz.avotech.domain.PhoneEntity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonDataBaseService {

    private final SessionFactory sessionFactory;

    public void save(String test) {

        var person1 = new PersonEntity();
        person1.setName("test");
        person1.setPassword("testP");

        var person2 = new PersonEntity();
        person2.setName("test");
        person2.setPassword("testP");

        var phone1 = new PhoneEntity();
        phone1.setNumber("12345");

        var phone2 = new PhoneEntity();
        phone2.setNumber("23456");

        person1.addPhone(phone1);
        person1.addPhone(phone2);

        person2.addPhone(phone2);


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(person1);
        session.save(person2);

        if (test != null && test.equals("error")) {
            throw new RuntimeException();
        }

        session.save(phone1);
        session.save(phone2);

        transaction.commit();
        session.close();


    }

    public List<PersonEntity> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<PersonEntity> result = session
                .createQuery("FROM PersonEntity", PersonEntity.class)
                .list();

//        System.out.println(result);

        transaction.commit();
        session.close();

        return result;
    }

    public void delete() {

        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            List<PersonEntity> result = session
                    .createQuery("FROM PersonEntity", PersonEntity.class)
                    .list();

            if (result.size() > 0) {
                PersonEntity personEntity = result.get(0);
                session.remove(personEntity);
            }

            transaction.commit();
        }

    }

    public void update(String name) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            List<PersonEntity> result = session
                    .createQuery("FROM PersonEntity", PersonEntity.class)
                    .list();

            result.forEach(personEntity -> personEntity.setName(name));

            transaction.commit();
        }
    }
}
