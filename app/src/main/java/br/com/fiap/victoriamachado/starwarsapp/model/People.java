package br.com.fiap.victoriamachado.starwarsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rm75283 on 09/09/2016.
 */
public class People {

    private String name;
    @SerializedName("height")
    private String altura;
    @SerializedName("mass")
    private String peso;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}
