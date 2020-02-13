package com.mlaku.dev.poc.repository;

import com.mlaku.dev.poc.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

}
