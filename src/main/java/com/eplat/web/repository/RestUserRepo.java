package com.eplat.web.repository;

import com.eplat.web.model.UserModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(path="users", collectionResourceRel = "users")
public interface RestUserRepo extends PagingAndSortingRepository<UserModel, Long> {
    List<UserModel> findByMarried(@Param("married") boolean married);
}
