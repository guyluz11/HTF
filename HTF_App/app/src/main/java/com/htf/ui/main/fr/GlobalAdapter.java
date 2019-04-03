package com.htf.ui.main.fr;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.htf.R;
import com.htf.dto.Hackathon;
import com.htf.dto.User;
import com.htf.lib.recycler.CommonRecyclerAdapter;
import com.htf.lib.recycler.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class GlobalAdapter extends CommonRecyclerAdapter<Hackathon> {
    private LayoutInflater mInflater;
    private Context mContext;
    private int layoutNumber;
    private User user;

    public GlobalAdapter(Context context, int layoutNumber, IOnItemClickListener<Hackathon> listener) {
        super(context, listener);
        this.mContext = context;
        this.layoutNumber = layoutNumber;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ArrayList list = new ArrayList();
        list.add("Designer");
        user = new User("Niv", "Abutbol", list);
//        String  a = FirebaseAuth.getInstance().getCurrentUser().getUid(); //ToDO fix use current user

//        Injection.getProvider().getNetwork().getUser(a, result -> {
//            populateUser(result.data);
//
//        });
    }

    @Override
    public int getItemViewType(int position) {
        return layoutNumber;
    }

    @NonNull
    @Override
    public CommonViewHolder<Hackathon> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.item_hackathon, parent, false);
        View view;
        switch (layoutNumber) {
            case 1:
                view = mInflater.inflate(R.layout.item_view_hacktons, parent, false);
                return new Hackaton1VH(view);
            case 2:
                view = mInflater.inflate(R.layout.item_view_users, parent, false);
                return new Hackaton2VH(view);
            case 3:
                view = mInflater.inflate(R.layout.item_view_role, parent, false);
                return new Hackaton3VH(view);
            case 4:
                view = mInflater.inflate(R.layout.item_view_groups, parent, false);
                return new Hackaton4VH(view);
            default:
                view = mInflater.inflate(R.layout.item_view_hacktons, parent, false);
                return new Hackaton1VH(view);
        }
    }


    private class Hackaton1VH extends CommonViewHolder<Hackathon> implements View.OnClickListener {
        //groups item_view_hacktons my_img
        ImageView hackatonImage;
        TextView hackatonName;
        TextView hackatonLocation;
        TextView hackatonDate;
        ImageView hackatonBookMark;

        Hackaton1VH(View v) {
            super(v);
            hackatonImage = v.findViewById(R.id.hackatonImageImageView_item);
            hackatonName  = v.findViewById(R.id.hackatonNameTextView_item);
            hackatonLocation  = v.findViewById(R.id.hackatonLocationTextView_item);
            hackatonDate  = v.findViewById(R.id.hackatonDateTextView_item);
            hackatonBookMark  = v.findViewById(R.id.hackatonBookMarkImageView_item);

            v.setOnClickListener(this);
        }

        @Override
        public void bindItem(Hackathon item, int position) {
//                    hackatonImage // TODO: Add the image
            hackatonName.setText(item.getmTitle());
            hackatonLocation.setText("Tel Aviv");
            hackatonDate.setText("29.my_img_tree.2019");
//                    hackatonBookMark      // TODO: Add the On click
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (listener != null) listener.onItemClicked(items.get(position), position);
        }
    }

    private class Hackaton2VH extends CommonViewHolder<Hackathon> implements View.OnClickListener {
        //groups item_view_users my_img_t
        ImageView userImage;
        TextView userName;
        TextView userRole;

        public Hackaton2VH(View v) {
            super(v);
            userImage = v.findViewById(R.id.userImageImageView_item);
            userName  = v.findViewById(R.id.userNameTextView_item);
            userRole  = v.findViewById(R.id.userRoleTextView_item);
        }

        @Override
        public void bindItem(Hackathon item, int position) {
//            userImage;  // TODO: Add the image
            userName.setText(user.getmFirstName() + " " + user.getmLastName());
            userRole.setText("Designer");
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (listener != null) listener.onItemClicked(items.get(position), position);
        }

    }

    private class Hackaton3VH extends CommonViewHolder<Hackathon> implements View.OnClickListener{

        //groups item_view_role my_img_tree
        ImageView userImage;
        TextView hackatonRole;


    public Hackaton3VH(View v) {
            super(v);

        userImage = v.findViewById(R.id.userImageImageView_item);
        hackatonRole  = v.findViewById(R.id.userRoleTextView_item);
        }

        @Override
        public void bindItem(Hackathon item, int position) {

//                    userImage = v.findViewById(R.id.userImageImageView_item);      // TODO: Add the image
            hackatonRole.setText(user.getmFirstName() + " " + user.getmLastName());
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (listener != null) listener.onItemClicked(items.get(position), position);
        }

    }

    private class Hackaton4VH extends CommonViewHolder<Hackathon> implements View.OnClickListener{

        //groups item_view_groups 4
        ImageView groupImage;
        TextView groupName;
        TextView groupDescription;
        ImageView groupMembersImage;
        ImageView groupBookMark;
        public Hackaton4VH(View v) {
            super(v);
            groupImage = v.findViewById(R.id.groupImageImageView_item);
            groupName  = v.findViewById(R.id.groupNameTextView_item);
            groupDescription  = v.findViewById(R.id.groupDescriptionTextView_item);
            groupMembersImage  = v.findViewById(R.id.groupMembersImageImageView_item);
            groupBookMark  = v.findViewById(R.id.groupBookMarkImageView_item);
        }

        @Override
        public void bindItem(Hackathon item, int position) {
//                    groupImage;        // TODO: Add the image
            groupName.setText("LYNX");
            groupDescription.setText("A Just Property & Tax System");
//                    groupMembersImage;        // TODO: Add the image
//                    groupBookMark   // TODO: Add the On click
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (listener != null) listener.onItemClicked(items.get(position), position);
        }
    }

}
