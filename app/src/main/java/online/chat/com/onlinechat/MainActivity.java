package online.chat.com.onlinechat;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RelativeLayout root_layout;
    RecyclerView chatonline_rv;
    ArrayList<String> chatList = new ArrayList<>();
    ChatAdapter  chatAdapter;


    EditText chatonline_msg;
    Button chatonline_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        root_layout = findViewById(R.id.root_layout);
        chatonline_rv = findViewById(R.id.chatonline_rv);

        chatonline_msg = findViewById(R.id.chatonline_msg);
        chatonline_send = findViewById(R.id.chatonline_send);

        for(int i = 0 ; i < 10; i++){
            chatList.add("内容" + i);
        }

        chatonline_rv.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdapter(this,chatList);
        chatonline_rv.setAdapter(chatAdapter);

        root_layout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if(oldBottom != -1 && oldBottom > bottom){
                    setToBottom();
                }
            }
        });

        chatonline_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatList.add(chatonline_msg.getText().toString());
                chatonline_msg.requestFocus();
                chatonline_msg.setText("");
                chatAdapter.notifyDataSetChanged();
                setToBottom();
            }
        });

        setToBottom();
    }

    void setToBottom() {
        chatonline_rv.requestLayout();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                chatonline_rv.scrollToPosition(chatList.size() - 1);
            }
        });
    }
}
