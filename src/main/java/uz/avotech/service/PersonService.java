package uz.avotech.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import uz.avotech.domain.PersonEntity;
import uz.avotech.domain.PhoneEntity;
import uz.avotech.domain.Sex;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService implements InitializingBean {

    private final SessionFactory sessionFactory;

    @Override
    public void afterPropertiesSet() throws Exception {

        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("test");
        personEntity.setPassword("testP");
        personEntity.setSex(Sex.MAN);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(personEntity);
        var phone = new PhoneEntity();
        phone.setNumber("12345");
        session.save(phone);
        transaction.commit();
        session.close();

        System.out.println("");

    }
}
