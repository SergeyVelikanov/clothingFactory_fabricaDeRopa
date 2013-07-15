package com.fabrica;
/**
 * Clase prenda-el tipo de ropa que se fabríca
 */



/**
 * @author Sergey
 * 
 */
public class Prenda
{
	private String nombre,color;
	private int cantidad;
	private double precio;
	
	/**
	 * constructor por defecto
	 */
	public Prenda(){}

	/**
	 * 
	 * @param nombre
	 * @param color
	 * @param cantidad
	 */
	public Prenda(String nombre,String color,int cantidad,double precio){
		this.nombre=nombre;
		this.color=color;
		this.precio=precio;
		this.cantidad=cantidad;
	}

	/**
	 * añadir prenda fabricada al almacen
	 * 
	 * @param pr
	 */

	public void addToAlmacen(Prenda pr){
		Almacen.addPrenda(pr);
	}

	/**
	 * @return the nombre
	 */
	public String getNombre(){
		return this.nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	/**
	 * @return the color
	 */
	public String getColor(){
		return this.color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color){
		this.color=color;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad(){
		return cantidad;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setCantidad(int cantidad){
		this.cantidad=cantidad;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio(){
		return precio;
	}

	/**
	 * @param precio
	 *            the precio to set
	 */
	public void setPrecio(float precio){
		this.precio=precio;
	}

}
