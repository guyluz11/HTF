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

    @NonNull
    @Override
    public CommonViewHolder<Hackathon> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.item_hackathon, parent, false);
        View view;
        switch (layoutNumber) {
            case 1:
                view = mInflater.inflate(R.layout.item_view_hacktons, parent, false);
                break;
            case 2:
                view = mInflater.inflate(R.layout.item_view_users, parent, false);
                break;
            case img3:
                view = mInflater.inflate(R.layout.item_view_role, parent, false);
                break;
            case 4:
                view = mInflater.inflate(R.layout.item_view_groups, parent, false);
                break;
            default:
                view = mInflater.inflate(R.layout.item_view_hacktons, parent, false);
                break;
        }
        return new HackatonVH(view);
    }

    private class HackatonVH extends CommonViewHolder<Hackathon> implements View.OnClickListener {

//        private TextView tvHeadTitle, tvSubTitle, tvLittleTitle;
//        private ImageView imageHackathon;

        //groups item_view_hacktons my_img
        ImageView hackatonImage;
        TextView hackatonName;
        TextView hackatonLocation;
        TextView hackatonDate;
        ImageView hackatonBookMark;

        //groups item_view_users my_img_t
        ImageView userImage;
        TextView userName;
        TextView userRole;


        //groups item_view_role my_img_tree
//        ImageView userImage;
//        TextView hackatonRole;


        //groups item_view_groups 4
        ImageView groupImage;
        TextView groupName;
        TextView groupDescription;
        ImageView groupMembersImage;
        ImageView groupBookMark;



        public HackatonVH(View v) {
            super(v);
            // find views and set listeners
            itemView.setOnClickListener(this);
            switch (layoutNumber) {
                case 1:
                    hackatonImage = v.findViewById(R.id.hackatonImageImageView_item);
                    hackatonName  = v.findViewById(R.id.hackatonNameTextView_item);
                    hackatonLocation  = v.findViewById(R.id.hackatonLocationTextView_item);
                    hackatonDate  = v.findViewById(R.id.hackatonDateTextView_item);
                    hackatonBookMark  = v.findViewById(R.id.hackatonBookMarkImageView_item);
                    break;
                case 2:
                    userImage = v.findViewById(R.id.userImageImageView_item);
                    userName  = v.findViewById(R.id.userNameTextView_item);
                    userRole  = v.findViewById(R.id.userRoleTextView_item);
                    break;
                case img3:
                    userImage = v.findViewById(R.id.userImageImageView_item);
                    userRole  = v.findViewById(R.id.userRoleTextView_item);
                    break;
                case 4:
                    groupImage = v.findViewById(R.id.groupImageImageView_item);
                    groupName  = v.findViewById(R.id.groupNameTextView_item);
                    groupDescription  = v.findViewById(R.id.groupDescriptionTextView_item);
                    groupMembersImage  = v.findViewById(R.id.groupMembersImageImageView_item);
                    groupBookMark  = v.findViewById(R.id.groupBookMarkImageView_item);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void bindItem(Hackathon item, int position) {
            // fill views from item



            switch (layoutNumber) {
                case 1:
//                    hackatonImage // TODO: Add the image
                    hackatonName.setText(item.getmTitle());
                    hackatonLocation.setText("Tel Aviv");
                    hackatonDate.setText("29.my_img_tree.2019");
//                    hackatonBookMark      // TODO: Add the On click
                    break;
                case 2:
//                    userImage;  // TODO: Add the image
                    userName.setText(user.getmFirstName() + " " + user.getmLastName());
                    userRole.setText("Designer");
                    break;
                case img3:
//                    userImage = v.findViewById(R.id.userImageImageView_item);      // TODO: Add the image
                    userRole.setText(user.getmFirstName() + " " + user.getmLastName());
                    break;
                case 4:
//                    groupImage;        // TODO: Add the image
                    groupName.setText("LYNX");
                    groupDescription.setText("A Just Property & Tax System");
//                    groupMembersImage;        // TODO: Add the image
//                    groupBookMark   // TODO: Add the On click
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (listener != null) listener.onItemClicked(items.get(position), position);
        }
    }

    private void populateUser(List<User> data) {
        user = data.get(0);
    }

}
