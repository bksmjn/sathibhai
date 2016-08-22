package com.codebhatti.sathibhai.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class EntityManagerWrapper {
	 @PersistenceContext
	    EntityManager em;

	 public EntityManagerWrapper(){
		 System.out.println("ENTITYMANAGERWRAPPER.....");
	 }
	 
	 	@Transactional(propagation=Propagation.REQUIRED)
	    public <T> T persist(T t) {
	        this.em.persist(t);
	        this.em.flush();
	        this.em.refresh(t);
	        return t;
	    }

	 	@Transactional(propagation=Propagation.REQUIRED)
	    public <T> void persist(List<T> data) {
	        data.stream().forEach(this.em::persist);
	        this.em.flush();
	        this.em.clear();
	    }
	 	@Transactional(propagation=Propagation.REQUIRED)
	    public <T> T merge(T t) {
	        T upT = this.em.merge(t);
	        this.em.flush();
	        return (T) upT;
	    }

	 	@Transactional(propagation=Propagation.REQUIRED)
	    public <T> void remove(T t) {
	        this.em.remove(this.em.merge(t));
	    }

	 	@Transactional(propagation=Propagation.REQUIRED)
	    public <T> void remove(Class<T> type, Object id) {
	        Object item = this.find(type, id);
	        this.em.remove(this.em.merge(item));
	    }

	    public <T> T find(Class<T> type, Object id) {
	        if (id == null) {
	            return null;
	        }
	        return (T) this.em.find(type, id);
	    }

	    @Transactional(propagation=Propagation.REQUIRED)
	    public <T> T findWithTransaction(Class<T> type, Object id,LockModeType lockMode) {
	        if (id == null) {
	            return null;
	        }
	        return (T) this.em.find(type, id,lockMode);
	    }

	    @Transactional(propagation=Propagation.REQUIRED)
	    public void lock(Object entity, LockModeType lockMode) {
	        this.em.lock(entity, lockMode);
	    }

	    @SuppressWarnings("rawtypes")
	    public List findAll(String queryName) {
	        return this.em.createNamedQuery(queryName).getResultList();
	    }

	    @SuppressWarnings("unchecked")
	    public <T> T find(String queryName, QueryParameterCollection parameters) {
	        List<T> list = findAll(queryName, parameters);
	        if (list.size() > 0) {
	            return list.get(0);
	        }
	        return null;

	    }

	    @SuppressWarnings("rawtypes")
	    public List findAll(String namedQueryName, QueryParameterCollection parameters) {
	        return findWithRowLimit(namedQueryName, parameters, 0);
	    }

	    @SuppressWarnings("rawtypes")
	    public <T> List findAll(CriteriaQuery<T> criteriaQuery) {
	        TypedQuery<T> q = this.em.createQuery(criteriaQuery);
	        return q.getResultList();
	    }

	    @SuppressWarnings("rawtypes")
	    public List findWithRowLimit(String queryName, int resultLimit) {
	        return this.em.createNamedQuery(queryName).setMaxResults(resultLimit)
	                .getResultList();
	    }

	    @SuppressWarnings("rawtypes")
	    public List findWithRowLimit(String namedQueryName,
	            QueryParameterCollection parameters, int resultLimit) {

	        Query query = this.em.createNamedQuery(namedQueryName);
	        if (resultLimit > 0) {
	            query.setMaxResults(resultLimit);
	        }
	        for (QueryParameter qp : parameters.getParameters()) {
	            query.setParameter(qp.getParamName(), qp.getValue());
	        }
	        return query.getResultList();
	    }

	    public List findWithPaging(String namedQueryName,
	            QueryParameterCollection collection, int first, int pageSize) {

	        Query query = this.em.createNamedQuery(namedQueryName);
	        query.setFirstResult(first);
	        query.setMaxResults(pageSize);
	        for (QueryParameter parameter : collection.getParameters()) {
	            query.setParameter(parameter.getParamName(), parameter.getValue());
	        }

	        return query.getResultList();
	    }

	    @SuppressWarnings("rawtypes")
	    public List executeDynamicQuery(String query) {
	        Query qry = this.em.createQuery(query);
	        return qry.getResultList();
	    }

	    @SuppressWarnings("unchecked")
	    public <T> T getSingleResult(String queryName,
	            QueryParameterCollection parameters) {
	        try {
	            Query query = this.em.createNamedQuery(queryName);
	            for (QueryParameter parameter : parameters.getParameters()) {
	                query.setParameter(parameter.getParamName(), parameter.getValue());
	            }
	            return (T) query.getSingleResult();
	        } catch (javax.persistence.NoResultException ex) {
	            return null;
	        }
	    }

	    @SuppressWarnings("rawtypes")
	    public <T> T getSingleResult(String queryName) {
	        try {
	            return (T) this.em.createNamedQuery(queryName).getSingleResult();
	        } catch (NoResultException exception) {
	            return null;
	        }
	    }

	    @SuppressWarnings("rawtypes")
	    public List executeNativeQuery(String query, Class type) {
	        return this.em.createNativeQuery(query, type).getResultList();
	    }

	    @SuppressWarnings("rawtypes")
	    public List executeNativeQuery(String query, String mapping, QueryParameterCollection parameters) {
	        Query query1 = this.em.createNativeQuery(query, mapping);
	        for (QueryParameter parameter : parameters.getParameters()) {
	            query1.setParameter(parameter.getParamName(), parameter.getValue());
	        }

	        return query1.getResultList();
	    }

	    @SuppressWarnings("rawtypes")
	    public Object getSingleResultWithNativeQuery(String query, Class type) {
	        try {
	            return this.em.createNativeQuery(query, type).getSingleResult();
	        } catch (NoResultException exception) {
	            return null;
	        }
	    }

	    @SuppressWarnings("rawtypes")
	    public void executeStoreProcedure(String query, StoredProcedureParameterCollection parameterCollection) {
	        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(query);

	        for (StoredProcedureParameter param : parameterCollection.getParameters()) {
	            if (param.getMode() == StoredProcedureParameter.ParamMode.IN) {
	                storedProcedure.registerStoredProcedureParameter(param.getParameterName(), param.getType(), ParameterMode.IN);
	            } else {
	                storedProcedure.registerStoredProcedureParameter(param.getParameterName(), param.getType(), ParameterMode.OUT);
	            }
	            storedProcedure.setParameter(param.getParameterName(), param.getParamValue());
	        }
	        storedProcedure.execute();
	    }

	    @SuppressWarnings("rawtypes")
	    public void executeStoreProcedureAndGetOutPut(String query, StoredProcedureParameterCollection parameterCollection) {
	        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(query);

	        for (StoredProcedureParameter param : parameterCollection.getParameters()) {
	            if (param.getMode() == StoredProcedureParameter.ParamMode.IN) {
	                storedProcedure.registerStoredProcedureParameter(param.getParameterName(), param.getType(), ParameterMode.IN);
	            } else {
	                storedProcedure.registerStoredProcedureParameter(param.getParameterName(), param.getType(), ParameterMode.OUT);
	            }
	            storedProcedure.setParameter(param.getParameterName(), param.getParamValue());
	        }
	        storedProcedure.execute();
	        // get result
	        //    Double tax = (Double)storedProcedure.getOutputParameterValue("tax");
	    }

	    public CriteriaBuilder getCriteriaBuilder() {
	        return this.em.getCriteriaBuilder();
	    }

}
