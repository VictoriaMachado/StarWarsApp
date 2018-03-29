package br.com.fiap.victoriamachado.starwarsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.fiap.victoriamachado.starwarsapp.api.PeopleAPI;
import br.com.fiap.victoriamachado.starwarsapp.model.People;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etCharacterId;
    private Button btSearch;
    private TextView tvName;
    private TextView tvAltura;
    private TextView tvPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCharacterId = (EditText)findViewById(R.id.etCharacterId);
        btSearch = (Button)findViewById(R.id.btSearch);
        tvName = (TextView)findViewById(R.id.tvName);
        tvAltura = (TextView)findViewById(R.id.tvAltura);
        tvPeso = (TextView)findViewById(R.id.tvPeso);

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://swapi.co").build();

                PeopleAPI api = restAdapter.create(PeopleAPI.class);

                api.searchBy(Integer.parseInt(etCharacterId.getText().toString()), new Callback<People>() {
                    @Override
                    public void success(People people, Response response) {
                        tvName.setText(people.getName());
                        tvPeso.setText(people.getPeso());
                        tvAltura.setText(people.getAltura());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

    }

}
