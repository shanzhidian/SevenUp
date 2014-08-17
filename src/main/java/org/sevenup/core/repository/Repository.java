package org.sevenup.core.repository;
import org.sevenup.core.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
public interface Repository extends CrudRepository<User,String>{

}
