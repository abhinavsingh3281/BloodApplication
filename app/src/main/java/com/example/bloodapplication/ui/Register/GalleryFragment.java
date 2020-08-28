package com.example.bloodapplication.ui.Register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bloodapplication.MainActivity;
import com.example.bloodapplication.R;
import com.example.bloodapplication.RegisterUser;
import com.example.bloodapplication.Trial;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class GalleryFragment extends Fragment implements View.OnClickListener {

    private GalleryViewModel galleryViewModel;
    private EditText registeremail, registerpassword, registermobilenumber, registername;
private Spinner registerbloodgroup;
    private Button buttonregister;
    private FirebaseAuth mAuth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        registeremail = root.findViewById(R.id.registeremail);
        registerpassword = root.findViewById(R.id.registerpassword);
//        registerbloodgroup = root.findViewById(R.id.registerbloodgroup);
        //Used this as a spinner
        registermobilenumber = root.findViewById(R.id.registermobilenumber);
        registername = root.findViewById(R.id.registername);
        buttonregister = root.findViewById(R.id.buttonregister);
        mAuth = FirebaseAuth.getInstance();

        buttonregister.setOnClickListener(this);



        registerbloodgroup = root.findViewById(R.id.registerbloodgroup);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Select Your Blood Group");
        arrayList.add("A+");
        arrayList.add("A-");
        arrayList.add("B+");
        arrayList.add("B-");
        arrayList.add("O+");
        arrayList.add("O-");
        arrayList.add("AB+");
        arrayList.add("AB-");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        registerbloodgroup.setAdapter(arrayAdapter);
        registerbloodgroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        return root;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//
//        if (mAuth.getCurrentUser() == null) {
//            //handle the already login user
//            startActivity(new Intent(getActivity(), MainActivity.class));
//        }
//    }

    private void registerUser() {
        final String name = registername.getText().toString().trim();
        final String email = registeremail.getText().toString().trim();
        final String password = registerpassword.getText().toString().trim();
        final String phone = registermobilenumber.getText().toString().trim();
        final String bloodgroup = registerbloodgroup.getSelectedItem().toString().trim();

//A+
        if (bloodgroup.equals("A+")) {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                RegisterUser registerUser = new RegisterUser(
                                        name,
                                        email,
                                        phone, bloodgroup, password
                                );


                                FirebaseDatabase.getInstance().getReference("BloodGroupA+")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(registerUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getActivity(), "Successful", Toast.LENGTH_LONG).show();
                                        } else {
                                            //display a failure message
                                        }
                                    }
                                });

                            } else {
                                Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }



        //B+
        if (bloodgroup.equals("B+")) {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                RegisterUser registerUser = new RegisterUser(
                                        name,
                                        email,
                                        phone, bloodgroup, password
                                );


                                FirebaseDatabase.getInstance().getReference("BloodGroupB+")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(registerUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getActivity(), "Successful", Toast.LENGTH_LONG).show();
                                        } else {
                                            //display a failure message
                                        }
                                    }
                                });

                            } else {
                                Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }


        //A-

        if (bloodgroup.equals("A-")) {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                RegisterUser registerUser = new RegisterUser(
                                        name,
                                        email,
                                        phone, bloodgroup, password
                                );


                                FirebaseDatabase.getInstance().getReference("BloodGroupA-")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(registerUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getActivity(), "Successful", Toast.LENGTH_LONG).show();
                                        } else {
                                            //display a failure message
                                        }
                                    }
                                });

                            } else {
                                Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }


        //B-

        if (bloodgroup.equals("B-")) {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                RegisterUser registerUser = new RegisterUser(
                                        name,
                                        email,
                                        phone, bloodgroup, password
                                );


                                FirebaseDatabase.getInstance().getReference("BloodGroupB-")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(registerUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getActivity(), "Successful", Toast.LENGTH_LONG).show();
                                        } else {
                                            //display a failure message
                                        }
                                    }
                                });

                            } else {
                                Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }

        //O+

        if (bloodgroup.equals("O+")) {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                RegisterUser registerUser = new RegisterUser(
                                        name,
                                        email,
                                        phone, bloodgroup, password
                                );


                                FirebaseDatabase.getInstance().getReference("BloodGroupO+")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(registerUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getActivity(), "Successful", Toast.LENGTH_LONG).show();
                                        } else {
                                            //display a failure message
                                        }
                                    }
                                });

                            } else {
                                Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });


        }


        //O-

        if (bloodgroup.equals("O-")) {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                RegisterUser registerUser = new RegisterUser(
                                        name,
                                        email,
                                        phone, bloodgroup, password
                                );


                                FirebaseDatabase.getInstance().getReference("BloodGroupO-")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(registerUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getActivity(), "Successful", Toast.LENGTH_LONG).show();
                                        } else {
                                            //display a failure message
                                        }
                                    }
                                });

                            } else {
                                Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }

        //AB+

        if (bloodgroup.equals("AB+")) {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                RegisterUser registerUser = new RegisterUser(
                                        name,
                                        email,
                                        phone, bloodgroup, password
                                );


                                FirebaseDatabase.getInstance().getReference("BloodGroupAB+")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(registerUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getActivity(), "Successful", Toast.LENGTH_LONG).show();
                                        } else {
                                            //display a failure message
                                        }
                                    }
                                });

                            } else {
                                Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }

        //AB-

        if (bloodgroup.equals("AB-")) {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                RegisterUser registerUser = new RegisterUser(
                                        name,
                                        email,
                                        phone, bloodgroup, password
                                );


                                FirebaseDatabase.getInstance().getReference("BloodGroupAB-")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(registerUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getActivity(), "Successful", Toast.LENGTH_LONG).show();
                                        } else {
                                            //display a failure message
                                        }
                                    }
                                });

                            } else {
                                Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonregister:
                registerUser();
                break;

        }
    }
}