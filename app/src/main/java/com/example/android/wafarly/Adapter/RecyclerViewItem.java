package com.example.android.wafarly.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.wafarly.DataType.GanralDataType;
import com.example.android.wafarly.R;

import java.util.List;

public class RecyclerViewItem   extends RecyclerView.Adapter<RecyclerViewItem.RecyclerViewItem_ViewHolder> {
    Context context;
    List<GanralDataType> gnraldata;

    public RecyclerViewItem(Context context,  List<GanralDataType> gnraldata) {
        this.context = context;
        this.gnraldata = gnraldata;
    }

    @NonNull
    @Override
    public RecyclerViewItem_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gnrail_item, viewGroup, false);

        return new RecyclerViewItem_ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewItem_ViewHolder recyclerViewItem_viewHolder, int i) {
        GanralDataType data=gnraldata.get(i);
     recyclerViewItem_viewHolder.textdata.setText(data.getDtat());
     recyclerViewItem_viewHolder.imagee.setImageResource(data.getImage());

    }

    @Override
    public int getItemCount() {
        return gnraldata.size();
    }


    public class RecyclerViewItem_ViewHolder extends RecyclerView.ViewHolder {
        TextView textdata;
        ImageView imagee;

        public RecyclerViewItem_ViewHolder(@NonNull View itemView) {
            super(itemView);

            textdata=itemView.findViewById(R.id.textviewitem);
            imagee=itemView.findViewById(R.id.imageitem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GanralDataType data = gnraldata.get(getAdapterPosition());
                    Toast.makeText(context, ""+data.getDtat(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}
