package mx.edu.utez.market.services.person;

import mx.edu.utez.market.models.person.Person;
import mx.edu.utez.market.models.person.PersonRepository;
import mx.edu.utez.market.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional //Tiene que ser Javax
public class PersonService {
    @Autowired
    private PersonRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Person>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Person> insert(Person person){
        Optional<Person> exists = this.repository.findByCurp(person.getCurp());
        if(exists.isPresent()){
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "La persona ya se encuentra registrada"
            );
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(person),
                false,
                200,
                "Persona registrada correctamente"
        );
    }

}
