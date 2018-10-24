package io.pivotal.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.pivotal.workshop.domain.Directory;

public interface DirectoryRepository extends CrudRepository<Directory,Long> {

}
