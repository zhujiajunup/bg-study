package spring.boot.in.action;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hzzhujiajun on 2017/7/18.
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
