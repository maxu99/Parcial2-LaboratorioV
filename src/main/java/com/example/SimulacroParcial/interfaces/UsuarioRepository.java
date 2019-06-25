package com.example.SimulacroParcial.interfaces;

import com.example.SimulacroParcial.models.PublDueñCom;
import com.example.SimulacroParcial.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Query(value = "select p.titulo,u.nombre,count(c.id) as cantidad from usuario u inner join publicacion p on u.id=p.Usuarioid inner join comentario c on p.id=c.Publicacionid",nativeQuery = true)
    List<getResultado> getResultado();
}
