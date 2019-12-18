package com.yair.android5780.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yair.android5780.Entities.ParcelDetails;
import com.yair.android5780.Model.Utils;
import com.yair.android5780.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Yair on 04/12/2019.
 */
public class ParcelDetailsListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<ParcelDetailsListAdapter.ParcelDetailsViewHolder> {


    private Context baseContext;
    List<ParcelDetails> parcels;

    public ParcelDetailsListAdapter(Context baseContext, List<ParcelDetails> parcels) {
        this.baseContext = baseContext;
        this.parcels = parcels;
    }

    @NonNull
    @Override
    public ParcelDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(baseContext).inflate(R.layout.parcel_cardview,
                parent,
                false);

        return new ParcelDetailsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ParcelDetailsListAdapter.ParcelDetailsViewHolder holder, int position) {
        ParcelDetails parcel = parcels.get(position);
        holder.textViewStatus.setText(parcel.getParcelStatus().name());
        holder.textViewType.setText(parcel.getParcelType().name());
        holder.textViewWeight.setText(parcel.getParcelWeight().name());
        holder.textViewAdress.setText(Utils.getPlace(baseContext, parcel.getLatitude(),parcel.getLongitude()));
        //holder.imageViewType.seti
    }

    @Override
    public int getItemCount() {
        return parcels.size();
    }

    public class ParcelDetailsViewHolder extends RecyclerView.ViewHolder{
        TextView textViewStatus, textViewType, textViewWeight,textViewAdress;
        ImageView imageViewType;
        public ParcelDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewStatus = itemView.findViewById(R.id.text_view_status);
           // imageViewType = itemView.findViewById(R.id.image_view_type);
            textViewWeight = itemView.findViewById(R.id.text_view_weight);
            textViewAdress = itemView.findViewById(R.id.text_view_Adress);

            textViewType = itemView.findViewById(R.id.text_view_type);
        }
    }
}
