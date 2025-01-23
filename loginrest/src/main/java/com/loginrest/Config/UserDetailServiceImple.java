package com.loginrest.Config;

import com.loginrest.Entity.Emp;
import com.loginrest.Repo.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImple implements UserDetailsService {

    @Autowired
    private EmpRepository empRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Emp emp = this.empRepository.getEmpByEmpName(username);

        if(emp == null) {
            throw new UsernameNotFoundException("Could not find user: " + username);
        }
        CustomUserDetail customUserDetail = new CustomUserDetail(emp);

        return customUserDetail;
    }
}
