/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco;

import java.math.BigDecimal;

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
        EntidadBancaria Banco = new EntidadBancaria();
        Banco.setIdEntidadBancaria(1);
        Banco.setCodigoEntidadBancaria("codigobanco");
        Banco.setCif("A12345678");
        Banco.setNombre("Bankiebra");
        Banco.setTipoEntidadBancaria(TipoEntidadBancaria.BANCO);
        //--------------------------------------------------------

        //Sucursal1-----------------------------------------------
        SucursalBancaria Sucursal1 = new SucursalBancaria();
        Sucursal1.setIdSucursalBancaria(1);
        Sucursal1.setCodigoSucursal("codigosucursal1");
        Sucursal1.setNombre("Bankiebra_Madrid");

        Sucursal1.setEntidadBancaria(Banco);
        Banco.anyadirSucursalBancaria(Sucursal1);
        //--------------------------------------------------------

        //Sucursal2-----------------------------------------------
        SucursalBancaria Sucursal2 = new SucursalBancaria();
        Sucursal2.setIdSucursalBancaria(2);
        Sucursal2.setCodigoSucursal("codigosucursal2");
        Sucursal2.setNombre("Bankiebra_Valencia");

        Sucursal2.setEntidadBancaria(Banco);
        Banco.anyadirSucursalBancaria(Sucursal2);
        //--------------------------------------------------------

        //Cuenta1-------------------------------------------------
        CuentaBancaria Cuenta1 = new CuentaBancaria();
        Cuenta1.setIdCuentaBancaria(1);
        Cuenta1.setCif("12345678J");
        Cuenta1.setNumeroCuenta("A12345678");
        Cuenta1.setDc(1);
        Cuenta1.setSaldo(3000);

        Cuenta1.setSucursalBancaria(Sucursal1);
        Sucursal1.anyadirCuentaBancaria(Cuenta1);
        //--------------------------------------------------------

        //Cuenta2-------------------------------------------------
        CuentaBancaria Cuenta2 = new CuentaBancaria();
        Cuenta2.setIdCuentaBancaria(1);
        Cuenta2.setCif("16345578G");
        Cuenta2.setNumeroCuenta("B12345078");
        Cuenta2.setDc(2);
        Cuenta2.setSaldo(6500);

        Cuenta2.setSucursalBancaria(Sucursal1);
        Sucursal1.anyadirCuentaBancaria(Cuenta2);
        //--------------------------------------------------------

        //Cuenta2-------------------------------------------------
        CuentaBancaria Cuenta3 = new CuentaBancaria();
        Cuenta3.setIdCuentaBancaria(3);
        Cuenta3.setCif("B4RC3N45");
        Cuenta3.setNumeroCuenta("00SU1Z400");
        Cuenta3.setDc(3);
        Cuenta3.setSaldo(5000000);

        Cuenta3.setSucursalBancaria(Sucursal2);
        Sucursal2.anyadirCuentaBancaria(Cuenta3);
        //--------------------------------------------------------

        //Movimiento1---------------------------------------------
        MovimientoBancario Movimiento1 = new MovimientoBancario();
        Movimiento1.setIdMovimientoBancario(1);
        Movimiento1.setFecha("12-12-2012");
        Movimiento1.setImporte(300);
        Movimiento1.setTipoMovimientoBancario(TipoMovimientoBancario.DEBE);
        Movimiento1.setSaldoTotal(600);
        Movimiento1.setConcepto("Sacar Dinero");

        Movimiento1.setCuentaBancaria(Cuenta1);
        Cuenta1.anyadirMovimientoBancario(Movimiento1);
        //--------------------------------------------------------

        //Movimiento1---------------------------------------------
        MovimientoBancario Movimiento2 = new MovimientoBancario();
        Movimiento2.setIdMovimientoBancario(1);
        Movimiento2.setFecha("12-12-2012");
        Movimiento2.setImporte(400);
        Movimiento2.setTipoMovimientoBancario(TipoMovimientoBancario.HABER);
        Movimiento2.setSaldoTotal(600);
        Movimiento2.setConcepto("Sacar Dinero");

        Movimiento2.setCuentaBancaria(Cuenta1);
        Cuenta1.anyadirMovimientoBancario(Movimiento2);
        //--------------------------------------------------------

        System.out.println(
                "La cuenta "
                + Cuenta1.getNumeroCuenta()
                + " pertenece a la sucursal "
                + Cuenta1.getSucursalBancaria().getNombre()
                + " y a la entidad "
                + Cuenta1.getSucursalBancaria().getEntidadBancaria().getNombre());

        System.out.println(
                "La cuenta "
                + Cuenta2.getNumeroCuenta()
                + " pertenece a la sucursal "
                + Cuenta2.getSucursalBancaria().getCodigoSucursal()
                + " y a la entidad "
                + Cuenta2.getSucursalBancaria().getEntidadBancaria().getCodigoEntidadBancaria());

        System.out.println(
                "La cuenta "
                + Cuenta3.getNumeroCuenta()
                + " pertenece a la sucursal "
                + Cuenta3.getSucursalBancaria().getCodigoSucursal()
                + " y a la entidad "
                + Cuenta3.getSucursalBancaria().getEntidadBancaria().getCodigoEntidadBancaria());


        int count = 0;
        for (MovimientoBancario movimiento : Cuenta1.getListMovimientoBancario()) {
            count++;
                System.out.println(
                        "ID Movimiento: "+
                        movimiento.getIdMovimientoBancario()+
                        ", Fecha: "+
                        movimiento.getFecha()+
                        ", Importe: "+
                        movimiento.getImporte()+
                        ", Tipo: "+
                        movimiento.getConcepto()+
                        ", Saldo: "+
                        movimiento.getConcepto()+
                        ", Concepto: "+
                        movimiento.getConcepto()
                        );
                        
                        
        }



        /*
         * codigo ent.  codigo suc. dc  numrenta
         * 300€debe
         * 400€haber
         */

    }
}
