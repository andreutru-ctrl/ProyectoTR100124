package com.example.proyectoTR100124.service.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.proyectoTR100124.model.Categoria;
import com.example.proyectoTR100124.repository.ICategoriaRepository;
import com.example.proyectoTR100124.service.ICategoriaService;

import java.util.List;

@Primary
@Service
public class CategoriasServiceJpa implements ICategoriaService {

    @Autowired
    private ICategoriaRepository repoCategoria;

    @Override
    public List<Categoria> buscarTodas() {
        return repoCategoria.findAll();
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        return repoCategoria.findById(idCategoria).orElse(null);
    }

    @Override
    public void guardar(Categoria categoria) {
        repoCategoria.save(categoria);
    }

    @Override
    public void eliminar(Integer idCategoria) {
        repoCategoria.deleteById(idCategoria);
    }
}