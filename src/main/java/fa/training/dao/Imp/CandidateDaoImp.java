package fa.training.dao.Imp;

import fa.training.dao.CandidateDao;
import fa.training.enity.Candidate;
import fa.training.enity.EntryTest;
import fa.training.enity.InterView;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author san vui
 * @create 19/10/2021 - 5:37 PM
 * @sanvankhanh@gmail.com
 */
public class CandidateDaoImp implements CandidateDao {
    @Override
    public List<Candidate> findAllCandidate(String skill, int level) {
        List<Candidate> candidates;
        try (Session session = HibernateUtils.getSession()) {

//           create criteriaBuilder
            CriteriaBuilder criteria = session.getCriteriaBuilder();
            CriteriaQuery<Candidate> query = criteria.createQuery(Candidate.class);
            Root<Candidate> root = query.from(Candidate.class);

//           create query
            query.select(root);

//           create where skill = String skill and level = int level
            query.where(criteria.equal(root.get("skill"), skill), criteria.equal(root.get("level"), level));

//           exeQuery
            Query candidateQuery = session.createQuery(query);

//           get List candidate database respon
            candidates = candidateQuery.getResultList();

//           return list candidates
            return (!candidates.isEmpty() ? candidates : null);
        }
    }

    @Override
    public List<Candidate> findAllCandidateLanguage(String foreign_language, String skill) {
        List<Candidate> candidateLanguage;
        try (Session session = HibernateUtils.getSession()) {

//           create criteriaBuilder
            CriteriaBuilder criteria = session.getCriteriaBuilder();
            CriteriaQuery<Candidate> query = criteria.createQuery(Candidate.class);
            Root<Candidate> root = query.from(Candidate.class);

//           create query
            query.select(root);

//           create where skill = String skill and foreign_language = String foreign_language
            query.where(criteria.equal(root.get("foreignLanguage"), foreign_language), criteria.equal(root.get("skill"), skill));

//           exeQuery
            Query candidateQuery = session.createQuery(query);

//           get List candidate database response
            candidateLanguage = candidateQuery.getResultList();

//           return list candidates
            return (!candidateLanguage.isEmpty() ? candidateLanguage : null);
        }
    }

    @Override
    public List<Candidate> findAllCandidateSkillAndEntry(String skill, String result, LocalDate date) {
        List<Candidate> list;
        try (Session session = HibernateUtils.getSession()) {
//           create Query
            NativeQuery query = session.createNativeQuery("SELECT d.candidate_Id,  d.allocation_status, d.cv, d.date_Of_Birth, d.email, d.foreign_language, d.full_Name, d.gender, "
                    + " d.graduation_year, d.level, d.phone, d.remark,  d.skill"
                    + "  FROM Candidate d "
                    + " INNER JOIN  EntryTest e "
                    + "ON d.candidate_Id = e.candidate_Id"
                    + " WHERE d.skill = :skill AND e.result = :result AND e.date = :date").addEntity("Candidate", Candidate.class);
            query.setParameter("skill", skill);
            query.setParameter("result", result);
            query.setParameter("date", date);
            list = query.getResultList();
            return (!list.isEmpty() ? list : null);
        }
    }

    @Override
    public List<Candidate> findAllCandidatePassAndDate(String result, LocalDate date) {
        List<Candidate> candidates;
        try (Session session = HibernateUtils.getSession()) {
//           create criteriaBuilder
            CriteriaBuilder criteria = session.getCriteriaBuilder();
            CriteriaQuery<Candidate> query = criteria.createQuery(Candidate.class);
            Root<Candidate> root = query.from(Candidate.class);
            Join<Candidate, EntryTest> joins = root.join("entryTests", JoinType.INNER);
            Join<Candidate, InterView> join = root.join("interViewList", JoinType.INNER);
            
//           create where date = LocalDate and result = String result(pass)
            Predicate predicate = criteria.equal(join.get("date"), date);
            Predicate predicate1 = criteria.equal(joins.get("result"), result);
            //           assign where date=? result=?
            query.select(root).where(predicate, predicate1);
            //           exeQuery
            Query candidateQuery = session.createQuery(query);
//           get List candidate database response
            candidates = candidateQuery.getResultList();
//           return list candidates
            return (!candidates.isEmpty() ? candidates : null);
        }
    }

    @Override
    public List<Candidate> updateCandidateNull() {
        List<Candidate> candidates = new ArrayList<>();
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            List<Candidate> list = session.createQuery("FROM Candidate").list();
            for (Candidate candidate : list) {
                transaction = session.beginTransaction();
                Scanner sc = new Scanner(System.in);
                if (candidate.getPhone().isEmpty()) {
                    System.out.println("Input phone update: ");
                    String phone = String.valueOf(sc.nextLine());
                    candidate.setPhone(phone);
                }
                if (candidate.getEmail().isEmpty()) {
                    System.out.println("Input email update: ");
                    String email = String.valueOf(sc.nextLine());
                    candidate.setEmail(email);
                }
                if (candidate.getCv().isEmpty()) {
                    System.out.println("Input cv update: ");
                    String cv = String.valueOf(sc.nextLine());
                    candidate.setCv(cv);
                }
                session.update(candidate);
                transaction.commit();
            }
            return null;
        } catch (Exception exception) {
            assert transaction != null;
            transaction.rollback();
        } finally {
            assert session != null;
            session.close();
        }
        return candidates;
    }

    @Override
    public boolean insertCandidate(Candidate candidate) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            Serializable serializable = session.save(candidate);
            transaction.commit();
            return serializable != null;
        }
    }
}
