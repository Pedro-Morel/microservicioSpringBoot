package com.pedro.microservicioSpringBoot.controllers;

import com.pedro.microservicioSpringBoot.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer("123", "name1", "user1", "password1"),
            new Customer("456", "name2", "user2", "password2"),
            new Customer("789", "name2", "user3", "password3")
    ));

    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomer(){
        return  ResponseEntity.ok(customers);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getCliente(@PathVariable String username){
        for(Customer c : customers){
            if(c.getUsername().equalsIgnoreCase(username)){
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + username + " no encontrado");
    }

    @PostMapping()
    public ResponseEntity<?> postCliente(@RequestBody Customer customer){
        customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente " + customer.getUsername() + " creado correctamente");
    }

    @PutMapping()
    public ResponseEntity<?> putCliente(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getID().equals(customer.getID())){
                c.setName(customer.getName());
                c.setUsername((customer.getUsername()));
                c.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable String id){
        for(Customer c : customers){
            if(c.getID().equals(id)){
                customers.remove(c);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping()
    public ResponseEntity<?> pathCliente(@RequestBody Customer customer){
        for (Customer c : customers){
            if (c.getID().equals(customer.getID())){
                if (customer.getName() != null){
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if(customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }
                return ResponseEntity.ok("Cliente " + customer.getID() + " modificado correctamente");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + customer.getID() + " no encontrado");
    }
}
