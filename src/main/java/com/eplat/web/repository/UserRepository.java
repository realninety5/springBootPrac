package com.eplat.web.repository;
import java.awt.print.Pageable;
import java.util.List;
import com.eplat.web.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    List<UserModel> findByMarried(boolean married);
//    Page<UserModel> findAll(Pageable pageable);
}
