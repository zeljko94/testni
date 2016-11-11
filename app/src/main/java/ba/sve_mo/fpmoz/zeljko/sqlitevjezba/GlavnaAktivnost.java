package ba.sve_mo.fpmoz.zeljko.sqlitevjezba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import models.Raspored;
import models.RasporedDataSource;

public class GlavnaAktivnost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavna_aktivnost);

        RasporedDataSource rds = new RasporedDataSource(getApplicationContext());
        rds.open();

        System.out.println("ASDASDAD");
        Raspored r =  new Raspored(0, "Daniel Vasić, asist.", "PMA", "Ucionica 109", "11.11.2016 08:00", "11.11.2016 10:00");
        rds.create(r);
        rds.close();
    }
}
