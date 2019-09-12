package com.example.sqltest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase bancoDeDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //tabela
            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");

            //inserindo dados
//            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Mariana', 25)");
//            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Jonnatas', 25)");
//            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Lennon', 25)");
//            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Maria', 30)");
//            bancoDeDados.execSQL("UPDATE pessoas SET idade =26 WHERE nome ='Jonnatas'");
//            bancoDeDados.execSQL("DELETE FROM pessoas WHERE nome ='Lima'");

//            bancoDeDados.execSQL("DROP TABLE pessoas");
//            Cursor cursor = bancoDeDados.rawQuery("SELECT nome, idade, id FROM pessoas", null);
//            Cursor cursor = bancoDeDados.rawQuery("SELECT nome, idade, id FROM pessoas WHERE idade > 25 AND idade < 30", null);
            Cursor cursor = bancoDeDados.rawQuery("SELECT nome, idade, id FROM pessoas WHERE nome LIKE 'Mar%'", null);

            int indiceColunaName = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceColunaId = cursor.getColumnIndex("id");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("RESULTADO:nome:", cursor.getString(indiceColunaId) + " | " + cursor.getString(indiceColunaName) + " | " + cursor.getString(indiceColunaIdade));
                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
