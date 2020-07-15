package online.chat.com.onlinechat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.SimpleHolder> {

    Context context;
    List<String> list;

    public ChatAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chat_adapter_item, parent, false);
        SimpleHolder simpleHolder = new SimpleHolder(view);
        return simpleHolder;
    }

    @Override
    public void onBindViewHolder(SimpleHolder holder, int position) {
        holder.chatonline_item_imgl.setVisibility(View.GONE);
        holder.chatonline_item_txtl.setVisibility(View.GONE);
        holder.chatonline_item_imgr.setVisibility(View.GONE);
        holder.chatonline_item_txtr.setVisibility(View.GONE);

        if (position % 2 == 0) {
            holder.chatonline_item_imgl.setVisibility(View.VISIBLE);
            holder.chatonline_item_txtl.setVisibility(View.VISIBLE);
            holder.chatonline_item_txtl.setText(list.get(position));
        } else {
            holder.chatonline_item_imgr.setVisibility(View.VISIBLE);
            holder.chatonline_item_txtr.setVisibility(View.VISIBLE);
            holder.chatonline_item_txtr.setText(list.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SimpleHolder extends RecyclerView.ViewHolder {

        ImageView chatonline_item_imgl;
        ImageView chatonline_item_imgr;
        TextView chatonline_item_txtr;
        TextView chatonline_item_txtl;

        public SimpleHolder(@NonNull View itemView) {
            super(itemView);
            chatonline_item_imgl = itemView.findViewById(R.id.chatonline_item_imgl);
            chatonline_item_imgr = itemView.findViewById(R.id.chatonline_item_imgr);
            chatonline_item_txtr = itemView.findViewById(R.id.chatonline_item_txtr);
            chatonline_item_txtl = itemView.findViewById(R.id.chatonline_item_txtl);
        }
    }
}