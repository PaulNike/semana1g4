package com.codigo.miprimeraapig.service.impl;

import com.codigo.miprimeraapig.entity.UsuariosEntity;
import com.codigo.miprimeraapig.repository.UsuariosRepository;
import com.codigo.miprimeraapig.service.UsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuariosServiceImpl2 implements UsuariosService {

    private final UsuariosRepository usuariosRepository;

    @Override
    public UsuariosEntity crearUsuario(UsuariosEntity usuariosEntity) {
        return null;
    }

    @Override
    public List<UsuariosEntity> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public UsuariosEntity buscarPorId(Integer id) {
        return null;
    }

    @Override
    public List<UsuariosEntity> buscarPorNombre(String nombres) {
        return usuariosRepository.findByNombres(nombres);
    }

    @Override
    public UsuariosEntity updateUsuario(Long id, UsuariosEntity request) {
        //Primero valido que exista el usuario
        boolean existe = usuariosRepository.existsById(id);
        if(existe){
            //recupero mi usuario
            Optional usuario = usuariosRepository.findById(id);

            // setear datos a actualizar
            //actualizar
            UsuariosEntity usuariosEntity = usuariosRepository.save(getUpdate((UsuariosEntity) usuario.get(),request));

        }
        return null;
    }

    //seteo los datos a cambiar
    private UsuariosEntity getUpdate(UsuariosEntity update, UsuariosEntity request){
        update.setNombres(request.getNombres());
        update.setApellidos(request.getApellidos());
        update.setEstado(request.getEstado());
        return update;
    }

    @Override
    public UsuariosEntity deleteUusuario(Long id) {
        return null;
    }
}
