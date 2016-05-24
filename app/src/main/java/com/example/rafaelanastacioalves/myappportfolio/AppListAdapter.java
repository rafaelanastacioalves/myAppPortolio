package com.example.rafaelanastacioalves.myappportfolio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rafaelanastacioalves on 5/24/16.
 */
public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {
    private final Context context;
    private String[] appList;
    public TextView mTextView;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button mButtonView;
        public ViewHolder(Button v) {
            super(v);
            mButtonView = v;
        }
    }

    public AppListAdapter(String[] appList, MainActivity mainActivity) {
        this.appList = appList;
        this.context =  mainActivity.getApplicationContext();
    }

    @Override
    public AppListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.app_item_view_holder, parent, false);
        ViewHolder vh = new ViewHolder((Button) v.findViewById(R.id.button_item_app));

        return vh;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.mButtonView.setText(appList[position]);
        holder.mButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                Toast.makeText(context ,"This button will lead to " + button.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }




    @Override
    public int getItemCount() {
        return appList.length;
    }
}
