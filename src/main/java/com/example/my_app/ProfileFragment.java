package com.example.my_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private TextView profileNameTextView;
    private TextView profileEmailTextView;
    private Button editProfileButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Найти элементы UI
        profileNameTextView = view.findViewById(R.id.profileNameTextView);
        profileEmailTextView = view.findViewById(R.id.profileEmailTextView);
        editProfileButton = view.findViewById(R.id.editProfileButton);

        // Установить слушатель кликов для кнопки "Редактировать профиль"
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создать интент для перехода на MainActivity
                Intent intent = new Intent(getActivity(), MainActivity.class);
                // Запустить MainActivity
                startActivity(intent);
            }
        });

        // Установить данные профиля (пример)
        setProfileData("Имя пользователя", "user@example.com");

        return view;
    }

    // Метод для установки данных профиля
    private void setProfileData(String name, String email) {
        profileNameTextView.setText("Имя: " + name);
        profileEmailTextView.setText("Email: " + email);
    }
}
