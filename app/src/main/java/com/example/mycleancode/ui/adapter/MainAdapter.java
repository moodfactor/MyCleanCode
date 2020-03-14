package com.example.mycleancode.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycleancode.R;
import com.example.mycleancode.data.model.Repo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.mateware.snacky.Snacky;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.GitHolder> {

    private List<Repo> repos;
    private MainAdapter.ClickListener clickListener;

    @Inject
    public MainAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
        repos = new ArrayList<>();
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

        GitHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setFieldData(final Repo repo) {
            repoName.setText(repo.getName());
            repoDesc.setText(repo.getDescription());
            repoLang.setText(repo.getLanguage());
        }
    }

    public interface ClickListener {
        void Click(String name);
    }
}
