package com.loginrest.Service;

import com.loginrest.Entity.Emp;
import com.loginrest.Repo.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public Emp addEmp(Emp emp) {
        return this.empRepository.save(emp);
    }

}
