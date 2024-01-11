/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Purchase;
import java.util.List;
import java.util.function.Predicate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

/**
 *
 * @author pupil
 */
public abstract class PurchaseFacade extends AbstractFacade<Purchase> {
     private EntityManager em;

    public PurchaseFacade() {
        super(Purchase.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV22ShopPU");
        this.em = emf.createEntityManager();
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Purchase> findPurchaseOfMonth(int numYear, int numMonth) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Purchase> cq = cb.createQuery(Purchase.class);
        Root<Purchase> root = cq.from(Purchase.class);

        // Создаем предикат для условия поиска по месяцу
         javax.persistence.criteria.Predicate monthPredicate =  cb.equal(cb.function("MONTH", Integer.class, root.get("date")), numMonth);

        // Добавляем предикат в запрос
        cq.where((Expression<Boolean>) monthPredicate);

        // Выполняем запрос
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public List<Purchase> findPurchaseOfYear(int numYears) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Purchase> cq = cb.createQuery(Purchase.class);
        Root<Purchase> root = cq.from(Purchase.class);

        // Создаем предикат для условия поиска по месяцу
         javax.persistence.criteria.Predicate monthPredicate =  cb.equal(cb.function("YEAR", Integer.class, root.get("date")), numYears);

        // Добавляем предикат в запрос
        cq.where((Expression<Boolean>) monthPredicate);

        // Выполняем запрос
        return getEntityManager().createQuery(cq).getResultList();
    }
    
   public List<Purchase> findPurchaseOfDay(int numYear, int numMonth, int numDay ) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Purchase> cq = cb.createQuery(Purchase.class);
        Root<Purchase> root = cq.from(Purchase.class);

        // Создаем предикаты для условий поиска по году, месяцу и дню
         javax.persistence.criteria.Predicate yearPredicate = cb.equal(cb.function("YEAR", Integer.class, root.get("date")), numYear);
         javax.persistence.criteria.Predicate monthPredicate = cb.equal(cb.function("MONTH", Integer.class, root.get("date")), numMonth);
         javax.persistence.criteria.Predicate dayPredicate = cb.equal(cb.function("DAY", Integer.class, root.get("date")), numDay);

        // Соединяем предикаты с помощью логических операторов AND
         javax.persistence.criteria.Predicate finalPredicate = cb.and(yearPredicate, monthPredicate, dayPredicate);


        // Добавляем предикат в запрос
        cq.where((Expression<Boolean>) finalPredicate);

        // Выполняем запрос
        return getEntityManager().createQuery(cq).getResultList();
    }
}
