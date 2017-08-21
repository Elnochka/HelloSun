package example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ContactsRepository extends JpaRepository<Contacts, Long> {

    List<Contacts> findByNameNotLike(String name);
    List<Contacts> findByNameNotContaining(String name);

}
