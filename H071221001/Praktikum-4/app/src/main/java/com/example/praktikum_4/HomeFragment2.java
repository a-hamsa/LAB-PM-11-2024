package com.example.praktikum_4;


public final class HomeFragment2 implements ConfirmDialogFragment.DialogListener {
    public final HomeFragment homeFragment;
    public final Model model;

    public HomeFragment2 (HomeFragment homeFragment, Model model) {
        this.homeFragment = homeFragment;
        this.model = model;
    }

    public final void setOnClickDeleteButton() {
        this.homeFragment.HomeFragment2(this.model);
    }
}