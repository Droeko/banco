/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco;

/**
 *
 * @author alumno
 */
public class ComFpmislataBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new BigDecimal(30.90)
        
        //Banco---------------------------------------------------
        EntidadBancaria Banco=new EntidadBancaria();
        Banco.setIdEntidadBancaria(1);
        Banco.setCodigoEntidadBancaria("codigobanco");
        Banco.setCif("A12345678");
        Banco.setNombre("Bankiebra");
        Banco.setTipoEntidadBancaria(TipoEntidadBancaria.BANCO);
        //--------------------------------------------------------
        
        //Sucursal1-----------------------------------------------
        SucursalBancaria Sucursal1=new SucursalBancaria();
        Sucursal1.setIdSucursalBancaria(1);
        Sucursal1.setCodigoSucursal("codigosucursal1");
        Sucursal1.setNombre("Bankiebra_Madrid");
        
        Sucursal1.setEntidadBancaria(Banco);
        Banco.anyadirSucursalBancaria(Sucursal1);
        //--------------------------------------------------------
        
        //Sucursal2-----------------------------------------------
        SucursalBancaria Sucursal2=new SucursalBancaria();
        Sucursal2.setIdSucursalBancaria(2);
        Sucursal2.setCodigoSucursal("codigosucursal2");
        Sucursal2.setNombre("Bankiebra_Valencia");
        
        Sucursal2.setEntidadBancaria(Banco);
        Banco.anyadirSucursalBancaria(Sucursal2);
        //--------------------------------------------------------
        
        
        
    }
}
