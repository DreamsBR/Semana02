package com.ejercicio01.controller;


import com.ejercicio01.model.Instructor;
import com.ejercicio01.service.InstructorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/instructor")
@Api(value = "/instructor")
public class InstructorController {
    @Autowired
    private InstructorService service;

   @PostMapping("/agregar")
    @ApiOperation(value = "Agregar instructores",httpMethod ="POST", notes = "    {\n" +
            "        \"nombre\": \"Marcos123123\",\n" +
            "        \"apellido\": \"Basurto12321321\",\n" +
            "        \"password\": \"123afadasd\",\n" +
            "        \"email\": \"marcosbr3123101@gmail.com\",\n" +
            "        \"fregistro\": \"2021-10-07T01:07:49.671+00:00\"\n" +
            "    }")
   public ResponseEntity<?> add(@RequestBody Instructor inst){
        service.insert(inst);
        return  new ResponseEntity<>("Created",HttpStatus.CREATED);
   }

    @GetMapping("/listar")
    @ApiOperation(value = "Listar instructores",httpMethod ="GET", notes = "No hay parametros")
    public ResponseEntity<?>listar(){
        Collection<Instructor>itemConstructor= service.findAll();
        return new ResponseEntity<>(itemConstructor, HttpStatus.OK);
    }

   @GetMapping("/buscar/{instructorId}")
   @ApiOperation(value = "Buscar Instructor",httpMethod ="GET" , notes = "Parametro ID Instructor")
   public ResponseEntity<?>buscar(@ApiParam(value = "Id Instructor", required = true) @PathVariable(name = "instructorId") Integer instructorId){
        Instructor inst =  service.findById(instructorId);
        if(inst!=null){
            return new ResponseEntity<>(inst, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Eliminar Instructor",httpMethod ="DELETE" , notes = "Parametro ID Instructor")
    public ResponseEntity<?> delete(@ApiParam(value = "Id Instructor", required = true) @PathVariable(name = "id") Integer id){
        Instructor delInst = service.findById(id);
        if(delInst==null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Instructor no encntrado");
        }
        Map<String, String> respuesta = new HashMap<String, String>();
        respuesta.put("codigo","00");
        respuesta.put("mensaje","Se elimino correctamente el Id : "+ id);
        respuesta.put("fecOperación",new Date().toString());

        service.delete(delInst);
        return new ResponseEntity<>(delInst, HttpStatus.OK);

    }
    @PutMapping("/updateUP/{id}")
    @ApiOperation(value = "Editar Update Instructor",httpMethod ="PUT" , notes = "Parametro ID Instructor")
    public ResponseEntity<?> updateUP(@ApiParam(value = "Id Instructor", required = true) @PathVariable(name = "id") Integer id, @RequestBody Instructor upInstr) {
        Instructor ins = service.findById(id);
        if(ins==null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor no encontrado");
        }
        ins.setNombre(upInstr.getNombre());
        ins.setApellido(upInstr.getApellido());
        ins.setEmail(upInstr.getEmail());
        ins.setPassword(upInstr.getPassword());
        ins.setFregistro(upInstr.getFregistro());
        service.update(ins);
        return new ResponseEntity<>(ins,HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    @ApiOperation(value = "Editar Patch Instructor",httpMethod ="PATCH" , notes = "Parametro ID Instructor")
    public ResponseEntity<?> update(@ApiParam(value = "Id Instructor", required = true) @PathVariable(name = "id") Integer id, @RequestBody Instructor upInstr) {
        Instructor ins = service.findById(id);
        if(ins==null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor no encontrado");
        }
        ins.setNombre(upInstr.getNombre());
        ins.setApellido(upInstr.getApellido());

        service.update(ins);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
