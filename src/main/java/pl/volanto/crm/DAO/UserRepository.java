package pl.volanto.crm.DAO;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.volanto.crm.model.User;

public interface UserRepository extends JpaRepository <User, Long> 
{
	Collection<User> findByUsername(String username);
}
