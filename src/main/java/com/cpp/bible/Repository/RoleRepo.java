package com.cpp.bible.Repository;

import com.cpp.bible.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findRoleByName(String name);
}
