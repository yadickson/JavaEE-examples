/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotux.springmvc.dao.impl;

import com.sotux.springmvc.exception.BusinessException;
import com.sotux.springmvc.dao.GenericDAO;
import com.sotux.springmvc.exception.BusinessMessage;
import com.sotux.springmvc.util.StackManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.validation.ValidationException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author debian
 * @param <T>
 * @param <ID>
 */
public class GenericHibernateDAO<T extends Object, ID extends Serializable> implements GenericDAO<T, ID> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public T create() throws BusinessException {
        try {
            return (T) getEntityClass().newInstance();
        } catch (InstantiationException cve) {
            throw new BusinessException(new BusinessMessage("create()", getEntityClass().getSimpleName() + " crete error: " + cve.getMessage()));
        } catch (IllegalAccessException cve) {
            throw new BusinessException(new BusinessMessage("create()", getEntityClass().getSimpleName() + " crete error: " + cve.getMessage()));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ID save(T entity) throws BusinessException {

        Session session = null;
        ID id = null;

        try {

            session = sessionFactory.openSession();
            session.beginTransaction();
            id = (ID) session.save(entity);
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException cve) {
            rollBack(session);
            throw new BusinessException(new BusinessMessage("save()", getEntityClass().getSimpleName() + "[" + entity.toString() + "] save error: " + cve.getMessage()));
        } catch (ValidationException cve) {
            rollBack(session);
            throw new BusinessException(new BusinessMessage("save()", getEntityClass().getSimpleName() + "[" + entity.toString() + "] save error: " + cve.getMessage()));
        } catch (Exception ex) {
            rollBack(session);
            throw new RuntimeException(ex);
        }

        return id;
    }

    @Override
    public void update(ID id, T entity) throws BusinessException {

        Session session = null;

        try {

            session = sessionFactory.openSession();
            session.beginTransaction();

            T temp = (T) session.get(getEntityClass(), id);

            if (temp == null) {
                throw new BusinessException(new BusinessMessage("update(" + id + ")", getEntityClass().getSimpleName() + " [id:" + id + "] not found"));
            }

            session.clear();
            session.update(entity);
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException cve) {
            rollBack(session);
            throw new BusinessException(new BusinessMessage("update(" + id + ")", getEntityClass().getSimpleName() + "[" + entity.toString() + "] update error: " + cve.getMessage()));
        } catch (ValidationException cve) {
            rollBack(session);
            throw new BusinessException(new BusinessMessage("update(" + id + ")", getEntityClass().getSimpleName() + "[" + entity.toString() + "] update error: " + cve.getMessage()));
        } catch (Exception ex) {
            rollBack(session);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public T get(ID id) throws BusinessException {

        Session session = null;
        T entity = null;

        try {

            session = sessionFactory.openSession();
            session.beginTransaction();
            entity = (T) session.get(getEntityClass(), id);

            if (entity == null) {
                throw new BusinessException(new BusinessMessage("get(" + id + ")", getEntityClass().getSimpleName() + " [id:" + id + "] not found"));
            }

            session.getTransaction().commit();
            session.close();

        } catch (HibernateException cve) {
            rollBack(session);
            throw new BusinessException(new BusinessMessage("get(" + id + ")", getEntityClass().getSimpleName() + " get error: " + cve.getMessage()));
        } catch (ValidationException cve) {
            rollBack(session);
            throw new BusinessException(new BusinessMessage("get(" + id + ")", getEntityClass().getSimpleName() + " get error: " + cve.getMessage()));
        } catch (BusinessException ex) {
            rollBack(session);
            throw ex;
        } catch (Exception ex) {
            rollBack(session);
            throw new RuntimeException(ex);
        }

        return entity;
    }

    @Override
    public void delete(ID id) throws BusinessException {

        Session session = null;

        try {

            session = sessionFactory.openSession();
            session.beginTransaction();

            T entity = (T) session.get(getEntityClass(), id);

            if (entity == null) {
                throw new BusinessException(new BusinessMessage("delete(" + id + ")", getEntityClass().getSimpleName() + " [id:" + id + "] not found to delete"));
            }

            session.delete(entity);
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException cve) {
            rollBack(session);
            throw new BusinessException(new BusinessMessage("delete(" + id + ")", getEntityClass().getSimpleName() + " delete error: " + cve.getMessage()));
        } catch (ValidationException cve) {
            rollBack(session);
            throw new BusinessException(new BusinessMessage("delete(" + id + ")", getEntityClass().getSimpleName() + " delete error: " + cve.getMessage()));
        } catch (BusinessException ex) {
            rollBack(session);
            throw ex;
        } catch (Exception ex) {
            rollBack(session);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<T> findAll() throws BusinessException {

        List<T> entities = null;
        Session session = null;

        try {

            session = sessionFactory.openSession();
            session.beginTransaction();
            entities = session.createQuery("from " + getEntityClass().getSimpleName()).list();

            if (entities == null || entities.isEmpty()) {
                throw new BusinessException(new BusinessMessage("findAll()", getEntityClass().getSimpleName() + " list not found"));
            }

            session.getTransaction().commit();
            session.close();

        } catch (HibernateException cve) {
            rollBack(session);
            throw new BusinessException(new BusinessMessage("findAll()", getEntityClass().getSimpleName() + " list error: " + cve.getMessage()));
        } catch (ValidationException cve) {
            rollBack(session);
            throw new BusinessException(new BusinessMessage("findAll()", getEntityClass().getSimpleName() + " list error: " + cve.getMessage()));
        } catch (BusinessException ex) {
            rollBack(session);
            throw ex;
        } catch (Exception ex) {
            rollBack(session);
            throw new RuntimeException(ex);
        }

        return entities;
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private void rollBack(Session session) {
        try {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                session.close();
            }
        } catch (HibernateException exc) {
            System.out.println(StackManager.getInfo(exc));
        }
    }
}
