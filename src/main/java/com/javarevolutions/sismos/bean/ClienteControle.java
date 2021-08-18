/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarevolutions.sismos.bean;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.javarevolutions.sismos.dominio.Cliente;
import com.javarevolutions.sismos.repositorio.ClienteRepositorio;
import javax.faces.view.ViewScoped;

/**
 *
 * @author JavaRevolutions
 */
@Named(value = "clienteC")
@ViewScoped
public class ClienteControle implements Serializable {

    private static final long serialVersionUID = 1L;
    private int numero = 1;
 
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    private Cliente cliente;

    public void carrega2(){
        cliente = clienteRepositorio.findAll().get(0);
        numero++;
        cliente.setEmail("email@alt.com" + numero);
    }
    
    private void buscarClienteBd() {
        cliente = clienteRepositorio.findAll().get(0);
    }

//    getters e setters
    public Cliente getCliente() {
        if (cliente == null) {
            buscarClienteBd();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
