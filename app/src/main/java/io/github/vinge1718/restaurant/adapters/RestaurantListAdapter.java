package io.github.vinge1718.restaurant.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vinge1718.restaurant.Constants;
import io.github.vinge1718.restaurant.R;
import io.github.vinge1718.restaurant.models.Restaurant;
import io.github.vinge1718.restaurant.ui.RestaurantDetailActivity;
import io.github.vinge1718.restaurant.ui.RestaurantDetailFragment;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {
    private ArrayList<Restaurant> mRestaurants = new ArrayList<>();
    private Context mContext;

    public RestaurantListAdapter(Context context, ArrayList<Restaurant> restaurants){
        mContext = context;
        mRestaurants = restaurants;
    }

    @Override
    public RestaurantListAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item, parent, false);
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RestaurantListAdapter.RestaurantViewHolder holder, int position){
        holder.bindRestaurant(mRestaurants.get(position));
    }

    @Override
    public int getItemCount(){
        return mRestaurants.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.restaurantImageView) ImageView mRestaurantImageView;
        @BindView(R.id.restaurantNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;
        private int mOrientation;

        public RestaurantViewHolder(View itemView){
            super(itemView);
            // Determines the current orientation of the device:
            mOrientation = itemView.getResources().getConfiguration().orientation;

            // Checks if the recorded orientation matches Android's landscape configuration.
            // if so, we create a new DetailFragment to display in our special landscape layout:
            if (mOrientation == Configuration.ORIENTATION_LANDSCAPE){
                createDetailFragment(0);
            }
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        // Takes position of restaurant in list as parameter:
        private void createDetailFragment(int position){
            // Creates new RestaurantDetailFragment with the given position:
            RestaurantDetailFragment detailFragment = RestaurantDetailFragment.newInstance(mRestaurants, position);
            // Gathers necessary components to replace the FrameLayout in the layout with the RestaurantDetailFragment:
            FragmentTransaction ft = ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction();
            //  Replaces the FrameLayout with the RestaurantDetailFragment:
            ft.replace(R.id.restaurantDetailContainer, detailFragment);
            // Commits these changes:
            ft.commit();
        }

        public void bindRestaurant(Restaurant restaurant) {
            mNameTextView.setText(restaurant.getName());
            mCategoryTextView.setText(restaurant.getCategories().get(0));
            mRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
            Picasso.get().load(restaurant.getImageUrl()).into(mRestaurantImageView);
        }

        @Override
        public void onClick(View v){
            // Determines the position of the restaurant clicked:
            int itemPosition = getLayoutPosition();
            if(mOrientation == Configuration.ORIENTATION_LANDSCAPE){
                createDetailFragment(itemPosition);
            } else {
                Intent intent = new Intent(mContext, RestaurantDetailActivity.class);
                intent.putExtra(Constants.EXTRA_KEY_POSITION, itemPosition);
                intent.putExtra(Constants.EXTRA_KEY_RESTAURANTS, Parcels.wrap(mRestaurants));
                mContext.startActivity(intent);
            }
        }
    }
}
