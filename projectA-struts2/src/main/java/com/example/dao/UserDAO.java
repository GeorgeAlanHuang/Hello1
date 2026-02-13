import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public void registerUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    public User findByUsername(String username) {
        Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }

    public User getUserById(Long id) {
        return session.get(User.class, id);
    }

    public void updateUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }

    public void deleteUser(Long id) {
        Transaction transaction = session.beginTransaction();
        User user = getUserById(id);
        if (user != null) {
            session.delete(user);
        }
        transaction.commit();
    }
}