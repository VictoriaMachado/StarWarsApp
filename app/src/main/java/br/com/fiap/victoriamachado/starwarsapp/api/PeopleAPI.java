package br.com.fiap.victoriamachado.starwarsapp.api;

import br.com.fiap.victoriamachado.starwarsapp.model.People;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by rm75283 on 09/09/2016.
 */
public interface PeopleAPI {

    @GET("/api/people/{idPeople}")
    public void searchBy(@Path("idPeople") int idPeople, Callback<People> people);
    // método de pesquisa por id fornecido pelo app, retornando como callback um objeto da classe People (model)
}
