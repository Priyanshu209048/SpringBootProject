package com.loginrest.Repo;

import com.loginrest.Entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

    @Query("select e from Emp e where e.email = :email")
    public Emp getEmpByEmpName(@Param("email") String email);

}
