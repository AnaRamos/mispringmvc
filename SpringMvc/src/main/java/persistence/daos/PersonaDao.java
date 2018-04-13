package persistence.daos;
import org.springframework.data.jpa.repository.JpaRepository;
import persistence.entities.Persona;

public interface PersonaDao extends JpaRepository<Persona, Integer>{

}
