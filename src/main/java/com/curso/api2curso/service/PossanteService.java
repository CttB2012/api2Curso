package com.curso.api2curso.service;

import com.curso.api2curso.model.Possante;
import com.curso.api2curso.repository.PossanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PossanteService {

    public final String ID_NAO_ENCONTRADA = "A id inserida nao foi encontrada. Tente novamente";

    @Autowired
    private PossanteRepository _repository;

    public String cadastrarPossante(Possante possante) {

        String possanteResultado = _repository.save(possante).toString();
        return  possanteResultado;
    }

    public List<Possante> listarTodosPossantes() {

        List<Possante> lista = _repository.findAll();
        return lista;
    }

    public Possante listarPelaId(Long id) {

       Optional<Possante> resultado = _repository.findById(id);
       if (!resultado.isPresent()){
           throw new RuntimeException(ID_NAO_ENCONTRADA);
       }
       return resultado.get();
    }

    public void excluirPossante(Long id) {

        Optional<Possante> resultado = _repository.findById(id);
        if(!resultado.isPresent()){
            throw new RuntimeException(ID_NAO_ENCONTRADA);
        }
        _repository.deleteById(id);
    }
}
