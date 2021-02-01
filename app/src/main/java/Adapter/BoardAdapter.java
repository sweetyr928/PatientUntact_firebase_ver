package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dotter.patientuntact.MessageActivity;
import com.dotter.patientuntact.R;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import model.Board;

public class BoardAdapter extends RecyclerView.Adapter<Adapter.BoardAdapter.Holder>{

    private Context context;
    private ArrayList<Board> list;


    //어댑터에서 액티비티 액션을 가져올 때 context가 필요한데 어댑터에는 context가 없다.
    //선택한 액티비티에 대한 context를 가져올 때 필요하다.

    public BoardAdapter(Context context, ArrayList<Board> list) {
        this.context = context;
        this.list = list;
    }

    // ViewHolder 생성
    // row layout을 화면에 뿌려주고 holder에 연결
    //실제 리스트뷰가 어댑터에 연결된 다음에 뷰 홀더를 최초로 만들어낸다.
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    /*
     * Todo 만들어진 ViewHolder에 data 삽입 ListView의 getView와 동일
     *
     * */
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        // 각 위치에 문자열 세팅

        holder.nametext.setText(list.get(position).getName());
        holder.titletext.setText(list.get(position).getTitle());

        holder.itemView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra("userid",list.get(position).getId()); // 작성자 id 넘겨주기
                intent.putExtra("name",list.get(position).getName());
                intent.putExtra("title",list.get(position).getTitle());
                context.startActivity(intent);

            }
        });
        //클릭하면 채팅창으로 이동
    }

    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }

    // ViewHolder는 하나의 View를 보존하는 역할을 한다
    public class Holder extends RecyclerView.ViewHolder{
        public TextView nametext;
        public TextView titletext;

        public Holder(View view){
            super(view);
            nametext = (TextView) view.findViewById(R.id.nametext);
            titletext = (TextView) view.findViewById(R.id.titletext);


        }
    }


}
