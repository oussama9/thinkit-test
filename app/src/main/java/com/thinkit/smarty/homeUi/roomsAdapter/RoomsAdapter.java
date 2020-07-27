package com.thinkit.smarty.homeUi.roomsAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkit.smarty.R;
import com.thinkit.smarty.homeUi.Models.Room;

import java.util.List;

public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.RoomsHolder>  {


    private final Context context;
    private final List<Room> rooms;

    public RoomsAdapter(Context context, List<Room> rooms) {
        super();
        this.context = context;
        this.rooms = rooms;

    }

    @NonNull
    @Override
    public RoomsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_item, parent, false);
        return new RoomsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomsHolder holder, int position) {
        Room room = rooms.get(position);
        holder.imgItem.setImageDrawable(context.getDrawable(room.getImage()));
        holder.roomName.setText(room.getName());
        holder.deviceNum.setText(room.getDeviceNumber());
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public class RoomsHolder extends RecyclerView.ViewHolder {
        private ImageView imgItem;
        private TextView deviceNum;
        private TextView roomName;


        public RoomsHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.backgroung_img_item);
            deviceNum = itemView.findViewById(R.id.device_num_item);
            roomName = itemView.findViewById(R.id.room_name_item);
        }
    }
}
