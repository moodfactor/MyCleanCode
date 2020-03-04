package com.example.mycleancode.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mycleancode.R;
import com.example.mycleancode.data.model.Repo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.GitHolder> {

    private List<Repo> repos;
    private Context context;

    public MainAdapter(List<Repo> repos, Context context) {
        this.repos = repos;
        this.context = context;
    }

    @NonNull
    @Override
    public GitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new GitHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    class GitHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_repo_name)
        TextView repoName;
        @BindView(R.id.tv_language)
        TextView repoLang;

        GitHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(final Repo repo) {
            repoName.setText(repo.getFullName());
            repoLang.setText(repo.getLanguage());
        }
    }
}
