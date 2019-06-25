package com.example.SimulacroParcial.services;

import com.example.SimulacroParcial.interfaces.ComentarioRepository;
import com.example.SimulacroParcial.interfaces.PublicacionRepository;
import com.example.SimulacroParcial.interfaces.UsuarioRepository;
import com.example.SimulacroParcial.models.Comentario;
import com.example.SimulacroParcial.models.Publicacion;
import com.example.SimulacroParcial.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
@Service
public class ExecutorService {
    @Autowired
    PublicacionRepository publirepo;
    @Autowired
    ComentarioRepository comenrepo;
    @Autowired
    UsuarioRepository userrepo;

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Usuario>> lista1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(userrepo.findAll());
    }
    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Publicacion>> lista2(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(publirepo.findAll());
    }
    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Comentario>> lista3(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(comenrepo.findAll());
    }
}
