package com.example.mycleancode.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycleancode.R;
import com.example.mycleancode.data.local.DBHelper;
import com.example.mycleancode.data.model.Repo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.mateware.snacky.Snacky;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.GitHolder> {

    private List<Repo> repos;
    Repo favRepo;
    int repo_id;
    private Activity activity;
    private boolean favorite = false;
    private DBHelper dbHelper;

    public ListAdapter(List<Repo> repos, Activity activity) {
        this.repos = repos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public GitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new GitHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHolder holder, int position) {
        holder.setFieldData(repos.get(position));
    }

    public void remove(Repo item) {
        int position = repos.indexOf(item);
        if (position > -1) {
            repos.remove(position);
            notifyItemRemoved(position);
        }
    }

    public Repo getItem(int position) {
        return repos.get(position);
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    class GitHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView repoName;
        @BindView(R.id.tv_desc)
        TextView repoDesc;
        @BindView(R.id.tv_lang)
        TextView repoLang;
        @BindView(R.id.img_fav)
        ImageView repoFav;

        GitHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setFieldData(final Repo repo) {
            repoName.setText(repo.getName());
            repoDesc.setText(repo.getDescription());
            repoLang.setText(repo.getLanguage());

            repoFav.setOnClickListener(view -> {
                if (!favorite) {
                    dbHelper = new DBHelper(activity);
                    favRepo = new Repo();
                    favRepo.setId(repo.getId());
                    dbHelper.addFavorite(favRepo);
                    repoFav.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_star));
                    Snacky.builder()
                            .setActivity(activity)
                            .setText(R.string.item_favorite)
                            .setDuration(Snacky.LENGTH_LONG)
                            .success()
                            .show();
                } else {
                    dbHelper = new DBHelper(activity);
                    repo_id = favRepo.getId();
                    dbHelper.deleteFavorite(repo_id);
                    repoFav.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_star_borderless));
                    Snacky.builder()
                            .setActivity(activity)
                            .setText(R.string.item_unfavorite)
                            .setDuration(Snacky.LENGTH_LONG)
                            .info()
                            .show();
                }
            });
        }
    }
}
