package jpa.util;

import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

public enum ConnectionFactory {


    GET_SESSION();


private final SessionFactory factory;
private final Session session;
private final Transaction transaction;

private ConnectionFactory(){
    factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    session = factory.openSession();
    transaction = session.beginTransaction();
}

public  ConnectionFactory getInstance(){
    return GET_SESSION;
}

public void doPersist(Object s){ session.persist(s);}


public  Session getSession(){
    return session;
}

public void doCommit(){transaction.commit();}

public void closeSession(){
    factory.close();
    session.close();
}

}
