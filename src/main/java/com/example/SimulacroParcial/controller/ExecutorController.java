package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.interfaces.ComentarioRepository;
import com.example.SimulacroParcial.interfaces.PublicacionRepository;
import com.example.SimulacroParcial.interfaces.UsuarioRepository;
import com.example.SimulacroParcial.models.Comentario;
import com.example.SimulacroParcial.models.Publicacion;
import com.example.SimulacroParcial.models.Usuario;
import com.example.SimulacroParcial.services.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.protocol.http.HttpURLConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping("executor")
public class ExecutorController {
  @Autowired
    ExecutorService service;

    @GetMapping("/allContent")
    public ResponseEntity<?> allcontent(){
        CompletableFuture<List<Usuario>> listausers=service.lista1();
        CompletableFuture<List<Publicacion>> listapub=service.lista2();
        CompletableFuture<List<Comentario>> listacom=service.lista3();
        List superlist = new ArrayList();
        superlist.add(listausers.join());
        superlist.add(listapub.join());
        superlist.add(listacom.join());
        return ResponseEntity.status(HttpStatus.OK).body(superlist);
    }


}
