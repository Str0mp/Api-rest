package com.martini.api.repository;

import com.martini.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //SE INDICA QUE ESTA INTERFACE ES UN REPOSITORY
public interface UserRepository extends JpaRepository<User,Long> { //EXTIENDE A JPAREPOSITORY INDICANDO EL CONTENEDOR Y EL TIPO DE DATO DEL ID(PRIMARYKEY)
}
