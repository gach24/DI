/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package examples.unit01.components.table.withdb.repositories;


import examples.unit01.components.table.withdb.dtos.Cliente;

import java.util.List;

/**
 *
 * @author German
 */
public interface IClientesRepository {
    public List<Cliente> getAll();
    public void add(Cliente cliente);
    public void delete(int id);
    public Cliente find(int id);
}
