package com.htf.ui.Fragments.book_mark.adapter_up_down;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.htf.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class GoupAdapter extends RecyclerView.Adapter<GoupAdapter.SecondOptionMenuHolder> {
    private List<String> mListFoodObject;
    private LayoutInflater mInflater;
    private Context mContext;
    private int layoutNumber;


    // Provide a suitable constructor (depends on the kind of data set)
    public GoupAdapter(Context gettingContext, int layoutNumber, List<String> listFoodObject) {
        this.mListFoodObject = listFoodObject;
        this.mContext = gettingContext;
        this.layoutNumber = layoutNumber;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public SecondOptionMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // create a new view
        View view;
        switch (layoutNumber) {
            case 1:
                view = mInflater.inflate(R.layout.item_view_groups, parent, false);
                break;
//            case 2:
//                view = mInflater.inflate(R.layout.item_view_layout_long_list_menu_layout2, parent, false);
//                break;
            default:
                view = mInflater.inflate(R.layout.item_view_groups, parent, false);
                break;
        }
        return new SecondOptionMenuHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(SecondOptionMenuHolder holder, int position) {
        // - get element from your data set at this position
        // - replace the contents of the view with that element
        holder.foodName.setText(mListFoodObject.get(position));
//        holder.price.setText("ghhj");
        //loading the images with glide library
//        Glide.with(mContext).load(R.drawable.backgound_edit_button).into(holder.imageView);

    }

    // Return the size of your data set (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mListFoodObject.size();
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class SecondOptionMenuHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView foodName;
        TextView price;
        ImageView imageView;

        SecondOptionMenuHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.textView7);
//            price = itemView.findViewById(R.id.Price_SecondOption);
//            imageView = itemView.findViewById(R.id.imageView_SecondOption);
        }
    }

}