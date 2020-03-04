package com.example.mycleancode.data.repo;

import com.example.mycleancode.data.model.Repo;

public class GitServices {
    private Repo repo;

    public GitServices(Repo repo) {
        this.repo = repo;
    }

    public void SetRepo(String name, String language) {
        repo.setFullName(name);
        repo.setLanguage(language);
    }

    public Repo getRepo() {
        return repo;
    }
}
