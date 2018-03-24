package app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.activity.CarListModel;
import app.activity.Makes;
import com.example.githubdemo.app.R;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    List<CarListModel> mItems;

    public CardAdapter() {
        super();
        mItems = new ArrayList<CarListModel>();
    }

    public void addData(Makes mMakes) {
        /*mItems.add(mMakes);*/
        mItems = mMakes.getMakes();
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        CarListModel github = mItems.get(i);
        viewHolder.login.setText(github.name);
        viewHolder.repos.setText("repos: " + github.niceName);
        viewHolder.blog.setText("blog: " + github.id);
    }

    @Override
    public int getItemCount() {
        if (mItems != null) {
            return mItems.size();
        }
        else {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView login;
        public TextView repos;
        public TextView blog;

        public ViewHolder(View itemView) {
            super(itemView);
            login = (TextView) itemView.findViewById(R.id.login);
            repos = (TextView) itemView.findViewById(R.id.repos);
            blog = (TextView) itemView.findViewById(R.id.blog);
        }
    }
}