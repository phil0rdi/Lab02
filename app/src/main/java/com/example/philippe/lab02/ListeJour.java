package com.example.philippe.lab02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListeJour extends AppCompatActivity {

    private static final int[] names = {R.string.lundi, R.string.mardi, R.string.mercredi, R.string.jeudi, R.string.vendredi, R.string.samedi, R.string.dimanche};
    private static final int[] images = {R.drawable.lundi, R.drawable.mardi, R.drawable.mercredi, R.drawable.jeudi, R.drawable.vendredi, R.drawable.samedi, R.drawable.dimanche};
    private static final int[] messages = {R.string.messagelundi, R.string.messagemardi, R.string.messagemercredi, R.string.messagejeudi, R.string.messagevendredi, R.string.messagesamedi, R.string.messagedimanche};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<Journee> sem = new ArrayList<Journee>();

        for (int i = 0; i < 7; i++) {
            sem.add(new Journee(getResources().getString(names[i]), images[i], getResources().getString(messages[i])));
        }

       /* sem.add(new Journee("lundi", R.drawable.lignes, "Lundi, je fais du C++"));
        sem.add(new Journee("mardi", R.drawable.rene, "J’aime les mardis"));
        sem.add(new Journee("mercredi", R.drawable.ic_launcher_background, "wouhou"));
        sem.add(new Journee("jeudi", R.drawable.ic_launcher_background, "youpii"));
        sem.add(new Journee("vendredi", R.drawable.ic_launcher_background, "maaaan"));
        sem.add(new Journee("samedi", R.drawable.ic_launcher_background, "aaaaaallo"));
        sem.add(new Journee("dimanche", R.drawable.ic_launcher_background, "oup! dxza"));*/

        //JourneeAdapter ja = new JourneeAdapter(sem);
        // get activity_main.listview
        // passer ja a ce listView

        ((ListView) findViewById(R.id.list)).setAdapter(new JourneeAdapter(sem));
    }

    class JourneeAdapter extends ArrayAdapter<Journee> {

        JourneeAdapter(List<Journee> sem) {
            super(ListeJour.this, R.layout.row, R.id.textViewJour, sem);
        }//ListeJour est l’activity principale et listeJournee mon ArrayList de Journee

        public View getView(int position, View convertView, ViewGroup parent) {
            JourneeWrapper wrapper;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.row, null);
                wrapper = new JourneeWrapper(convertView);
                convertView.setTag(wrapper);
            } else
                wrapper = (JourneeWrapper) convertView.getTag();
            wrapper.setJournee(getItem(position));
            return convertView;
        }
    }

    class JourneeWrapper {
        private TextView name = null;
        private ImageView face = null;
        private View row = null;

        JourneeWrapper(View row) {
            this.row = row;
        }

        public TextView getName() {
            if (name == null) name = (TextView) row.findViewById(R.id.textViewJour);
            return name;
        }

        public ImageView getFace() {
            if (face == null) face = (ImageView) row.findViewById(R.id.imageViewJour);
            return face;
        }

        public void setJournee(final Journee j) {
            getName().setText(j.getNom());
            getFace().setImageResource(j.getAdresseImage());
            this.row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), j.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
