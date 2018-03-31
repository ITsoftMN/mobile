package com.example.ayush.test1;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private final Context context;
    private List<Product> products;
    //private ImageLoader imageLoader;

    public class ViewHolder extends RecyclerView.ViewHolder {
        //private ImageView imageView;
       // private CardView cardView;
        private TextView mTextView;
        private TextView mPosText;
        private ViewHolder(View v) {
            super(v);
//            v.setOnClickListener(this);

//            cardView = v.findViewById(R.id.user_card_view);
//            imageView = v.findViewById(R.id.user_img);
            mTextView = v.findViewById(R.id.product_name);
            mPosText = v.findViewById(R.id.product_price);
        }

//        @Override
//        public void onClick(View view) {
//            Intent intent = new Intent(context, LoginImeiActivity.class);
//            intent.putExtra("user_id", users.get(this.getAdapterPosition()).getId());
//            Log.d("", users.get(this.getAdapterPosition()).getId());
//            context.startActivity(intent);
//        }
    }

    public ProductAdapter(Context context, List<Product> users) {
        this.context = context;
        this.products = users;
        //imageLoader = new ImageLoader(context);
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        ProductAdapter.ViewHolder vh = new ProductAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        //imageLoader.DisplayImage(SAFCONSTANT.WEB_URL +"/upload/300x300/"+users.get(position).getAvatar(), holder.imageView);
        holder.mTextView.setText(products.get(position).getName());
        holder.mPosText.setText(products.get(position).getPrice());
      //  setAnimation(holder.cardView, position);
    }

//    private void setAnimation(View viewToAnimate, int position)
//    {
//        Animation animation = AnimationUtils.loadAnimation(context, R.anim.push_left_in);
//        viewToAnimate.startAnimation(animation);
//    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
