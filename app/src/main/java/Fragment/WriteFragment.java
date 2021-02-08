package Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dotter.patientuntact.MessageActivity;
import com.dotter.patientuntact.R;
import com.dotter.patientuntact.StartActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import Adapter.BoardAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import model.Board;

public class WriteFragment extends Fragment {

    private Context context;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    FirebaseUser fuser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_write, container, false);

        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동
        databaseReference = database.getReference(); // DB 테이블 연결
        fuser = FirebaseAuth.getInstance().getCurrentUser();

        Button button = (Button) rootView.findViewById(R.id.button);
        EditText title_editText = (EditText) rootView.findViewById(R.id.title_edittext);
        EditText name_editText = (EditText) rootView.findViewById(R.id.name_edittext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("id", fuser.getUid());
                hashMap.put("name", name_editText.getText().toString());
                hashMap.put("title", title_editText.getText().toString());
                hashMap.put("match",false);

                databaseReference.child("Board").push().setValue(hashMap);

                title_editText.setText("");
                name_editText.setText("");
                //Toast.makeText(context, "작성 완료!", Toast.LENGTH_SHORT).show();
            }

        });

        return rootView;

    }
}
