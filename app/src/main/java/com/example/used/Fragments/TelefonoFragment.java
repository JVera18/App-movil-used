package com.example.used.Fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.used.R;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TelefonoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TelefonoFragment extends Fragment {
    private TextInputLayout inputPhone;
    private Button btnPermiso, btnDirecto, btnContacto;

    private final int PHONE_CALL_CODE = 100; //codigo

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TelefonoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TelefonoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TelefonoFragment newInstance(String param1, String param2) {
        TelefonoFragment fragment = new TelefonoFragment();
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
        View view = inflater.inflate(R.layout.fragment_telefono, container, false);
        inputPhone = view.findViewById(R.id.inputPhone);
        btnPermiso = view.findViewById(R.id.btnPermiso);

        btnPermiso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = inputPhone.getEditText().getText().toString();
                if (phoneNumber != null) {
                    //Comprobar la versión actual de android
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //version_codes -> nos permite ver la versión M que es la número 6 (API 23)
                        //Metodo para la version actual o superior de android 6
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE); //phone_call_code: es la clave
                    }else {
                        OlderVersions(phoneNumber);
                    }
                }
            }
            
            private void OlderVersions(String phoneNumber){
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phoneNumber));
                if (CheckPermission(Manifest.permission.CALL_PHONE)){
                    startActivity(intentCall);
                }else{
                    Toast.makeText(getActivity(), "Permisos denegados", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Phone - Marcación directa
        btnDirecto = view.findViewById(R.id.btnDirecto);
        btnDirecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = inputPhone.getEditText().getText().toString();
                Intent intentDial = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phoneNumber));
                startActivity(intentDial);
            }
        });

        //Phone - visualizar los contactos
        btnContacto = view.findViewById(R.id.btnContacto);
        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCont = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
                startActivity(intentCont);
            }
        });

        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //version superor a 6
        switch (requestCode){
            case PHONE_CALL_CODE:
                String permission = permissions[0];
                int result = grantResults[0];

                if (permission.equals(Manifest.permission.CALL_PHONE)) {
                    //Comprobar si ha sido aceptado o denegado la petición
                    if (result == PackageManager.PERMISSION_GRANTED) { //para ver si acepto el permiso
                        //si consedio el permiso para que la aplicación pueda trabajar
                        String phoneNumber = inputPhone.getEditText().getText().toString();
                        Intent intentCall = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phoneNumber));
                        startActivity(intentCall);
                    }else {
                        Toast.makeText(getActivity(),"Permisos Denegados",Toast.LENGTH_LONG).show();
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }

    private boolean CheckPermission(String permission){
        int result = getActivity().checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}