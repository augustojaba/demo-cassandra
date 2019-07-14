/**
 * 
 */
package com.code.jaba.democassandra;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Augusto
 *
 */

@Repository
public interface CassandraRepository extends CrudRepository<Model, Serializable> {
	
	Optional<Model> findByIdAndName(String id, String name);

}
