package com.example.agenda.Repository;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.agenda.model.Compromisso;

import java.util.ArrayList;
import java.util.List;

public class AppDbContext {
    private SQLiteDatabase _context;

    public AppDbContext(Context context) {
        AppDbHelper dbHelper = new AppDbHelper(context);
        _context = dbHelper.getWritableDatabase();
    }

    public void AddNovoCompromisso(com.example.agenda.model.Compromisso compromisso) {
        ContentValues values = new ContentValues();
        values.put(CompromissoSchema.CompromissoTable.Cols.DESCRICAO, compromisso.getDescricao());
        values.put(CompromissoSchema.CompromissoTable.Cols.DATA, compromisso.getData());
        values.put(CompromissoSchema.CompromissoTable.Cols.HORA, compromisso.getHora());

        _context.insert(CompromissoSchema.CompromissoTable.NAME, null, values);
    }

    public List<Compromisso> BuscarCompromissosPorData(String data) {
        List<com.example.agenda.model.Compromisso> Compromissos = new ArrayList<>();

        try (Cursor cursor = _context.query(
                CompromissoSchema.CompromissoTable.NAME,
                null,
                CompromissoSchema.CompromissoTable.Cols.DATA + " = ?",
                new String[]{data},
                null,
                null,
                null
        )) {
            if (cursor.moveToFirst()) {
                do {
                    int descricaoIndex = cursor.getColumnIndex(CompromissoSchema.CompromissoTable.Cols.DESCRICAO);
                    int dataIndex = cursor.getColumnIndex(CompromissoSchema.CompromissoTable.Cols.DATA);
                    int horaIndex = cursor.getColumnIndex(CompromissoSchema.CompromissoTable.Cols.HORA);

                    String descricao = cursor.getString(descricaoIndex).toString();
                    String dataDoCompromisso = cursor.getString(dataIndex).toString();
                    String hora = cursor.getString(horaIndex).toString();
                    ;
                    Compromissos.add(new com.example.agenda.model.Compromisso(descricao, dataDoCompromisso, hora));
                } while (cursor.moveToNext());
            }
        }

        return Compromissos;
    }
}
