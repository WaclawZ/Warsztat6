package pl.coderslab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

import java.util.List;

public interface TweetDao extends JpaRepository<Tweet, Long>{

    List<Tweet> findAllByUser(User user);

    List<Tweet> findAllByUserId(Long id);
}
