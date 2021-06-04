package com.example.ss06;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdater extends RecyclerView.Adapter {

    private Activity activity;
    private List<Product> listProduct;
    private IOnClickItem iOnClickItemlistener;

    public ProductAdater(Activity activity, List<Product> listProduct,IOnClickItem iOnClickItemlistener){
        this.activity = activity;
        this.listProduct = listProduct;
        this.iOnClickItemlistener = iOnClickItemlistener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.Item_product,parent,false);
        ProductHolder holder = new ProductHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProductHolder vh = (ProductHolder) holder;
        Product product = listProduct.get(position);
        vh.tvTitle.setText(product.getTitle());
        vh.tvDes.setText(product.getDes());
        vh.tvPrice.setText(product.getPrice());
        vh.ivCover.setImageResource(product.getImg());

        vh.itemView.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               iOnClickItemlistener.onClickItem(position);
           }
        });
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public static class ProductHolder extends RecyclerView.ViewHolder{

        private ImageView ivCover;
        private TextView tvTitle;
        private TextView tvDes;
        private TextView tvPrice;

        public ProductHolder( View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.ivCover);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDes = (TextView) itemView.findViewById(R.id.tvDes);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
        }
    }

    public interface IOnClickItem{
        void onClickItem(int position);
    }


}
