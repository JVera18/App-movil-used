package com.example.used.Fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.used.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MensajeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MensajeFragment extends Fragment {
    private EditText editTelefono, editMensaje;
    private Button btnEnviar, btnEliminar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MensajeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MensajeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MensajeFragment newInstance(String param1, String param2) {
        MensajeFragment fragment = new MensajeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mensaje, container, false);
        editMensaje = view.findViewById(R.id.editTextMensaje);
        editTelefono = view.findViewById(R.id.editTextTelefono);
        btnEnviar = view.findViewById(R.id.btn_sms);
        btnEliminar = view.findViewById(R.id.btnEliminar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editMensaje.setText("");
                editTelefono.setText("");
            }
        });

        //para pedir permiso al usuario
        if(ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.SEND_SMS}, 1);
        }
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(editTelefono.getText().toString(), null, editMensaje.getText().toString(), null, null);

                Toast.makeText(getActivity(), "Mensaje Enviado!", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}