package com.example.agenda.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.agenda.R;
import com.example.agenda.Repository.AppDbContext;
import com.example.agenda.model.Compromisso;
import com.example.agenda.utils.DataPickerListener;

import java.util.Calendar;
import java.util.List;

public class FragmentoVisualizacaoCompromisso extends Fragment implements DataPickerListener {

    private TextView textoCompromissos;
    private TextView textoCompromissoData;

    private AppDbContext _context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_visualizacao_compromisso, container, false);

        textoCompromissos = view.findViewById(R.id.texto_compromissos);
        textoCompromissoData = view.findViewById(R.id.texto_compromissoData);

        Button btnHoje = view.findViewById(R.id.button_hoje);
        Button btnOutraData = view.findViewById(R.id.button_outra_data);

        _context = new AppDbContext(getContext());

        btnHoje.setOnClickListener(b -> mostrarCompromissosDoDiaAtual());

        btnOutraData.setOnClickListener(b -> abrirOutraDataPickerDialog());

        return view;
    }

    private void abrirOutraDataPickerDialog() {
        OutraDataPickerDialog dialog = new OutraDataPickerDialog(this);
        dialog.show(getChildFragmentManager(), "datePicker");
    }

    private void mostrarCompromissosDoDiaAtual() {
        Calendar calendar = Calendar.getInstance();
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        String dataHoje = dia + "/" + mes + "/" + ano;
        List<Compromisso> compromissosHoje = _context.BuscarCompromissosPorData(dataHoje);
        atualizarTextoCompromissos(compromissosHoje);
        textoCompromissoData.setText(dataHoje);
    }

    @SuppressLint("SetTextI18n")
    private void atualizarTextoCompromissos(List<Compromisso> compromissos) {
        if (compromissos.isEmpty()) {
            textoCompromissoData.setText("Nenhum compromisso encontrado.");
        } else {
            StringBuilder builder = new StringBuilder();
            for (Compromisso compromisso : compromissos) {
                builder.append(compromisso.RetornaCompromisso()).append("\n\n");
            }
            textoCompromissos.setText(builder.toString());
        }
    }

    @Override
    public void onDataSelecionada(int ano, int mes, int dia) {
        String dataSelecionada = dia + "/" + (mes + 1) + "/" + ano;
        List<Compromisso> compromissosNaData = _context.BuscarCompromissosPorData(dataSelecionada);
        atualizarTextoCompromissos(compromissosNaData);
        textoCompromissoData.setText(dataSelecionada);
    }
}
