package kz.itstep.SpringBoot_1.repository;

import kz.itstep.SpringBoot_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.user_name = :name")
    User findByName(String name);
}
