package com.mypackage.gestion2.model;

public enum InOutEnum {
	Out ("Payment"), In ("Take");
	private String name = "";

	InOutEnum(String name){
		this.name = name;
	}

	public String getName() {  
		return  this.name ;  
	}  

	public String toString(){
		return name;
	}
}
